import { useState, useEffect } from "react";
import { useNavigate, useParams, Link } from "react-router-dom";

import{ findBlurbById, addOrUpdateBlurbs } from "../services/blurbsAPI";
import ValidationSummary from "./ValidationSummary";

import "../styles/blurbsform.css";

const INITIAL_BLURB = {
    blurbsId: 0,
    title: "",
    textBody: "",
    imageUrl: "",
    appUserId: 0
};

function BlurbsForm() {

    const [blurbs, setBlurbs] = useState([]);
    const [errors, setErrors] = useState([]);

    const navigate = useNavigate();
    const { blurbsId } = useParams();

    useEffect(() => {
        console.log("hello from blurbs form", blurbsId);
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

    function handleChange(evt) {

        setBlurbs(previous => {
            const next = { ...previous };
            next[evt.target.name] = evt.target.value;
            return next;
        });

    }

    const handleSubmit = (evt) => {
        evt.preventDefault();
        addOrUpdateBlurbs(blurbs).then((data) => {
          if (data?.errors) {
            setErrors(data.errors);
          } else {
            navigate("/blurbs/list", {
              state: { message: `${blurbs.title} saved!` },
            });
          }
        });
    };



    return (
        <div className="blurbsform-container">
            <ValidationSummary errors={errors} />
            <div className="blurb-form">

                <form onSubmit={handleSubmit}>
                    <div className="blurbs-form-group">
                        <label htmlFor="title">Title</label>
                        <input
                        type="text"
                        name="title"
                        value={blurbs.title}
                        onChange={handleChange}
                        />
                    </div>

                    <div className="blurbs-form-group">
                        <label htmlFor="textBody">Text</label>
                        <textarea
                        name="textBody"
                        value={blurbs.textBody}
                        onChange={handleChange}
                        />
                    </div>

                    <div className="blurbs-form-group">
                        <label htmlFor="imageUrl">Image URL</label>
                        <input
                        type="text"
                        name="imageUrl"
                        value={blurbs.imageUrl}
                        onChange={handleChange}
                        />
                    </div>

                    <div>
                        <Link to="/blurbs/list" className="blurbs-btn btn-secondary">
                        Cancel
                        </Link>
                        <button type="submit" className="blurbs-btn btn-primary">
                        Save
                        </button>
                    </div>
                </form>

            </div>

        </div>
    )
}

export default BlurbsForm;