import React from 'react'

import Config from '../../Config'
import './Board.css'
import Cell from '../Cell'



export default function Board() {

  

    let board = [];

    for(let i=0; i< 7; i++){
        for(let j=0; j<16; j++){
            board.push(<Cell/>)
        }
    }
  return (
    <div id='board' >{board}</div>
    
    
  )
}
