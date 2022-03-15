import React, { useState } from 'react'
import { useDrop,useDrag } from "react-dnd";
import './AntiBar.css'
import '../stage/Carin.css'

import AntiItem from './Itembar/AntiItem'
import Board from './Board';
import Cell from './Cell'
import Picture from '../controller/Picture';


const ItemList = [
  {
    id: 'Knight',
    url:
      "image/btn/RebannerAntiKnight.png",
  },
  {
    id: 'Mage',
    url:
      'image/btn/RebannerAntiMage.png',
  },
  {
    id: 'Shield',
    url:
      'image/btn/RebannerAntiShield.png',
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
          return <AntiItem url={picture.url} id={picture.id} />;
        })}
      </div>
  )
}

export default AnitiBar;
