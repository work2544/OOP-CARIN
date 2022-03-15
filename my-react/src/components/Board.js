import React, { useState } from 'react'
import { useDrop } from "react-dnd";
import Config from './Config'
import './Board.css'
import Cell from './Cell'

const x = 16;
const y = 7

export default function Board() {

  const [board, setBoard] = useState([]);

  for(let i=0; i< y; i++){
      for(let j=0; j<x; j++){
          board.push(<Cell x={i} y={j}/>)
      }
  }
  return ( 
    <div className='bg'>
      <div id='board'>{board}</div>
    </div>
      
    
    
  )
}
