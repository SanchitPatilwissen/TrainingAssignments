const loanComponent = document.getElementById('loan');
const loanComponentClickable = document.getElementById('loan-click');

const depositComponent = document.getElementById('deposit');
const depositComponentClickable = document.getElementById('deposit-click');

const loanForm = `
<form class="login-form">
    <div class="form-group">
        <label for="netbanking-id">Applicant's Full name</label>
        <input type="text" id="full-name" name="full-name" required>
    </div>
    <div class="form-group">
        <label for="loan-type">Type of Loan</label>
        <select id="loan-type" class="type-of-loan" name="loan-type" required>
            <option value="" disabled selected>Select a Loan Type</option>
            <option value="home">Home Loan</option>
            <option value="car">Auto Loan</option>
            <option value="personal">Personal Loan</option>
        </select>
    </div>    
    <script>
        const loanType = document.querySelector('.type-of-loan');
        const hiddenComponent = document.querySelector('.hidden');

        document.write("Hello ");

        loanType.addEventListener("change", () => {
            var value = loanType.value;  
            if (value) {
                hiddenComponent.style.display = "block"; 
            } else {
                hiddenComponent.style.display = "none";
            }
        });
    </script>
    <div class="form-group, hidden">
        <label for="password">Interest</label>
        <span></span>
    </div>
    <div class="form-group, hidden">
        <label for="loan-type">Tenure</label>
        <select id="loan-type" name="loan-type" required>
            <option value="home">Home Loan</option>
            <option value="car">Auto Loan</option>
            <option value="personal">Personal Loan</option>
        </select>
    </div>
    <div class="form-group, hidden">
        <label for="netbanking-id">Amount</label>
        <input type="number" id="amount" name="amount" min="18" max="100" required>
    </div>
    
    <div class="form-group">
        <button type="submit">calculate</button>
    </div>
</form>
`;

const loanPara = `
<p>We offer a range of loan products designed to meet your personal financial needs, including home loans,
    auto loans, and more.</p>
<p>Whether you're planning for a major purchase or need some extra cash, our loans are flexible to suit your
    requirements.</p>
`;

const depositForm = ``;
const depositPara = ``;

const forms = [loanForm, depositForm];
const paras = [loanPara, depositPara];

var flags = [false, false];

function display(component, flag) {
    if (flags[flag]) {
        component.innerHTML = paras[flag];  
    } else {
        component.innerHTML = forms[flag]; 
    }
    flags[flag] = !flags[flag];  
}

loanComponentClickable.addEventListener('click', function() {
    display(loanComponent, 0);  
});

depositComponentClickable.addEventListener('click', function() {
    display(depositComponent, 1); 
});
