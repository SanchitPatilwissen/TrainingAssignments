import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Products from './Products';
import Vendors from './Vendors';
import { Link } from 'react-router-dom';
import Orders from './Orders';
import Cart from './Cart';

function App() {
  return (
    <Router className="App">
        <div class="sidebar">
          <h3>Navigation</h3>
          <ul>
            <li><Link to="/">Products</Link></li>
            <li><Link to="/vendors">Vendors</Link></li>
            <li><Link>Inventory</Link></li>
            <li><Link to="/orders">Order</Link></li>
            <li><Link to="/cart">Cart</Link></li>
          </ul>
        </div>
        <div class="main-content">
          <Routes class="services-content">
            <Route path="/" element={<Products />} />
            <Route path="/vendors" element={<Vendors />} />
            <Route path="/orders" element={<Orders />} />
            <Route path="/cart" element={<Cart />} />
          </Routes>
        </div>
    </Router>
  );
}

export default App;
