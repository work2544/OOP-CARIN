import React ,{Component}from 'react'
import Carin from './Carin'
import "./Game.css"




let aboutData = {
    title: "Game",
    desc : "place my game"
}

export default function Game()  {
  return (
    <div id='game'>
      <div className='game'>
        <div className='game-bg'>
        <div className='container'>
          <div className='game-con'>
          <div className='game-texthead'>
            <h1></h1>
          </div>
          <div className='carin' >
                <Carin/>
              </div>
          </div>
          </div>
        </div>
      </div>
    </div>
  )
}
