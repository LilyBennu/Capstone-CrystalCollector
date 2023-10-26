import { NavLink, Link } from "react-router-dom";
import { useContext } from "react";

import AuthContext from "../contexts/AuthContext";

import "../styles/navbar.css";

function NavBar() {

    const { user, signOut } = useContext(AuthContext);
    const auth = useContext(AuthContext);

    return (
        <nav>
            <div className="navbar-container">
                <ul>
                    {auth.user ? (<li className="nav-item">
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
                    <li className="nav-item">
                    <NavLink to="/crystals"  className="nav-link">
                        Crystals
                    </NavLink>
                    </li>
                    <li className="nav-item">
                    <NavLink to="/blurbs"  className="nav-link">
                        Blurbs
                    </NavLink>
                    </li>
                    
                    
                    {auth.user ? (
                    <li> 
                    <div className="sign-out-container">
                        {user.username}
                        <button className="sign-out-btn" onClick={signOut}>Sign Out</button>
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