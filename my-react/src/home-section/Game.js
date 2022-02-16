import React from 'react'
import "./Game.css"

let aboutData = {
    title: "Game",
    desc : "place my game"
}

export default function Game() {
  return (
      <div id='game'>
    <div className='game-bg'>
        <div className='game'>
            <div className='container'>
                <div className='game-con'>
                    <div className='game-text'>
                        <h1>{aboutData.title}</h1>
                        <p>
                        {aboutData.desc}
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
  )
}
