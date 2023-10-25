import { Link } from 'react-router-dom';

import "../styles/signin.css";

function SignIn() {
    return (
        <div>
            <h1 className='signin-title'>Crystal Collector</h1>
            <div className="sign-in-page">
        
                <div className="sign-in-container">
                    <h2 className='sign-in-h2'>Sign In or Sign Up</h2>
                    <Link to="/signin"> 
                    <button className="sign-in-button">Sign In</button>
                    </Link>
                    <Link to="/signup"> 
                    <button className="sign-up-button">Sign Up</button>
                    </Link>
                </div>
            </div>
       /</div>
      );

}

export default SignIn;