import { useState, useEffect } from 'react';
import axios from 'axios';

function Cart() {
    const [order, setOrder] = useState({ "id": "", "products": [], "user": "", "totalPrice": 0 });

    useEffect(() => {
        axios.get('http://localhost:4000/cart')
            .then(response => {
                setOrder(response.data);
            })
            .catch(error => {
                console.error('Error fetching cart:', error);
            });
    }, [order]);

    function assignValue(e) {
        setOrder({ ...order, [e.target.name]: e.target.value });
    }

    function placeOrder() {
        axios.post('http://localhost:4000/orders', order)
            .then(response => {
                console.log('Order placed:', response.data);
                alert("Order placed successfully");
                window.location.reload();
            })
            .catch(error => {
                console.error('Error placing order:', error);
            });
    }

    return (
        <form id="orders-container" onSubmit={placeOrder}>
            <h1 class="orders-heading">Cart</h1>
            <p class="order-quantity">Order ID: <input type="text" value={order.id} onChange={assignValue} name="id" required></input></p>
            <p class="order-quantity">User: <input type="text" value={order.user} onChange={assignValue} name="user" required></input> </p>

            <ul id="orders-list">
                {order.products.map((product) => (
                    <li key={product.id} class="order-item">
                        <span>{product.name} - Quantity: {product.quantity}</span>
                        <button
                            class="delete-product-button"
                            onClick={() => {
                                const updatedProducts = order.products.filter(p => p.id !== product.id);

                                setOrder(prevOrder => {
                                    const updatedOrder = {
                                        ...prevOrder,
                                        products: updatedProducts,
                                        totalPrice: prevOrder.totalPrice - product.price * product.quantity
                                    };

                                    // Send updated order to the server
                                    axios.put('http://localhost:4000/cart', updatedOrder)
                                        .then(response => {
                                            console.log('Cart updated:', response.data);
                                        })
                                        .catch(error => {
                                            console.error('Error updating cart:', error);
                                        });

                                    return updatedOrder;
                                });
                            }}
                        >
                            Delete
                        </button>
                    </li>
                ))}
            </ul>

            <p class="order-quantity">Total Price: {order.totalPrice}</p>
            <button class="place-order-button">Place Order</button>
        </form>

    );
}

export default Cart;
