import React from 'react'
import { useState } from 'react'
import axios from 'axios';

export default function Slow() {

  axios.get('http://localhost:3000/')
  .then(res => {
    if(!click){
      console.log("NotSlow");
    }else{
      console.log("Slow");
    }
  })
  .catch(err =>{
    console.error(err)
  })

    const [click, setClick] = useState(window.isSlow);
    const handleClick = () => setClick(!click);
    

    


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
