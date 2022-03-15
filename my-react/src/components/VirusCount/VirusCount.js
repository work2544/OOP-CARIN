import React, { useState } from 'react'
import './VirusCount.css'

export default function VirusCount() {

  const [count ,setCount] = useState(0);

  window.virus_count = 0;
  

  return (
    <div className='VirusCount'>
        <div className='viruscount-contain'>
          <img  src='/image/btn/VirusCount.png' width={"40%"} height={"30%"}></img>
          <div className='currentvirus' console >x {count}</div>
        </div>
        
    </div>
  )
}
