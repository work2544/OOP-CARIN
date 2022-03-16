import React, { useState } from 'react'
import { FiCode, FiMenu, FiX} from "react-icons/fi";
import { GiAbstract099} from "react-icons/gi";
import { Link} from 'react-router-dom'
import {Link as LinkS} from 'react-scroll'


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
    <div id='nav'>
      <div className="navbar">
      <div className="container">
          <div className="nav-con">
              <div className="logo-container "  >
                  <a ><Link to="/" ></Link>{/* <GiAbstract099 /> */}</a>
              </div>
              <ul className={click ? "menu active" : "menu"} >
                  <li className="menu-link" onClick={closeMobileMenu}>
                      <a><Link  to="/home" spy={true} smooth={true} offset={-70} duration={500}>HOME</Link></a>
                  </li>
                  <li className="menu-link" onClick={closeMobileMenu}>
                    <a href='/home/#aboutgame'>ABOUT GAME</a>
                  </li>
                  <li className="menu-link" onClick={closeMobileMenu}>
                      <a><Link  to="/aboutus" spy={true} smooth={true} offset={-70} duration={500}>ABOUT US</Link></a>
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
  </div>
)
}

export default Nav