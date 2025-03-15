import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Products.css';
import AddProduct from './AddProduct';

function Products() {
    const [products, setProducts] = useState([]);
    const [vendors, setVendors] = useState([]);
    const [showComponent, setShowComponent] = useState(true);
    
    useEffect(() => {
        axios.get('http://localhost:4000/vendors')
            .then(response => {
                setVendors(response.data);
                console.log(response.data);
            })
            .catch(error => {
                console.error('Error fetching vendors:', error);
            });

        axios.get('http://localhost:4000/products')
            .then(response => {
                setProducts(response.data);
            })
            .catch(error => {
                console.error('Error fetching products:', error);
            });

    }, []);
    
    function deleteProduct(id) {
        let deleteValue = window.confirm("Are you sure you want to delete this product?");
        if(deleteValue){
            axios.delete(`http://localhost:4000/products/${id}`)
                .then(response => {
                    console.log('Product deleted:', response.data);
                    setProducts(products.filter(product => product.id !== id));
                })
                .catch(error => {
                    console.error('Error deleting product:', error);
                });
        }
    }

    function updateProduct(id) {

    }
    
    const getVendorName = (vendorId) => {
        console.log(vendorId);
        const vendor = vendors.find(v => v.id == vendorId);
        console.log(vendors);
        return vendor ? vendor.name : 'Unknown Vendor';
    };

    const showAddProductForm = (e) => {
        e.preventDefault();
        setShowComponent(!showComponent);
        console.log("Add Product Form");
        
    };
    
    function ShowProducts() {
        const [cart, setCart] = useState({ "id": "", "products": [], "user": "", "totalPrice": 0 });

        useEffect(() => {
            axios.get('http://localhost:4000/cart')
                .then(response => {
                    setCart(response.data[0]);
                })
                .catch(error => {
                    console.error('Error fetching cart:', error);
                });
        }, []);

        const findProduct = (id, name) => {
            for(let i = 0; i < cart.products.length; i++){
                if(cart.products[i].id == id){
                    cart.products[i].quantity++;
                    return;
                }
            }
            cart.products.push({"id": id, "name": name, "quantity": 1});
        };

        const addToCart = (id, name, price) => {
            findProduct(id, name);
            cart.totalPrice += price;
            axios.put('http://localhost:4000/cart', cart)
                .then(response => {
                    console.log('Cart updated:', response.data);
                })
                .catch(error => {
                    console.error('Error updating cart:', error);
                });
            products[id-1].quantity--;
            alert("Product added to cart successfully");
        };

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
                            <p className="product-quantity">Quantity: {product.quantity}</p>                            
                            <button class="product-button" onClick={(e) => deleteProduct(product.id)}>Delete</button>
                            <button class="product-button">Update</button>
                            <button class="product-button" onClick={()=>{addToCart(product.id, product.name, product.price)}}>Add to Cart</button>
                        </li>
                    ))}
                </ul>
            </div>
        );
    }

    return (
        <div>
            {
                (showComponent) ?
                <ShowProducts></ShowProducts>
                :
                <AddProduct vendors={vendors} products={products}></AddProduct>
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
