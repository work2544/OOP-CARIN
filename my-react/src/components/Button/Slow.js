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
<<<<<<< HEAD
    

    
=======
    console.log(click);

    if(!click){
      console.log("NotSlow");
    }else{
      console.log("Slow");
    }
>>>>>>> 231589286dfbe68e989d7ddc36434f9f0694b0d8


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
