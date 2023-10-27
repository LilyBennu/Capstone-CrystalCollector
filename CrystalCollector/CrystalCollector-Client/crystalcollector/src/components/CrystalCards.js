import { useContext  } from "react";
import { Link } from "react-router-dom";
import "../styles/crystalcard.css";

import AuthContext from "../contexts/AuthContext";

function CrystalCards({ crystal }) {

    const { user, hasAuthority } = useContext(AuthContext);

    return (
        <div className="crystal-card-container">
            <div className="crystal-card">
                <img src={crystal.imageUrl} className="card-image-top" alt={crystal.crystalName} />
                <h5 className="crystal-card-title">{crystal.crystalName}</h5>
                <div className="crystal-card-state-btns">
                    <Link to={`/crystals/detail/${crystal.crystalId}`} className="crystal-card-view-btn">
                        View
                    </Link>
                    <Link to={`/crystalform/${crystal.crystalId}`} className="crystal-card-edit-btn">
                        Edit
                    </Link>
                    <Link to={`/crystal/remove/${crystal.crystalId}`} className="crystal-delete-btn">
                        Remove
                    </Link>

                </div>
            </div>
            
        </div>
    )
}

export default CrystalCards;