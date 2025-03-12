function DepositForm() {
    return (
        <div id="form-content-deposit">
            <form class="login-form-deposit" name="login-form-deposit">
                <div class="form-group">
                    <label for="netbanking-id">Amount</label>
                    <input type="number" id="amount" name="amount" min="0" required></input>
                </div>
                <div class="form-group">
                    <label for="password">Interest</label>
                    <span id="rate-of-interest-deposit">7%</span>
                </div>
                <div class="form-group">
                    <label for="loan-type">Tenure (in years)</label>
                    <input type="number" id="tenure" name="tenure" min="1" max="10" placeholder="Must be less than 10 years" required></input>
                </div>

                <div class="form-group">
                    <button type="submit">calculate</button>
                </div>
            </form>
            <div class="form-group" id="maturity-display">
                <label for="maturity">Maturity Amount</label>
                <span id="maturity"></span>
            </div>
        </div>
    );
}

export default DepositForm;