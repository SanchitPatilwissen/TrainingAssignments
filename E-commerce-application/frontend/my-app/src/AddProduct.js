import "./AddProduct.css";
import axios from "axios";
import { useState } from "react";

function AddProduct(props) {
    const [product, setProduct] = useState({ "id": "", "name": "", "price": 0, "description": "", "quantity": 0, "vendor": 0 });

    const assignValue = (e) => {
        setProduct({ ...product, [e.target.name]: e.target.value });
    };

    const insertProduct = (e) => {
        e.preventDefault();
        if(props.products.find(p => p.id == product.id)){
            alert("Product with this ID already exists");
            return;
        }
        axios.post('http://localhost:4000/products', product)
            .then(response => {
                console.log('Product added:', response.data);
                alert("Product added successfully");
                window.location.reload();
            })
            .catch(error => {
                console.error('Error adding product:', error);
            });
    };

    return (
        <form id="employee-form" onSubmit={insertProduct}>
            <h2 className="form-heading">Please enter Product details</h2>
            <label className="form-label">ID</label>
            <input type="text" value={product.id} name="id" onChange={assignValue} required className="form-input" /><br />

            <label className="form-label">Name</label>
            <input type="text" value={product.name} name="name" onChange={assignValue} required className="form-input" /><br />

            <label className="form-label">Price</label>
            <input type="number" value={product.price} name="price" onChange={assignValue} required className="form-input" /><br />

            <label className="form-label">Description</label>
            <input type="text" value={product.description} name="description" onChange={assignValue} required className="form-input" /><br />

            <label className="form-label">Quantity</label>
            <input type="number" value={product.quantity} name="quantity" onChange={assignValue} required className="form-input" /><br />

            <label className="form-label">Vendor</label>
            <select required onChange={assignValue}  name="vendor" className="form-input">
                <option value="" disabled selected>Select Vendor</option>
                {props.vendors.map(vendor => (
                    <option value={vendor.id}>{vendor.name}</option>
                ))}
            </select> <br /><br></br>

            <button type="submit" className="form-button">Add Product</button>
        </form>
    );
}

export default AddProduct;