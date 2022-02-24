import React, { useEffect } from 'react'
import Popup from './Popup'

import './Menu.css'
import { useState } from 'react'

export default function Menu() {
  const [buttonPopup, setButtonPopup] = useState(false);
  const [timedPopup, setTimePopup] = useState(false);

  /* useEffect(() => {
    setTimeout(() => {
      setButtonPopup(true);
    }, 1);
  }, []); */

  return (
    <div className='menu'>
      <main>
        <button onClick={() => setButtonPopup(true)} >Menu</button>
      </main>
      <Popup triger={buttonPopup} setTrigger={setButtonPopup}>
        <div className='head-menu'>Menu</div>
        <div className='bottuns'>
          <button >Home</button>
          <button >Restart</button>
          <button >Top Up</button>
        </div>
      </Popup>

      {/* <Popup triger={timedPopup} setTrigger={setTimePopup}>
        <h1>Menu</h1>
      </Popup> */}
    </div>
  )
}
