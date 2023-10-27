import { useState, useEffect, useContext } from "react";
import { useNavigate, Link, useParams } from "react-router-dom";
import { findCrystalById } from "../services/crystalsAPI";
import CrystalDetailCard from "../components/CrystalDetailCard";

import AuthContext from "../contexts/AuthContext";

function CrystalDetail() {

    const [crystal, setCrystal] = useState(null);
    const navigate = useNavigate();
    const { user } = useContext(AuthContext);

    const { crystalId} = useParams();

    useEffect(() => {
        findCrystalById(crystalId)
          .then((data) => setCrystal(data))
          .catch((err) =>
            navigate("/error", {
              state: { message: err },
            })
          );
    }, [navigate]);


    if (!crystal) {
        return null;
    }

    return (
        <div className="crystal-detail-page-container">
            <div className="h1-title">
                <h1> {crystal.crystalName}'s Details:</h1>
            </div>
            <div>
                
                <CrystalDetailCard key={crystal.crystalId} crystal={crystal} />
            </div>

        </div>
    )

}

export default CrystalDetail;