import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Products.css';
import AddProduct from './AddProduct';

function Products() {
    const [products, setProducts] = useState([]);
    const [vendors, setVendors] = useState([]);
    const [showComponent, setShowComponent] = useState(true);

    function ShowProducts() {
        return (
            <div id="products-container">
                <h1 className="products-heading">Our Products</h1>
                <ul className="products-list">
                    {products.map(product => (
                        <li key={product.id} className="product-item">
                            <h2 className="product-name">{product.name}</h2>
                            <p className="product-description">{product.description}</p>
                            <p className="product-price">Rs. {product.price}</p>
                            <p className="product-vendor">{getVendorName(product.vendor)} product</p>
                            <button class="product-button">Delete</button>
                            <button class="product-button">Update</button>
                            <button class="product-button">Add to Cart</button>
                        </li>
                    ))}
                </ul>
            </div>
        );
    }

    useEffect(() => {
        axios.get('http://localhost:4000/products')
            .then(response => {
                setProducts(response.data);
            })
            .catch(error => {
                console.error('Error fetching products:', error);
            });

        axios.get('http://localhost:4000/vendors')
            .then(response => {
                setVendors(response.data);
            })
            .catch(error => {
                console.error('Error fetching vendors:', error);
            });

    }, []);

    const getVendorName = (vendorId) => {
        const vendor = vendors.find(v => v.id === vendorId);
        return vendor ? vendor.name : 'Unknown Vendor';
    };

    const showAddProductForm = (e) => {
        e.preventDefault();
        setShowComponent(!showComponent);
        console.log("Add Product Form");

    };

    return (
        <div>
            {
                (showComponent) ?
                    <ShowProducts></ShowProducts>
                    :
                    <AddProduct></AddProduct>
            }
            {
                (showComponent) ? 
                    <button id="add-product-button" onClick={showAddProductForm}>
                        Add Product
                    </button> 
                : 
                    <button id="add-product-button" onClick={showAddProductForm}>
                        Show Products
                    </button>
            }
        </div>
    );
}

export default Products;
