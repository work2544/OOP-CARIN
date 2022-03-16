import React, { useEffect } from 'react'

import Popup from './Popup'
import './Menu.css'
import { useState } from 'react'
import { Link} from 'react-router-dom'

export default function Menu() {
  const [buttonPopup, setButtonPopup ,] = useState(false);
  const [timedPopup, setTimePopup] = useState(false);

  /* useEffect(() => {
    setTimeout(() => {
      setButtonPopup(true);
    }, 1);
  }, []); */

  return (
    <div className='menus'>
      <main>
        <div className='menu-btn'>
        <img  className='btn-menus' src={('/image/btn-menu/barsHorizontal.png')} 
        onClick={() => setButtonPopup(true)} ></img>
        </div>
      </main>
      <Popup triger={buttonPopup} setTrigger={setButtonPopup}>
        <div className='head-menu'>Menu</div>
        <div className='bottuns'>
          <Link  to="/home" spy={true} smooth={true}><button className='btn-restart'>
            <img src={('/image/btn-menu/home.png')}></img></button></Link>
          <Link  to="/game" spy={true} smooth={true}><button className='btn-restart'>
            <img src={('/image/btn-menu/return.png')}></img></button></Link>
          <Link  to="/home" spy={true} smooth={true}><button className='btn-restart'>
            <img src={('/image/btn-menu/door.png')}></img></button></Link>
        </div>
      </Popup>

      {/* <Popup triger={timedPopup} setTrigger={setTimePopup}>
        <h1>Menu</h1>
      </Popup> */}
    </div>
  )
}
