import React from 'react'
import { useState } from 'react'

export default function Fast() {


    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);
    console.log(click);




  return (
    <div id='fast'>
        <div className='fast-btn' onClick={handleClick}>{click ? (
            <img  src={('/image/btn-menu/fastforward.png')}  ></img>
                ) : (
            <img  src={('/image/btn-menu/next.png')}  ></img>
                )}
            
        </div>
    </div>
        
  )
}
