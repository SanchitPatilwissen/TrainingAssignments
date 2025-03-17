import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Products.css';
import AddProduct from './AddProduct';

function Products() {
    const [products, setProducts] = useState([]);
    const [vendors, setVendors] = useState([]);
    const [showComponent, setShowComponent] = useState(true);
    const [cart, setCart] = useState({ "id": "", "products": [], "user": "", "totalPrice": 0 });

    useEffect(() => {
        axios.get('http://localhost:4000/vendors')
            .then(response => {
                setVendors(response.data);
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

        axios.get('http://localhost:4000/cart')
            .then(response => {
                setCart(response.data);
            })
            .catch(error => {
                console.error('Error fetching cart:', error);
            });
    }, []);

    const getVendorName = (vendorId) => {
        const vendor = vendors.find(v => v.id == vendorId);
        return vendor ? vendor.name : 'Unknown Vendor';
    };

    const showAddProductForm = (e) => {
        e.preventDefault();
        setShowComponent(!showComponent);
    };

    const findProductInCart = (id) => {
        console.log(cart);
        return cart.products.find(product => product.id === id);
    };

    const addToCart = (id, name, price) => {
        const productInCart = findProductInCart(id);

        if (productInCart) {
            productInCart.quantity += 1;
        } else {
            cart.products.push({ "id" : id, "name" : name, "quantity": 1 });
        }

        const updatedTotalPrice = cart.totalPrice + price;
        const updatedCart = { ...cart, totalPrice: updatedTotalPrice };

        axios.put('http://localhost:4000/cart', updatedCart)
            .then(response => {
                setCart(updatedCart);
            })
            .catch(error => {
                console.error('Error updating cart:', error);
            });

        const updatedProducts = products.map(product => {
            if (product.id === id) {
                return { ...product, "quantity": product.quantity - 1 };
            }
            return product;
        });

        setProducts(updatedProducts);

        axios.put(`http://localhost:4000/products`, updatedProducts)
            .then(response => {
                console.log('Product quantity updated:', response.data);
            })
            .catch(error => {
                console.error('Error updating product quantity:', error);
            });

        alert("Product added to cart successfully");
    };

    const deleteProduct = (id) => {
        let deleteValue = window.confirm("Are you sure you want to delete this product?");
        if (deleteValue) {
            axios.delete(`http://localhost:4000/products/${id}`)
                .then(response => {
                    setProducts(products.filter(product => product.id !== id));
                })
                .catch(error => {
                    console.error('Error deleting product:', error);
                });
        }
    };

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
                            <p className="product-quantity">Quantity: {product.quantity}</p>
                            <button className="product-button" onClick={() => deleteProduct(product.id)}>Delete</button>
                            <button className="product-button">Update</button>
                            <button className="product-button" onClick={() => addToCart(product.id, product.name, product.price)}>Add to Cart</button>
                        </li>
                    ))}
                </ul>
            </div>
        );
    }

    return (
        <div>
            {showComponent ? <ShowProducts /> : <AddProduct vendors={vendors} products={products} />}
            <button id="add-product-button" onClick={showAddProductForm}>
                {showComponent ? 'Add Product' : 'Show Products'}
            </button>
        </div>
    );
}

export default Products;
