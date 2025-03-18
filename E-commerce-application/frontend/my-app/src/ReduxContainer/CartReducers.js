const initialCart = { "id": "", "products": [], "user": "", "totalPrice": 0 };

const cartReducer = (state = initialCart, action) => {
    switch (action.type) {
        case 'ADD_PRODUCT':
            return {...state,
                products: [...state.products, action.payload],
            };
        case 'DELETE_PRODUCT':
            return {
                ...state,
                products: state.products.filter(product => product.id !== action.payload)
            };
        case 'LOAD_CART':
            return action.payload;
        default:
            return state;
    }
};

export default cartReducer;