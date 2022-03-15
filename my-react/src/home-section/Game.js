import React ,{Component}from 'react'
import { useState } from 'react';
import "./Game.css"
import  Nav  from "../components/Nav";
import Imune from '../carin-component/Imune';
import axios from 'axios'
import AntiItem from '../components/Itembar/AntiItem';
import Cell from '../components/Cell';
import Host from '../components/Host/Host';




export default class Game extends Component {

 


  render() {
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

