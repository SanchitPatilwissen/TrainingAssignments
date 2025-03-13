import { useState } from "react";

function LoanForm() {
    const [compState, setCompState] = useState(false);
    const [rate, setRate] = useState(0);
    const [minamt, setMinamt] = useState(0);
    const [maxamt, setMaxamt] = useState(0);
    const [maxtenure, setMaxtenure] = useState(0);
    const [tenureplaceholder, setTenureplaceholder] = useState("");
    const [amtplaceholder, setAmtplaceholder] = useState("");

    const [name, setName] = useState("");
    const [tenure, setTenure] = useState();

    function selectState(e) {
        let selectedOption = e.target.value;
        let maxAmt = 0;
        let minAmt = 0;
        let maxTenure = 0;

        if(selectedOption === "home"){
            setRate(9);
            setMinamt(500000);
            setMaxamt(10000000);
            setMaxtenure(30);
            maxAmt = 10000000;
            maxTenure = 30;
            minAmt = 500000;
        }
        else if(selectedOption === "car"){
            console.log("Car has come");
            setRate(11);
            setMinamt(100000);
            setMaxamt(1500000);
            setMaxtenure(7);
            maxAmt = 1500000;
            maxTenure = 7;
            minAmt = 100000;
        }
        else{
            console.log("Personal has come");
            setRate(15);
            console.log(rate);
            setMinamt(10000);
            setMaxamt(500000);
            setMaxtenure(5);
            maxAmt = 500000;
            maxTenure = 5;
            minAmt = 10000;
        }
        console.log(maxtenure);
        
        setCompState(true);
        setTenureplaceholder("Must be between 0-"+maxTenure+" years");
        setAmtplaceholder("Must be between "+minAmt+" - "+maxAmt+" rupees");
    }

    function calculateEmi(e) {
        e.preventDefault();
        console.log(name);
    }

    return (
        <div id="form-content">
            <form class="login-form" name="login-form" onSubmit={(e)=>{calculateEmi(e)}}>
                <div class="form-group">
                    <label for="netbanking-id" onChange={(e)=>setName(e.target.value)}>Applicant's Full name</label>
                    <input type="text" id="full-name" name="full-name"  required></input>
                </div>
                <div class="form-group">
                    <label for="loan-type">Type of Loan</label>
                    <select id="loan-type" class="type-of-loan" name="loan-type" onChange={(e)=>{selectState(e)}} required>
                        <option value="" disabled selected>Select a Loan Type</option>
                        <option value="home">Home Loan</option>
                        <option value="car">Car Loan</option>
                        <option value="personal">Personal Loan</option>
                    </select>
                </div>
                {
                    (compState) ?
                    <div>
                        <div class="form-group hidden">
                            <label for="password">Interest</label>
                            <span id="rate-of-interest">{rate} %</span>
                        </div>
                        <div class="form-group hidden">
                            <label for="loan-type">Tenure (in years)</label>
                            <input type="number" id="tenure" name="tenure" min="1" max={maxtenure} placeholder={tenureplaceholder} onChange={(e)=>{setTenure(e.target.value)}} required></input>
                        </div>
                        <div class="form-group hidden">
                            <label for="netbanking-id">Amount</label>
                            <input type="number" id="amount" name="amount" min={minamt} max={maxamt} placeholder={amtplaceholder} required></input>
                        </div>
                    </div>
                    :
                    <span></span>
                }

                <div class="form-group">
                    <button type="submit">calculate</button>
                </div>
            </form>
            <div class="form-group" id="emi-display">
                <label for="emi">EMI</label>
                <span id="emi"></span>
            </div>
        </div>
    );
}

export default LoanForm;