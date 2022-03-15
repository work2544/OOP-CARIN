import React from 'react'
import { useState } from 'react'

export default function Pause() {


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
