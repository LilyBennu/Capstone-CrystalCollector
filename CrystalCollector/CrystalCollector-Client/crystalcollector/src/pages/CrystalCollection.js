import { useState, useEffect, useContext } from "react";
import { useNavigate, Link } from "react-router-dom";
import { viewAllCrystals } from "../services/crystalsAPI";
import CrystalCards from "../components/CrystalCards";

import AuthContext from "../contexts/AuthContext";

function CrystalCollection() {

    const [crystal, setCrystal] = useState([]);
    const navigate = useNavigate();
    const { user } = useContext(AuthContext);

    useEffect(() => {
        viewAllCrystals()
          .then((data) => setCrystal(data))
          .catch((err) =>
            navigate("/error", {
              state: { message: err },
            })
          );
      }, [navigate]);

    return (
        <div className="crystal-list-container">
            <div>
                <h1> {user.username}'s Crystal Collection! </h1>
            </div>
            <div className="add-crystal-button">
                <Link to="/crystalform" className="btn">
                    Add a Crystal
                </Link>
            </div>
            <div className="row row-cols-1 row-cols-md-2 row-cols-lg-4">
                {crystal.length === 0 ? (
                <div className="alert alert-info">
                    Add some crystals!
                </div>
                ) : (
                crystal.map((crystal) => <CrystalCards key={crystal.crystalId} crystal={crystal} />)
                )}
            </div>

        </div>
    )

}

export default CrystalCollection;