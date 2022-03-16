import React, { useState ,useEffect} from 'react'
import { useDrag , DragPreviewImage} from "react-dnd";
import { GiMouse } from 'react-icons/gi';
import Cell from './Cell';
import Host from './Host/Host';
import axios from 'axios';
import Coins from './Coins';
import './AntiItem.css'

const globals = require('../utils/global');



export default function AntiItem({ id, url ,value }) {

  

  const [{ isDragging }, drag,preview] = useDrag(() => ({
    type: "image",
    item: { id: id },
    value : {value : value},
    collect: (monitor) => ({
      isDragging: !!monitor.isDragging(),
    }),
  }));

  const [click, setClick] = useState(false);
  
  const selectAnti = () => {
    /* setClick(!click) */
    if(globals.currentCoint >= value){
    globals.currentCoint -= value;
    globals.selectedHero = id;
    console.log("selected Anti : " + globals.selectedHero)
    console.log("coin : "  + globals.currentCoint)

    return globals.currentCoint ;
    }else{
      globals.selectedHero = null;
    }
  }

  return (
  
    <>
    {/* <DragPreviewImage connect={preview} src={`image/antivirus/Anti${id}.png`} /> */}
    <div className='item'>
      
      <img onClick={selectAnti}
      /* ref={drag} */
      src={url}
      width="150px"
      /* style={{ border: isDragging ? "5px solid pink" : "0px" }} */>
      </img>
      <div className='value'>{value}</div>
    </div>
      </>

      
  );
}
