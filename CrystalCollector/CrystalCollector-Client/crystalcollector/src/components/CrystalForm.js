import { useState, useEffect } from "react";
import { useNavigate, useParams, Link } from "react-router-dom";

import{ findCrystalById, addOrUpdateCrystal } from "../services/crystalsAPI";
import ValidationSummary from "./ValidationSummary";

import "../styles/crystalform.css";


    const INITIAL_CRYSTAL = {
        crystalId: 0,
        crystalName: "",
        color: "",
        amountOwned: 0,
        shape: "",
        notes: "",
        raw: false,
        inCollection: false,
        crystalSpecification: "",
        imageUrl: "",
        appUserId: 0
    };

function CrystalForm() {

    const [crystal, setCrystal] = useState([]);
    const [errors, setErrors] = useState([]);

    const navigate = useNavigate();
    const { crystalId } = useParams();

    useEffect(() => {
        console.log("hello from crystal form", crystalId);
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


    const handleChange = (evt) => {
        const nextCrystal = { ...crystal };
       if (evt.target.type === "checkbox") {
          nextCrystal[evt.target.name] = evt.target.checked;
        } else {
          nextCrystal[evt.target.name] = evt.target.value;
        }
        setCrystal(nextCrystal);
    };


    const handleSubmit = (evt) => {
        evt.preventDefault();
        addOrUpdateCrystal(crystal).then((data) => {
          if (data?.errors) {
            setErrors(data.errors);
          } else {
            navigate("/crystals", {
              state: { message: `${crystal.title} saved!` },
            });
          }
        });
    };



    return (
        <div className="crystalform-container">
            <ValidationSummary errors={errors} />
            <div className="crystal-form">
                <form onSubmit={handleSubmit}>
                    <div className="crystalform-group">
                        <label htmlFor="crystalName">Crystal Name</label>
                        <input
                            type="text"
                            name="crystalName"
                            value={crystal.crystalName}
                            onChange={handleChange}
                        />
                    </div>

                    <div className="crystalform-group">
                        <label htmlFor="color">Color</label>
                        <input
                            type="text"
                            name="color"
                            value={crystal.color}
                            onChange={handleChange}
                        />
                    </div>

                    <div className="crystalform-group">
                        <label htmlFor="amountOwned">Amount Owned</label>
                        <input
                            type="number"
                            name="amountOwned"
                            value={crystal.amountOwned}
                            onChange={handleChange}
                        />
                    </div>

                    <div className="crystalform-group">
                        <label htmlFor="shape">Shape</label>
                        <input
                            type="text"
                            name="shape"
                            value={crystal.shape}
                            onChange={handleChange}
                        />
                    </div>

                    <div className="crystalform-group">
                        <label htmlFor="notes">Notes</label>
                        <textarea
                            name="notes"
                            value={crystal.notes}
                            onChange={handleChange}
                        />
                    </div>

                    <div className="crystalform-group">
                        <label htmlFor="raw">Raw</label>
                        <select
                        name="raw"
                        value={crystal.raw}
                        onChange={handleChange}
                        >
                        <option value={true}>Yes</option>
                        <option value={false}>No</option>
                        </select>
                    </div>

                    <div className="crystalform-group">
                        <label htmlFor="inCollection">In Collection</label>
                        <select
                        name="inCollection"
                        value={crystal.inCollection}
                        onChange={handleChange}
                        >
                        <option value={true}>Yes</option>
                        <option value={false}>No</option>
                        </select>
                    </div>

                    <div className="crystalform-group">
                        <label htmlFor="crystalSpecification">Crystal Specification</label>
                        <select
                            name="crystalSpecification"
                            value={crystal.crystalSpecification}
                            onChange={handleChange}
                        >
                            <option value="REGULAR">Regular</option>
                            <option value="SPECIAL">Special</option>
                            <option value="ORGONITE">Orgonite</option>
                            <option value="METAL">Metal</option>
                            <option value="NONSTONE">Nonstone</option>
                            <option value="JEWELRY">Jewelry</option>
                        </select>
                    </div>

                    <div className="crystalform-group">
                        <label htmlFor="imageUrl">Image URL</label>
                        <input
                            type="url"
                            name="imageUrl"
                            value={crystal.imageUrl}
                            onChange={handleChange}
                        />
                    </div>
                    <div className="crystalform-buttons">

                        <button type="submit">Submit</button>
                        <Link to="/crystals" className="blurbs-btn btn-secondary">
                        Cancel
                        </Link>
                    </div>
                </form>

            </div>

        </div>
    )
}

export default CrystalForm;