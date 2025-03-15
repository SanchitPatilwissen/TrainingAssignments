import { useState, useEffect } from 'react';
import axios from 'axios';

function Cart() {
    const [order, setOrder] = useState({ "id": "", "products": [], "user": "", "totalPrice": 0 });

    useEffect(() => {
        axios.get('http://localhost:4000/cart')
            .then(response => {
                setOrder(response.data[0]);
            })
            .catch(error => {
                console.error('Error fetching cart:', error);
            });
    }, []);

    function assignValue(e) {
        setOrder({ ...order, [e.target.name]: e.target.value });
    }

    return (
        <div id="orders-container">
            <h1 className="orders-heading">Cart</h1>
            <p className="order-quantity">Order ID: <input type="text" value={order.id} onChange={assignValue} name="id" required></input></p>
            <p className="order-quantity">User: <input type="text" value={order.user} onChange={assignValue} name="user" required></input> </p>

            <ul id="orders-list">
                {order.products.map((product) => (
                    <li key={product.id} className="order-item">
                        <span>{product.name} - Quantity: {product.quantity}</span>
                        <button
                            className="delete-product-button"
                        >
                            Delete
                        </button>
                    </li>
                ))}
            </ul>

            <p className="order-quantity">Total Price: {order.totalPrice}</p>
            <button className="place-order-button">Place Order</button>
        </div>

    );
}

export default Cart;
