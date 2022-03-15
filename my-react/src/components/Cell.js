import React, { Component } from 'react'
import { useDrop } from 'react-dnd'
import './Cell.css'
import Host from './Host/Host'




export default function Cell({anti,x,y}) {

  const position = {
    x : x,
    y : y,
  }
  
  const cellData = {
    anti : anti,
    position,
  }

  

  console.log(cellData);



  return (
    <div className='Cell'></div>
  )
}



