import React, { Component } from 'react'
import { useState } from 'react'
import { DndProvider , useDrag, useDrop} from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";

import { lungsHealth } from "../components/Config";

import './Carin.css'

import Board from '../components/Board';
import AntiBar from '../components/AntiBar';
import Menu from '../components/Menu/Menu';
import Pause from '../components/Button/Pause';
import Slow from '../components/Button/Slow';
import Fast from '../components/Button/Fast';

import { ProgressBarContainer } from '../components/healthBar/ProgressBar';
import { Link } from 'react-router-dom';
import HealthBar from '../components/healthBar/HealthBar';
import Coins from '../components/Coins/Coins';
import VirusCount from '../components/VirusCount/VirusCount';






export default function Carin_lungs(props) {

  let health = lungsHealth;
  const [percentRange, setProgress] = useState(0);
  const [buttonPopup, setButtonPausePop] = useState(false);
  const [click, setClick] = useState(false);
  const handleClick = () => setClick(!click);
  console.log(click);

  


    return  (
      
      <div className='carin'>
        <div className='carin-contain'>
          <div className='carin-screen'>
            <div className='grid'>
              <Board/>
            </div>
            <div className='anti-bar' >
              <DndProvider backend={HTML5Backend}>
                <AntiBar/>
              </DndProvider>
            </div>

            <div className='head'>
              <li>
                <div className='healthbar' >
                  <HealthBar type={"lungs"} />
                  {/* <ProgressBarContainer percent={health} ></ProgressBarContainer> */}
                </div>
                <div className='coins'>
                  <Coins/>
                  </div>
                <div className='virusCount'>
                  <VirusCount/>
                </div>
                <div className='head-btn'>
                  <Link to={'/game'}><img className='zoomOut-btn' src={('/image/btn-menu/zoomOut.png')} ></img></Link>  
                  <button className='mu'><Slow/></button>
                  <button className='mu'><Pause/></button>
                  <button className='mu'><Fast/></button>
                  <button className='mu'><Menu/></button>
                </div>
              </li> 
            </div>
            
          </div>
          </div>
        </div>
      
    );
}

function changeImage(a) {
  document.getElementById("img").src=a.src;
}


