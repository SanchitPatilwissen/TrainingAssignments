import { createStore } from 'redux';
import cartReducer from './CartReducers';

const store = createStore(cartReducer);

export default store;