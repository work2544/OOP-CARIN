import React from 'react'
import Popup from '../components/Menu/Popup'
import axios from 'axios'

import { useState } from 'react'
import { Link} from 'react-router-dom'
import Carin_lungs from '../stage/Carin_lungs';
import Carin_heart from '../stage/Carin_heart';

import './Imune.css';
export default function Imune() {

  const imune = () => {
    axios.get("http://localhost:3001/game").then(res => {
      console.log(res.data)
    })
  }

  const [buttonPopup1, setButtonPopup1] = useState(false);
  const [buttonPopup2, setButtonPopup2 ] = useState(false);

  return (
    <><div className='imune'>
      <main>
        <div className='imune-bg'>
          <div className='head-text'>
            <h1>Select Organs</h1>
          </div>
          
          <div className='organ-select'>
            <Link to={'/heart'}><img className='zoomIn-carin' src={('/image/organ/heart.png')}></img></Link>
            <Link to={'/lungs'}><img className='zoomIn-carin' src={('/image/organ/lungs.png')}></img></Link>
          </div>
        </div>
      </main>
      
    </div>
    {/* <div className='carin-pop'>
        <Carin_heart triger={buttonPopup1} setTrigger={setButtonPopup1}></Carin_heart>
    </div>  
  
    <div className='carin-pop'>
        <Carin_lungs triger={buttonPopup2} setTrigger={setButtonPopup2}></Carin_lungs>

    </div> */}
    

      </>
  )
}
