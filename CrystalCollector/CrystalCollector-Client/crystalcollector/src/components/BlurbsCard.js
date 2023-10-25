import { useContext  } from "react";
import { Link } from "react-router-dom";

import AuthContext from "../contexts/AuthContext";

function BlurbsCard({ blurbs }) {

    const { user, hasAuthority } = useContext(AuthContext);

    return (
        <div className="blurb-card-container">
            <div className="blurbs-card">
                <div className="blurbs-card-text">
                    <h5 className="blurb-card-title">{blurbs.title}</h5>
                    <p className="blurb-card-textbody">{blurbs.textbody}</p>
                </div>
                <img src={blurbs.imageUrl} className="card-image-bottom" alt={blurbs.title} />
                <Link to={``}>
                    Edit
                </Link>
                <Link to={`/blurbform/${blurbs.blurbId}`} className="blurb-card-btn">
                    Edit
                </Link>
            </div>

        </div>
    )


}

export default BlurbsCard;