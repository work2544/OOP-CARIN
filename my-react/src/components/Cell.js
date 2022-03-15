import React, { Component ,useState } from 'react'
import { useDrop } from 'react-dnd'
import './Cell.css'
import Host from './Host/Host'
<<<<<<< HEAD
import axios from 'axios'

const globals = require('../utils/global');
=======

>>>>>>> 231589286dfbe68e989d7ddc36434f9f0694b0d8


export default function Cell({anti,x,y}) {

<<<<<<< HEAD
  axios.get('http://localhost:3000/' )
    .then(res => {
      console.log("Cell Data: ", cellData)
      
    })
    .catch(err =>{
      console.error(err)
    })
=======
export default function Cell({anti,x,y}) {
>>>>>>> 231589286dfbe68e989d7ddc36434f9f0694b0d8

  const position = {
    x : x,
    y : y,
  }
  
  const cellData = {
<<<<<<< HEAD
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
=======
    anti : anti,
    position,
  }

  

  console.log(cellData);



  return (
    <div className='Cell'></div>
  )
}

>>>>>>> 231589286dfbe68e989d7ddc36434f9f0694b0d8

  
  
  
  

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



