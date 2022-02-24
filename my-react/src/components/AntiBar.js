import React, { useState } from 'react'
import { useDrop } from "react-dnd";
import './AntiBar.css'
import '../home-section/Carin.css'

import AntiItem from './Itembar/AntiItem'
import Board from './Board/Board';
import Cell from './Board/Cell'
import Picture from '../controller/Picture';

const ItemList = [
  {
    id: 1,
    url:
      "image/btn/RebannerAntiKnight.png",
  },
  {
    id: 2,
    url:
      'image/btn/RebannerAntiMage.png',
  },
  {
    id: 3,
    url:
      'image/btn/RebannerAntiShield.png',
  },
]

function AnitiBar() {

    
    const [board, setBoard] = useState([]);

    const [{ isOver }, drop] = useDrop(() => ({
      accept: "image",
      drop: (item) => addImageToBoard(item.id),
      collect: (monitor) => ({
        isOver: !!monitor.isOver(),
      }),
    }));
  
    const addImageToBoard = (id) => {
      const ItemList = ItemList.filter((picture) => id === picture.id);
      setBoard((board) => [...board, ItemList[0]]);
    };

  return (
    <>
    <div className='board'>
      {/* <Board ref={drop}>
        {board.map((picture) => {
          return <AntiItem url={picture.url} id={picture.id} />;
        })}
      </Board> */}
      <div id='AntiBar'>
      <div className="Pictures">
        {ItemList.map((picture) => {
          return <AntiItem url={picture.url} id={picture.id} />;
        })}
      </div>
    </div>
    </div>
    
    
    </>
  )
}

export default AnitiBar;
