import React, { Component } from 'react'
import './Carin.css'
import { DndProvider } from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";

import * as bg_1 from "../assets/background/background.png";
import Board from '../components/Board/Board';
import AntiBar from '../components/AntiBar';
import AntiItem from '../components/Itembar/AntiItem';
import Menu from '../components/Menu/Menu';

export default class Carin extends Component {



  render() {
    return (
      
      <div className='carin'>
          <div className='carin-screen'>
            <div className='grid'>
              <Board/>
            </div>
            <div className='anti-bar'>
              <DndProvider backend={HTML5Backend}>
                <AntiBar/>
              </DndProvider>
            </div>
            <div className='menu'>
            <Menu/>
            </div>
          </div>
           
      </div>
    )
  }
}

function drawMap() {
        var map = document.createElement('div');
        map.style.backgroundImage = bg_1;
        document.body.appendChild(map)
    }



