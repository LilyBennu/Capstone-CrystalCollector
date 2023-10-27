import { useState, useEffect } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

import "../styles/confirmdeleteblurb.css"

import {
findBlurbById,
deleteBlurbById,
} from "../services/blurbsAPI";

function ConfirmDeleteBlurb() {

    const [blurbs, setBlurbs] = useState({ title: ""});

    const navigate = useNavigate();
    const { blurbsId } = useParams();

    useEffect(() => {
        if (blurbsId) {
          findBlurbById(blurbsId)
            .then((data) => setBlurbs(data))
            .catch((err) =>
              navigate("/error", {
                state: { message: err },
              })
            );
        }
    }, [blurbsId, navigate]);

    const handleSubmit = (evt) => {
        evt.preventDefault();
        deleteBlurbById(blurbsId).then(() => {
          navigate("/blurbs", {
            state: { message: `${blurbs.title} deleted!` },
          });
        });
      };

    return (
        <div className="delete-blurb-container">
          <form onSubmit={handleSubmit}>
                <div>
                    <h1 className="delete-blurb-title">Delete {blurbs.title}?</h1>
                    <div className="delete-blurb-warning">This cannot be undone.</div>
                    <div>
                    <Link to="/blurbs" className="btn btn-secondary">
                        Cancel
                    </Link>
                    <button type="submit" className="btn btn-primary">
                        Delete
                    </button>
                    </div>
                </div>
            </form> 
        </div>
    )
}

export default ConfirmDeleteBlurb;