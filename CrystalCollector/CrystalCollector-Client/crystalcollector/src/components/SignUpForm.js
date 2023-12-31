import { useState } from "react";
import { Link } from "react-router-dom";
import { signUp } from "../services/authAPI";

import ValidationSummary from "./ValidationSummary";

import "../styles/signup.css";

function SignUpForm() {
  const [errors, setErrors] = useState([]);
  const [credentials, setCredentials] = useState({
    username: "",
    password: "",
    confirmPassword: "",
  });
  const [success, setSuccess] = useState(false);

  const handleChange = (evt) => {
    const nextCredentials = { ...credentials };
    nextCredentials[evt.target.name] = evt.target.value;
    setCredentials(nextCredentials);
  };

  const handleSubmit = (evt) => {
    evt.preventDefault();
    setErrors([]);
    if (!validateForm()) {
      setErrors(["Passwords do not match!"]);
      return;
    }

    signUp(credentials).then((data) => {
      if (data && data.errors) {
        setErrors(data.errors);
      } else {
        setSuccess(true);
      }
    });
  };

  const validateForm = () => {
    return credentials.password === credentials.confirmPassword;
  };

  return (
    <div className="signup-container">
      <ValidationSummary errors={errors} />
      {success ? (
        <div className="alert alert-success">
          Congratulations {credentials.username}, you have been registered.
          Sign In <Link className="sign-in-btn" to="/signin">Here!</Link>
        </div>
      ) : (
        <div className="sign-up-form-container">
        <form onSubmit={handleSubmit}>
          <div>
            <h2>Sign Up</h2>
            <div className="signup-form-group">
              <label htmlFor="signup-label">Username</label>
              <input
                type="signup-text"
                className="signup-form-control"
                id="username"
                name="username"
                value={credentials.username}
                onChange={handleChange}
                required
              />
            </div>
            <div className="signup-form-group">
              <label htmlFor="signup-label">Password</label>
              <input
                type="password"
                className="signup-form-control"
                id="password"
                name="password"
                value={credentials.password}
                onChange={handleChange}
                required
              />
            </div>
            <div className="signup-form-group">
              <label htmlFor="signup-label">Confirm password</label>
              <input
                type="password"
                className="signup-form-control"
                id="confirmPassword"
                name="confirmPassword"
                value={credentials.confirmPassword}
                onChange={handleChange}
                required
              />
            </div>
            <div>
              <button type="submit" className="signup-btn">
                Sign up
              </button>
              <Link to="/" className="signup-btn-cancel">
                Cancel
              </Link>
            </div>
          </div>
        </form>
        </div>
      )}
    </div>
  );
}

export default SignUpForm;
