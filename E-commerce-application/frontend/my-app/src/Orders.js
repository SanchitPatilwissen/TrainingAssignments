import { useState, useEffect } from 'react';
import axios from 'axios';

function Orders() {
    const [showOrder, setShowOrder] = useState(true); // Toggle between order list and details view
    const [orders, setOrders] = useState([]); // Store fetched orders
    const [selectedOrder, setSelectedOrder] = useState(null); // Store the selected order for detailed view

    // Fetch orders on component mount
    useEffect(() => {
        axios.get('http://localhost:4000/orders')
            .then(response => {
                setOrders(response.data);
            })
            .catch(error => {
                console.error('Error fetching orders:', error);
            });
    }, []);

    // Delete order function
    function deleteOrder(id) {
        let deleteValue = window.confirm("Are you sure you want to delete this order?");
        if (!deleteValue) {
            return;
        }
        axios.delete(`http://localhost:4000/orders/${id}`)
            .then(response => {
                console.log('Order deleted:', response.data);
                setOrders(orders.filter(order => order.id !== id)); // Update state after deleting
            })
            .catch(error => {
                console.error('Error deleting order:', error);
            });
    }

    // Toggle between showing orders or the details of a single order
    function toggleShowOrder() {
        setShowOrder(!showOrder);
    }

    // Show the details of a specific order (products)
    function ShowOrderDetails() {
        if (!selectedOrder) return null;

        return (
            <div id="orders-container">
                <h1 className="orders-heading">Order Details</h1>
                <ul id="orders-list">
                    {selectedOrder.products.map((product) => (
                        <li key={product.id} className="order-item">
                            <p className="order-quantity">Product Name: {product.name}</p>
                            <p className="order-quantity">Quantity: {product.quantity}</p>
                        </li>
                    ))}
                </ul>
                <button onClick={toggleShowOrder} className="back-to-orders-button">Back to Orders</button>
            </div>
        );
    }

    // Show the list of all orders
    function ShowOrders() {
        return (
            <div id="orders-container">
                <h1 className="orders-heading">Orders</h1>
                <ul id="orders-list">
                    {orders.map((order) => (
                        <li key={order.id} className="order-item" onClick={() => { setSelectedOrder(order); toggleShowOrder(); }}>
                            <p className="order-quantity">Order ID: {order.id}</p>
                            <p className="order-product">User: {order.user}</p>
                            <p className="order-quantity">Total Price: {order.totalPrice}</p>
                            <button className="delete-order-button" onClick={(e) => { e.stopPropagation(); deleteOrder(order.id); }}>Delete</button>
                        </li>
                    ))}
                </ul>
            </div>
        );
    }

    return (
        showOrder ? <ShowOrders /> : <ShowOrderDetails />
    );
}

export default Orders;
