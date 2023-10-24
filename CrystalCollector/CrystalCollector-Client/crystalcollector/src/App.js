import { useEffect, useState, useCallback } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Header from "./components/Header";
import NotFound from "./pages/NotFound";
import About from "./pages/About";
import AuthContext from "./contexts/AuthContext";
import Blurbs from "./pages/Blurbs";
import BlurbsDetail from "./pages/BlurbsDetail";
import BlurbsForm from "./components/BlurbsForm";
import Contact from "./pages/Contact";
import CrystalCollection from "./pages/CrystalCollection";
import CrystalDetail from "./pages/CrystalDetail";
import CrystalForm from "./components/CrystalForm";
import Error from "./pages/Error";
import SignIn from "./pages/SignIn";
import SignInForm from "./components/SignInForm";
import SignUpForm from "./components/SignUpForm";
import Welcome from "./pages/Welcome";

import { refreshToken, logout } from "./services/authAPI";

const TIMEOUT_MILLISECONDS = 14 * 60 * 1000;

function App() {

  const [user, setUser] = useState();



  return (
  <Router>
    <Header/>
    <Routes>
      <Route path="/" element={ <SignIn /> } />
      <Route path="/signin" element={ <SignInForm /> } />
      <Route path="/signup" element={ <SignUpForm /> } />
      <Route path="/welcome" element={ <Welcome /> } />
      <Route path="/crystals" element={ <CrystalCollection /> } />
      <Route path="/crystals/detail/:crystalId" element={ <CrystalDetail /> } />
      <Route path="/blurbs" element={ <Blurbs /> } />
      <Route path="/blurbs/detail/:blurbsId" element={ <BlurbsDetail /> } />
      <Route path="/about" element={ <About /> } />
      <Route path="/contact" element={ <Contact /> } />
      <Route path="/blurbsform" element={ <BlurbsForm /> } />
      <Route path="/crystalform" element={ <CrystalForm /> } />
      <Route path="/error" element={ <Error /> } />
      <Route path="*" element={ <NotFound /> } />
      
    </Routes>
  </Router>
  );
}

export default App;
