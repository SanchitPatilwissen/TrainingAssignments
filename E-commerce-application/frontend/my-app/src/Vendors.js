import './Vendors.css';
import axios from 'axios';
import { useState, useEffect } from 'react';

function Vendors() {
    const [vendors, setVendors] = useState([]);
    const [showComponent, setShowComponent] = useState(true);

    useEffect(() => {
        axios.get('http://localhost:4000/vendors')
            .then(response => {
                setVendors(response.data);
            })
            .catch(error => {
                console.error('Error fetching vendors:', error);
            });
    }, []);

    function ShowVendors() {
        function deleteVendor(id) {
            let deleteValue = window.confirm("Are you sure you want to delete this vendor?");
            if (!deleteValue) {
                return;
            }
            axios.delete(`http://localhost:4000/vendors/${id}`)
                .then(response => {
                    console.log('Vendor deleted:', response.data);
                    setVendors(vendors.filter(vendor => vendor.id !== id));
                })
                .catch(error => {
                    console.error('Error deleting vendor:', error);
                });
        }



        return (
            <div id="vendors-container">
                <h1 className="vendors-heading">Our Vendors</h1>
                <ul className="vendors-list">
                    {vendors.map((vendor) => (
                        <li key={vendor.id} className="vendor-item">
                            {vendor.name}
                            <button
                                className="delete-button"
                                onClick={() => deleteVendor(vendor.id)}
                            >
                                Delete
                            </button>
                        </li>
                    ))}
                </ul>
                <button id="add-product-button" onClick={() => setShowComponent(!showComponent)}>
                    Add Vendor
                </button>
                <button className="product-button">Delete Product</button>
            </div>
        )
    }

    function ShowAddVendorForm() {
        const [vendor, setVendor] = useState({ "id": "", "name": "" });

        const assignValue = (e) => {
            setVendor({ ...vendor, [e.target.name]: e.target.value });
        };

        const insertVendor = (e) => {
            e.preventDefault();
            if (vendors.find(p => p.id == vendor.id)) {
                alert("Vendor with this ID already exists");
                return;
            }
            axios.post('http://localhost:4000/vendors', vendor)
                .then(response => {
                    console.log('Vendor added:', response.data);
                    alert("Vendor added successfully");
                    window.location.reload();
                })
                .catch(error => {
                    console.error('Error adding product:', error);
                });
        };

        return (
            <form id="employee-form" onSubmit={insertVendor}>
                <label className="form-label">ID</label>
                <input type="text" value={vendor.id} name="id" onChange={assignValue} required className="form-input" /><br />

                <label className="form-label">Name</label>
                <input type="text" value={vendor.name} name="name" onChange={assignValue} required className="form-input" /><br />

                <button type="submit" className="form-button">Add Vendor</button>

                <button id="add-product-button" onClick={() => setShowComponent(!showComponent)}>Show Vendors</button>
            </form>
        );
    }

    return (
        (showComponent) ?
            <ShowVendors></ShowVendors>
            :
            <ShowAddVendorForm></ShowAddVendorForm>
    );
}

export default Vendors;
