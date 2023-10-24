import { NavLink, Link } from "react-router-dom";

import "../styles/navbar.css";

function NavBar() {

    return (
        <nav>
            <div className="navbar-container">
                <ul>
                    <li className="nav-item">
                    <NavLink to="/"  className="nav-link">
                        Home
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
                </ul>
            </div>

        </nav>
        
    )
}

export default NavBar;