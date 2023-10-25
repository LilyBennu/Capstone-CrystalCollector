import { useContext  } from "react";
import { Link } from "react-router-dom";
import "../styles/blurbscard.css"

import AuthContext from "../contexts/AuthContext";

function BlurbsCard({ blurbs }) {

    const { user, hasAuthority } = useContext(AuthContext); // do i need to add && USER if the user is already logged in?

    return (
        <div className="blurb-card-container">
            <div className="blurbs-card">
                <div className="blurbs-card-text">
                    <h5 className="blurb-card-title">{blurbs.title}</h5>
                    <p className="blurb-card-textbody">{blurbs.textBody}</p>
                </div>
                <img src={blurbs.imageUrl} className="card-image-bottom" alt={blurbs.title} />
                <Link to={`/blurbsform/${blurbs.blurbsId}`} className="blurb-card-edit-btn">
                    Edit
                </Link>
                <Link to={`/blurbs/delete/${blurbs.blurbsId}`} className="blurb-card-delete-btn">
                    Delete
                </Link>
            </div>

        </div>
    )


}

export default BlurbsCard;