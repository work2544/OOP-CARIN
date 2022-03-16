import React, { useState } from 'react'
import './Coins.css'

const globals = require ('../utils/global.js');

export default function Coins() {
  
  
  const [currentcoin , setCoin] = useState(0);
  const [click,setClick] = useState(false);

  console.log("coin : " + globals.currentCoint);

  function disCoin(){
    return globals.currentCoint ;
  }
  
  return (
    <div className='Coins'  >
        <div className='coin-contain'>
          <img  src='/image/btn/cellCredit.png' width={"64px"} height={"64px"} ></img>
          <div className='currentcredit' >x {disCoin()}</div>
        </div>
        
    </div>
  )
}
