import React from 'react'
import { useState } from 'react'

export default function Slow() {


    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);
    console.log(click);




  return (
    <div id='slow'>
        <div className='slow-btn' onClick={handleClick}>{click ? (
            <img  src={('/image/btn-menu/rewind.png')}  ></img>
                ) : (
            <img  src={('/image/btn-menu/previous.png')}  ></img>
                )}
            
        </div>
    </div>
        
  )
}
