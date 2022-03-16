import React, { Component ,useState } from 'react'
import { useDrop } from 'react-dnd'
import './Cell.css'
import Host from './Host/Host'
import axios from 'axios'

const globals = require('../utils/global');


export default function Cell({anti,x,y}) {

  axios.get('http://localhost:3000/', function (req,res) {
    res.json({ cell : cellData})
  });

  const Antivirus = new Host(null,x,y);

  const position = {
    x : x,
    y : y,
  }
  
  const cellData = {
    anti : Antivirus.state,
    position,
  }

  const addAnti = () => {
    if(globals.selectedHero !=null){
      setClick(!click)
      Antivirus.state.id = globals.selectedHero;
      cellData.anti = Antivirus.state;
      
      axios.get('http://localhost:3000/' )
    .then(res => {
      console.log("Cell Data " + "[" + x + "]" +  "[" + y + "]", cellData)
    })
    .catch(err =>{
      console.error(err)
    }) 
      
    }
    
  }
  const [click, setClick] = useState(false);

  function removeAnti(){
    if(anti != null){
      anti = null;
      globals.selectedHero = null;

    }
  }

  
  
  
  

  /* console.log(cellData); */



  return (
    <div className='Cell' onClick= {addAnti }>
      {click? (
                <div>
                  <img className='anti-create' src={`image/antivirus/Anti${globals.selectedHero}.png`}></img>
                </div>
                  ) : (
                  null
                  )}

      
    </div>
  )
}



