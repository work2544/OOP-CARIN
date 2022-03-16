import React, { Component ,useState } from 'react'
import { useDrop } from 'react-dnd'
import './Cell.css'
import Host from './Host/Host'
import axios from 'axios'

const globals = require('../utils/global');


export default function Cell({anti,x,y}) {

  axios.get('http://localhost:3000/' )
    .then(res => {
      console.log("Cell Data: ", cellData)
      
    })
    .catch(err =>{
      console.error(err)
    })

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
      setClick(!click)
    }
    
  }
  const [click, setClick] = useState(0);

  function removeAnti(){
    if(anti != null){
      anti = null;
      globals.selectedHero = null;

    }
  }

  
  
  
  

  /* console.log(cellData); */



  return (
    <div className='Cell' onClick= {addAnti}>
      {click? (
                  <img className='anti-create' src={`image/antivirus/Anti${globals.selectedHero}.png`}></img>
                  ) : (
                  removeAnti()
                  )}

      
    </div>
  )
}



