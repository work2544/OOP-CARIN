import React from 'react'
import { useState } from 'react'

export default function Fast() {


    const [click, setClick] = useState(window.isFase);
    const handleClick = () => setClick(!click);

    if(!click){
      console.log("NotFast");
    }else{
      console.log("Fast");
    }
    




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
