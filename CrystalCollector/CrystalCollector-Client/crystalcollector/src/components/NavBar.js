import { NavLink, Link, useNavigate } from "react-router-dom";
import { useContext } from "react";

import AuthContext from "../contexts/AuthContext";

import "../styles/navbar.css";

function NavBar() {
    // should it be
    // const auth = {user: user ?{...user}: null, signIn, signOut}; ?
    const { user, signout } = useContext(AuthContext);
    
    const navigate =useNavigate();

    return (
        <nav>
            <div className="navbar-container">
                <ul>
                    {user ? (<li className="nav-item">
                    <NavLink to="/welcome" className="nav-link">
                        Home
                    </NavLink>
                    </li>) :
                         (<li className="nav-item">
                    <NavLink to="/"  className="nav-link">
                        Home
                    </NavLink>
                    </li>)}
                    <li className="nav-item">
                    <NavLink to="/about"  className="nav-link">
                        About
                    </NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink to="/contact"  className="nav-link">
                        Contact
                    </NavLink>
                    </li>

                    {user ? (
                        <>
                    <li className="nav-item">
                    <NavLink to="/crystals"  className="nav-link">
                        Crystals
                    </NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink to="/blurbs"  className="nav-link">
                        Blurbs
                    </NavLink>
                    </li> </>) : (
                        <>
                    <li className="nav-item">
                    <NavLink to="/"  className="nav-link">
                        Crystals
                    </NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink to="/"  className="nav-link">
                        Blurbs
                    </NavLink>
                    </li> </>)}
                    
                    
                    {user ? (
                    <li> 
                    <div className="sign-out-container">
                        {user.username}
                        <button className="sign-out-btn" onClick={() => {
                            signout(); 
                            navigate("/")
                        }}>Sign Out</button>
                    </div>
                    </li>) : (<li>
                    <Link to="/">Sign In/ Sign Up</Link>
                    </li>)}
                </ul>
            </div>

        </nav>
        
    )
}

export default NavBar;