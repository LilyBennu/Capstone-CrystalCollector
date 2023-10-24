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

import { refreshToken, signOut } from "./services/authAPI";

const TIMEOUT_MILLISECONDS = 14 * 60 * 1000;

function App() {

  const [user, setUser] = useState();
  const [initialized, setInitialized] = useState(false);

  const resetUser = useCallback(() => {
    refreshToken()
      .then((user) => {
        setUser(user);
        setTimeout(resetUser, TIMEOUT_MILLISECONDS);
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => setInitialized(true));
  }, []);

  useEffect(() => {
    resetUser();
  }, [resetUser]);

  const auth = {
    user: user,
    handleLoggedIn(user) {
      setUser(user);
      setTimeout(resetUser, TIMEOUT_MILLISECONDS);
    },
    hasAuthority(authority) {
      return user?.authorities.includes(authority);
    },
    signout() {
      signOut();
      setUser(null);
    },
  };

  if (!initialized) {
    return null;
  }

  const renderWithAuthority = (Component, ...authorities) => {
    for (let authority of authorities) {
      if (auth.hasAuthority(authority)) {
        return <Component />;
      }
    }
    return <Error />;
  };



  return (

    <div className="route-container">
        <AuthContext.Provider value={auth}>
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
                <Route path="/blurbsform/:blurbsId" element={ <BlurbsForm /> } />
                <Route path="/crystalform" element={ <CrystalForm /> } />
                <Route path="/error" element={ <Error /> } />
                <Route path="*" element={ <NotFound /> } />
                
              </Routes>
          </Router>
        </AuthContext.Provider>

    </div>
    

  );
}

export default App;
