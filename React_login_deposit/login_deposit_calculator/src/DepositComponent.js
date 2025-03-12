import DepositPara from "./DepositPara";
import DepositForm from "./DepositForm";
import {useState} from "react";

function DepositComponent() {
    const [showPara, setShowPara] = useState(true);

    return (
        <div class="service-item">
            <h3 class="dropdown-btn" id="deposit-click" onClick={(e)=>setShowPara(!showPara)}>Deposit</h3>
            <div class="dropdown-content" id="deposit">
                {
                    (showPara) ? <DepositPara></DepositPara> : <DepositForm></DepositForm>
                }
            </div>
        </div>
    );
}

export default DepositComponent;