import "./AddProduct.css";

function AddProduct() {
    return (
        <form id="employee-form">
            <h2 className="form-heading">Please enter Product details</h2>
            <label className="form-label">ID</label>
            <input type="text" required className="form-input" /><br />

            <label className="form-label">Name</label>
            <input type="text" required className="form-input" /><br />

            <label className="form-label">Price</label>
            <input type="text" required className="form-input" /><br />

            <label className="form-label">Description</label>
            <input type="text" required className="form-input" /><br />

            <label className="form-label">Vendor</label>
            <input type="text" required className="form-input" /><br />

            <button type="submit" className="form-button">Add Product</button>
        </form>
    );
}

export default AddProduct;