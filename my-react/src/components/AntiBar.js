import React, { useState } from 'react'
import { useDrop,useDrag } from "react-dnd";
import './AntiBar.css'
import '../stage/Carin.css'

import AntiItem from './Itembar/AntiItem'
import Board from './Board';
import Cell from './Cell'
import Picture from '../controller/Picture';
import axios from 'axios';


const ItemList = [
  {
    id: 'knight',
    url: "image/btn/RebannerAntiKnight.png",
    value : 100,
  },
  {
    id: 'mage',
    url: 'image/btn/RebannerAntiMage.png',
    value : 150,
  },
  {
    id: 'shield',
    url: 'image/btn/RebannerAntiShield.png',
    value : 200,
  },
]

function AnitiBar() {


    
    const [board, setBoard] = useState([]);
    
    const addImageToBoard = (id) => {
      const itemList = ItemList.filter((picture) => id === picture.id);
      setBoard((board) => [...board, itemList[0]]);
    };

  


  return (
    
      <div className="Pictures">
        {ItemList.map((picture) => {
          return <AntiItem id={picture.id} url={picture.url} value={picture.value}/>
        })}
      </div>
  )
}

export default AnitiBar;
