import { useContext  } from "react";
import { Link } from "react-router-dom";
import AuthContext from "../contexts/AuthContext";

function CrystalDetailCard({ crystal }) {

    return (
        <div className="crystal-detail-card-container">
            <div className="crystal-detail-card">
                <img src={crystal.imageUrl} className="crystail-detail-img-top" alt={crystal.crystalName} />
                <div className="crystal-detail-text-body">
                    <h5 className="crystal-name">{crystal.crystalName}</h5>
                    <ul>
                        <li>
                            <p>Color: {crystal.color}</p>
                        </li>
                        <li>
                            <p>Amount Owned: {crystal.amountOwned}</p>
                        </li>
                        <li>
                            <p>Shape: {crystal.shape}</p>
                        </li>
                        <li>
                            <p>Notes: {crystal.notes}</p>
                        </li>
                        <li>
                            <p>Raw or Smooth:{crystal.raw}</p>
                        </li>
                        <li>
                            <p>In Collection: {crystal.inCollection}</p>
                        </li>
                        <li>
                            <p>Crystal Specification: {crystal.crystalSpecification}</p>
                        </li>
                    </ul>
                </div>
                <div className="crystal-detail-card-btns">
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

export default CrystalDetailCard;