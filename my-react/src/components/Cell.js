import React, { Component ,useState } from 'react'
import { useDrop } from 'react-dnd'
import './Cell.css'
import { Host } from './Host/Host'
import axios from 'axios'

const globals = require('../utils/global');


export default function Cell({anti,x,y}) {

  const Anti = new Host(null,x,y);

  axios.get('http://localhost:3000/' )
    .then(res => {
      console.log("Cell Data: ", cellData)
      
    })
    .catch(err =>{
      console.error(err)
    })
  
  const [click, setClick] = useState(false);

  const position = {
    x : x,
    y : y,
  }
  
  const cellData = {
    anti : globals.selectedHero,
    position,
  }

  const addAnti = () => {
    if(globals.selectedHero !=null){
      anti = globals.selectedHero;
      setClick(true)
    }
    
  }
  

  function removeAnti(){
    if(anti != null){
      anti = null;
      globals.selectedHero = null;
      Anti = null;

    }
  }

  
  
  
  

  /* console.log(cellData); */

{/* <img className='anti-create' src={`image/antivirus/Anti${globals.selectedHero}.png`}></img> */}
  return (
    <div className='Cell' onClick= {addAnti}>
      {click ? (
                <div className='anti-create'>
                  <Anti/>
                </div>
                  ) : (
                  removeAnti()
                  )}
    </div>
  )
}



