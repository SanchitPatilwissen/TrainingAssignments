import LoanForm from "./LoanForm";
import LoanPara from "./LoanPara";
import {useState} from "react";

function LoanComponent() {
  const [showPara, setShowPara] = useState(true);

  return (
    <div class="service-item">
      <h3 class="dropdown-btn" id="loan-click" onClick={(e)=>setShowPara(!showPara)}>Loan</h3>
      <div class="dropdown-content" id="loan">
        {
          (showPara) ? <LoanPara></LoanPara> : <LoanForm></LoanForm>
        }
      </div>
    </div>
  );
}

export default LoanComponent;