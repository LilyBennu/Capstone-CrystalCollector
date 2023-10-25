import { useState, useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import { signIn } from "../services/authAPI";

import AuthContext from "../contexts/AuthContext";
import ValidationSummary from "./ValidationSummary";

import "../styles/signinform.css";

function SignInForm() {
  const [credentials, setCredentials] = useState({
    username: "",
    password: "",
  });
  const [errors, setErrors] = useState([]);

  const { handleLoggedIn } = useContext(AuthContext);

  const navigate = useNavigate()

  const handleSubmit = (evt) => {
    evt.preventDefault();
    setErrors([]);
    signIn(credentials)
      .then(user => {
        handleLoggedIn(user);
        navigate("/welcome");
      })
      .catch(err => {
        setErrors(['Invalid username/password.']);
      });
  };

  const handleChange = (evt) => {
    const nextCredentials = {...credentials};
    nextCredentials[evt.target.name] = evt.target.value;
    setCredentials(nextCredentials);
  };

  return (
    <div className="signin-form-container">
      <ValidationSummary errors={errors} />
      <form onSubmit={handleSubmit}>
        <div>
          <div className="signin-form-group">
            <label htmlFor="label">Username</label>
            <input
              type="text"
              className="form-control"
              id="username"
              name="username"
              value={credentials.username}
              onChange={handleChange}
              required
            />
          </div>
          <div className="signin-form-group">
            <label htmlFor="label">Password</label>
            <input
              type="password"
              className="form-control"
              id="password"
              name="password"
              value={credentials.password}
              onChange={handleChange}
              required
            />
          </div>
          <div>
            <button type="submit" className="signin-form-btn">
              Sign In
            </button>
            <Link to="/" className="signin-form-btn">
              Cancel
            </Link>
          </div>
        </div>
      </form>
    </div>
  );
}

export default SignInForm;
