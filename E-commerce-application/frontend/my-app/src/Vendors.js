import React from 'react';
import './Vendors.css';
import axios from 'axios';
import { useState, useEffect } from 'react';

function Vendors() {
    const [vendors, setVendors] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:4000/vendors')
            .then(response => {
                setVendors(response.data);
            })
            .catch(error => {
                console.error('Error fetching vendors:', error);
            });
    }, []);

    return (
        <div id="vendors-container">
            <h1 className="vendors-heading">Our Vendors</h1>
            <ul className="vendors-list">
                {vendors.map(vendor => (
                    <li key={vendor.id} className="vendor-item">{vendor.name}</li>
                ))}
            </ul>
        </div>
    );
}

export default Vendors;
