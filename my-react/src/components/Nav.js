import React, { useState } from 'react'
import { FiCode, FiMenu, FiX} from "react-icons/fi";
import { GiAbstract099} from "react-icons/gi";
import { Link} from 'react-router-dom'
/* import {Link} from 'react-scroll' */


import './Nav.css'


function Nav() {

    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);
    console.log(click);
    const closeMobileMenu = () => setClick(false);
    const hoverHandler = () => {
        console.log("onMouseEnter")
    }
    const outHandler = () => {
        console.log("onMouseLeave")
    }

    return (
      <div className="navbar">
      <div className="container">
          <div className="nav-con">
              <div className="logo-container "  >
                  <a ><Link to="/" ></Link>{/* <GiAbstract099 /> */}</a>
              </div>
              <ul className={click ? "active" : "menu"}>
                  <li className="menu-link" onClick={closeMobileMenu}>
                      <a><Link  to="/Home" spy={true} smooth={true}>HOME</Link></a>
                  </li>
                  <li className="menu-link" onClick={closeMobileMenu}>
                      <a><Link  to="/Game" spy={true} smooth={true}>GAME</Link></a>
                  </li>
                  <li className="menu-link" onClick={closeMobileMenu}>
                      <a><Link  to="/AboutUs" spy={true} smooth={true}>ABOUT US</Link></a>
                  </li>
              </ul>
              <div className="mobile-menu" onClick={handleClick}>
                  {click ? (
                      <FiX />
                  ) : (
                      <FiMenu />
                  )}
              </div>
          </div>
      </div>
  </div>
)
}

export default Nav