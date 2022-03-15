import React from 'react'
import { useState } from 'react'
import axios from 'axios';

export default function Pause() {

  axios.get('http://localhost:3000/')
  .then(res => {
    if(!click){
      console.log("Running");
    }else{
      console.log("Pause");
    }
  })
  .catch(err =>{
    console.error(err)
  })

    const [click, setClick] = useState(window.isPause);
    const handleClick = () => setClick(!click);
    console.log(click);

    if(!click){
      console.log("Running");
    }else{
      console.log("Pause");
    }


  return (
    <div id='pause'>
        <div className='pause-btn' onClick={handleClick}>{click ? (
            <img  src={('/image/btn-menu/pause.png')}  ></img>
                ) : (
            <img  src={('/image/btn-menu/forward.png')}  ></img>
                )}
        </div>
    </div>
        
  )
}
