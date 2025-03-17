import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import './VendorDetail.css';

function VendorDetail(props) {
    const { id } = useParams(); 
    const [products, setProducts] = useState([]); 
    const [vendorProducts, setVendorProducts] = useState([]); 

    useEffect(() => {
        axios.get("http://localhost:4000/products")
            .then(response => {
                setProducts(response.data); 
            })
            .catch(error => {
                console.error("Error fetching products:", error);
            });
    }, []); 

    useEffect(() => {
        const filteredProducts = products.filter(product => product.vendor == id);
        setVendorProducts(filteredProducts); 
    }, [products, id]); 

    return (
        <div id="vendor-detail-container">
            <h1>Vendor Details</h1>
            <h2>Products by Vendor {id}</h2>
            <ul id="vendor-products-list">
                {vendorProducts.length > 0 ? (
                    vendorProducts.map(product => (
                        <li key={product.id}>
                            <h3>{product.name}</h3>
                            <p>{product.description}</p>
                            <p className="product-price">Price: Rs. {product.price}</p>
                            <p className="product-quantity">Quantity: {product.quantity}</p>
                        </li>
                    ))
                ) : (
                    <p id="no-products-message">No products found for this vendor.</p>
                )}
            </ul>
        </div>
    );
}

export default VendorDetail;
