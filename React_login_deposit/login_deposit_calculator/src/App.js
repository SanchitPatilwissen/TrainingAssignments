import './App.css';
import './forms.css';
import DepositComponent from './DepositComponent';
import LoanComponent from './LoanComponent';

function App() {
  return (
    <div className="App">
      <div class="services-content">
        <h2>Our Services</h2>
        <LoanComponent></LoanComponent>
        <DepositComponent></DepositComponent>
      </div>
    </div>
  );
}

export default App;
