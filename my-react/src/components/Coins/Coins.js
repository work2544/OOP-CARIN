import React, { useState } from 'react'
import './Coins.css'


export default function Coins() {

  const [currentcoin , setCoin] = useState(0);

  
  
  console.log("coin : " + currentcoin )

  return (
    <div className='Coins'>
        <div className='coin-contain'>
          <img  src='/image/btn/cellCredit.png' width={"30%"} height={"30%"}></img>
          <div className='currentcredit' >x {currentcoin}</div>
        </div>
        
    </div>
  )
}
