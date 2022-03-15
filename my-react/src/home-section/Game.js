import React ,{Component}from 'react'
import { useState } from 'react';
import "./Game.css"
import  Nav  from "../components/Nav";
import Imune from '../carin-component/Imune';
import axios from 'axios'
<<<<<<< HEAD
import AntiItem from '../components/AntiItem';
=======
import AntiItem from '../components/Itembar/AntiItem';
>>>>>>> 231589286dfbe68e989d7ddc36434f9f0694b0d8
import Cell from '../components/Cell';
import Host from '../components/Host/Host';




export default class Game extends Component {

<<<<<<< HEAD

  render() {
    
=======
 


  render() {
>>>>>>> 231589286dfbe68e989d7ddc36434f9f0694b0d8
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
}

