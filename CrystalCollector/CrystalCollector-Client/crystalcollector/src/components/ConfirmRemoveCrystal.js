import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

import {
    findCrystalById,
    removeCrystalById,
} from "../services/crystalsAPI";

function ConfirmRemoveCrystal() {

    const [crystal, setCrystal] = useState({ crystalName: ""});

    const navigate = useNavigate();
    const { crystalId } = useParams();

    useEffect(() => {
        if (crystalId) {
          findCrystalById(crystalId)
            .then((data) => setCrystal(data))
            .catch((err) =>
              navigate("/error", {
                state: { message: err },
              })
            );
        }
      }, [crystalId, navigate]);

      const handleSubmit = (evt) => {
        evt.preventDefault();
        removeCrystalById(crystalId).then(() => {
          navigate("/crystals", {
            state: { message: `${crystal.crystalName} deleted!` },
          });
        });
      };

  


    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div>
                    <h1 className="remove-crystal-title">Delete {crystal.crystalName}?</h1>
                    <div className="alert alert-danger">This cannot be undone.</div>
                    <div>
                    <Link to="/crystals" className="cancel-rmv-crystal">
                        Cancel
                    </Link>
                    <button type="submit" className="remove-crystal">
                        Delete
                    </button>
                    </div>
                </div>
            </form>
        </div>
    )
}

export default ConfirmRemoveCrystal;