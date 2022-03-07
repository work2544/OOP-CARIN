import React from 'react'
import { useState } from 'react'

export default function Pause() {


    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);
    console.log(click);




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
