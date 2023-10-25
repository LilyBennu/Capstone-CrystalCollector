import { useState, useEffect, useContext } from "react";
import { useNavigate, Link } from "react-router-dom";
import { findAllBlurbs } from "../services/blurbsAPI";
import BlurbsCard from "../components/BlurbsCard";
import "../styles/blurbspage.css"

import AuthContext from "../contexts/AuthContext";

function Blurbs() {

    const [blurbs, setBlurbs] = useState([]);
    const navigate = useNavigate();

    const { user } = useContext(AuthContext);

    useEffect(() => {
        findAllBlurbs()
          .then((data) => setBlurbs(data))
          .catch((err) =>
            navigate("/error", {
              state: { message: err },
            })
          );
      }, [navigate]);

    return (
        <div className="blurbs-list-container">
            <div>
             <h1> { user.username }'s Blurbs! </h1>
            </div>

            <div className="add-blurb-button">
                <Link to="/blurbsform" className="add-blurb-btn">
                    Add A Blurb
                </Link>
            </div>  
            <div className="row row-cols-1 row-cols-md-2 row-cols-lg-4">
                {blurbs.length === 0 ? (
                <div className="alert alert-info">
                    Add some blurbs!
                </div>
                ) : (
                blurbs.map((blurbs) => <BlurbsCard key={blurbs.blurbsId} blurbs={blurbs} />)
                )}
            </div>
            
            

               

        </div>
    )

}

export default Blurbs;