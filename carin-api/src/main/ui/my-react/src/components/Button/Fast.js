import React from 'react'
import { useState } from 'react'
import axios from 'axios';

export default function Fast() {

  axios.get('http://localhost:3000/')
  .then(res => {
    if(!click){
      console.log("NotFast");
    }else{
      console.log("Fast");
    }
  })
  .catch(err =>{
    console.error(err)
  })

    const [click, setClick] = useState(window.isFase);
    const handleClick = () => setClick(!click);

    
    




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
