import { useEffect, useState, useCallback } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Header from "./components/Header";
import Error from "./pages/404Error";
import About from "./pages/About";
import Blurbs from "./pages/Blurbs";
import BlurbsDetail from "./pages/BlurbsDetail";
import BlurbsForm from "./components/BlurbsForm";
import Contact from "./pages/Contact";
import CrystalCollection from "./pages/CrystalCollection";
import CrystalDetail from "./pages/CrystalDetail";
import CrystalForm from "./components/CrystalForm";
import SignIn from "./pages/SignIn";
import Welcome from "./pages/Welcome";

function App() {
  return (
  <Router>
    <Header/>
    <Routes>
      <Route path="/" element={ <SignIn /> } />
      <Route path="/welcome" element={ <Welcome /> } />
      <Route path="/crystals" element={ <CrystalCollection /> } />
      <Route path="/crystals/detail/:crystalId" element={ <CrystalDetail /> } />
      <Route path="/blurbs" element={ <Blurbs /> } />
      <Route path="/blurbs/detail/:blurbsId" element={ <BlurbsDetail /> } />
      <Route path="/about" element={ <About /> } />
      <Route path="/contact" element={ <Contact /> } />
      <Route path="*" element={ <Error /> } />
      <Route path="/blurbsform" element={ <BlurbsForm /> } />
      <Route path="/crystalform" element={ <CrystalForm /> } />
      
    </Routes>
  </Router>
  );
}

export default App;
