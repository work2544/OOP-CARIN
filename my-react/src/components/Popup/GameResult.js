import React from 'react'
import './GameResult.css'
import { Link} from 'react-router-dom'

function GameResult() {
  return (
    <div className='gameresult-popup'>
        <div className='gamepopup-contain'>
            <li>
            <h1 className='gameover'>GameOver</h1>
            <Link  to="/home" spy={true} smooth={true} className='gameover-restart'>Restart</Link>
            </li>
        </div>  
            
        
        
    </div>
  )
}

export default GameResult