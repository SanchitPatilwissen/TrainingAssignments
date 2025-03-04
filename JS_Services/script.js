const loanComponent = document.getElementById('loan');
const loanComponentClickable = document.getElementById('loan-click');

const depositComponent = document.getElementById('deposit');
const depositComponentClickable = document.getElementById('deposit-click');

const loanType = document.querySelector('.type-of-loan');
const hiddenComponent = document.querySelectorAll('.hidden');

const paraLoanComponent = document.getElementById("para");
const formLoanComponent = document.getElementById("form-content");

const paraDepositComponent = document.getElementById("para-deposit");
const formDepositComponent = document.getElementById("form-content-deposit");

var flags = [false, false];
let r = 12;

function displayLoan() {
    if (flags[0]) {
        paraLoanComponent.style.display = "none";
        formLoanComponent.style.display = "block";
    } else {
        paraLoanComponent.style.display = "block";
        formLoanComponent.style.display = "none";
    }
    flags[0] = !flags[0];
}

function displayDeposit() {
    if (flags[1]) {
        paraDepositComponent.style.display = "none";
        formDepositComponent.style.display = "block";
    } else {
        paraDepositComponent.style.display = "block";
        formDepositComponent.style.display = "none";
    }
    flags[1] = !flags[1];
}

document.querySelector(".login-form").addEventListener("submit", function(event) {
    event.preventDefault();
    var tenure_value = parseInt(document.forms["login-form"]["tenure"].value);
    var amt_value = parseInt(document.forms["login-form"]["amount"].value);
    var r_value= (r/(12*100));
    var val = (1+r_value)**tenure_value;
    var emi = Math.round((r_value*amt_value*val)/(val-1));
    document.getElementById('emi-display').style.display = "block";
    document.getElementById('emi').innerText = "Rs. "+emi;
});

document.querySelector(".login-form-deposit").addEventListener("submit", function(event) {
    event.preventDefault();
    var tenure_value = parseInt(document.forms["login-form-deposit"]["tenure"].value);
    var amt_value = parseInt(document.forms["login-form-deposit"]["amount"].value);
    var r_value= 0.07;
    var maturity_value = amt_value*((1+r_value)**tenure_value);
    document.getElementById('maturity-display').style.display = "block";
    document.getElementById('maturity').innerText = "Rs. "+maturity_value;
});

loanComponentClickable.addEventListener('click', function () {
    displayLoan();
});

depositComponentClickable.addEventListener('click', function () {
    displayDeposit();
});


loanType.addEventListener("change", () => {
    var value = loanType.value;
    if (value) {
        hiddenComponent.forEach(element => {
            element.style.display = 'block'; 
        });
        switch (value) {
            case "home": 
                r = 9
                var minamt = 500000, maxamt = 10000000, maxtenure=30;       
                break;
            case "car":
                r = 11;
                var minamt = 100000, maxamt = 1500000, maxtenure=7; 
                break;
            case "personal":
                r = 15;
                var minamt = 10000, maxamt = 500000, maxtenure=5; 
                break;
        }        
        rateComponent = document.getElementById("rate-of-interest");
        tenureComponent = document.getElementById("tenure");
        amountComponent = document.getElementById("amount");
        rateComponent.innerText = r+"%";
        tenureComponent.placeholder = "Must be between 0-"+maxtenure+" years";
        tenureComponent.max = maxtenure;
        amountComponent.min = minamt;
        amountComponent.maxamt = maxamt;
        amountComponent.placeholder = "Must be between "+minamt+" - "+maxamt+" rupees";    
    }
});