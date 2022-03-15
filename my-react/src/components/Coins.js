import React, { useState } from 'react'
import './Coins.css'


export default function Coins() {
  
  const globals = require ('../utils/global.js')
  var [currentcoin , setCoin] = useState(0);

  
  console.log("coin : " + globals.currentCoint )

  function disCoin(){
    return globals.currentCoint;
  }
  
  return (
    <div className='Coins' >
        <div className='coin-contain'>
          <img  src='/image/btn/cellCredit.png' width={"64px"} height={"64px"}></img>
          <div className='currentcredit' >x {disCoin()}</div>
        </div>
        
    </div>
  )
}
