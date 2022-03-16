import React from 'react'
import './Popup.css'

function PausePop(props) {
  
  return (props.triger) ? (
    <div className='popup'>
      <div className='popup-inner'>
        <button className='close-btn' onClick={() => props.setTrigger(false)}>X
        </button>
        {props.children}
      </div>
    </div>
  ) : "";
}

export default PausePop
