import React ,{Component}from 'react'
import "./Game.css"
import  Nav  from "../components/Nav";
import Imune from '../carin-component/Imune';

export default function Game()  {
  return (
    
    <div id='game'>
      <div className='game'>
        <div className='game-bg'>
          <div className='container'>
            <div className='game-con'>
              <div className='game-texthead'></div>
              <div className='game-carin' >
                  <Imune/>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}
