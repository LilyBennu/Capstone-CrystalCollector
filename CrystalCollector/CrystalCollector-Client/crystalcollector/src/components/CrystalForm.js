import { useState, useEffect } from "react";
import { useNavigate, useParams, Link } from "react-router-dom";

import{ findCrystalById, addOrUpdateCrystal } from "../services/crystalsAPI";
import ValidationSummary from "./ValidationSummary";

function CrystalForm() {

    return (
        <h1>Add and Update Crystals here!</h1>
    )
}

export default CrystalForm;