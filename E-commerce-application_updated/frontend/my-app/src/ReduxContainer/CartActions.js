import axios from 'axios';

const add_cart = (product) => {
    console.log("add product");
    axios.post('http://localhost:4000/products', product)
            .then(response => {
                console.log('Product added:', response.data);
                alert("Product added successfully");
                window.location.reload();
            })
            .catch(error => {
                console.error('Error adding product:', error);
            });
    return {
        type: 'ADD_PRODUCT',
        payload: product
    };
}

const delete_product = (id) => {
    console.log("delete product");
    return {
        type: 'DELETE_PRODUCT',
        payload: id
    };
}

const load_cart = () => {
    let cart = {};
    axios.get('http://localhost:4000/cart')
        .then(response => {
            cart = response.data;
            console.log('Products loaded:', response.data);
        })
        .catch(error => {
            console.error('Error loading products:', error);
        });
    return {
        type: 'LOAD_CART',
        payload: cart
    };
}

export { add_cart, delete_product, load_cart };