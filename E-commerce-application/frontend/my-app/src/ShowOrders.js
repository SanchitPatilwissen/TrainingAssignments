import React, { useState, useEffect } from "react";
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';

function ShowOrderDetails() {
    let {id} = useParams();
    const [selectedOrder, setSelectedOrder] = useState([]);


    useEffect(() => {
        axios.get(`http://localhost:4000/orders/${id}`)
            .then(response => {
                setSelectedOrder(response.data);
            })
            .catch(error => {
                console.error('Error fetching order details:', error);
            });
        setSelectedOrder(selectedOrder.find(order => order.id === id));
    }, [id]);

    return (
        <div id="orders-container">
            <h1 className="orders-heading">Order Details</h1>
            <ul id="orders-list">
                {selectedOrder[id].products.map((product) => (
                    <li key={product.id} className="order-item">
                        <p className="order-quantity">Product Name: {product.name}</p>
                        <p className="order-quantity">Quantity: {product.quantity}</p>
                    </li>
                ))}
            </ul>
            <button onClick={() => {
                    navigate = useNavigate();
                    navigate("/orders");
                }
            } className="back-to-orders-button">Back to Orders</button>
        </div>
    );
}

export default ShowOrderDetails;
