import React, { useState } from 'react'
import { useDrag , DragPreviewImage} from "react-dnd";
import { GiMouse } from 'react-icons/gi';
import Cell from '../Cell';
import Host from '../Host/Host';
import axios from 'axios';
import Coins from '../Coins/Coins';



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
    setClick(!click)
    
    if(window.currentcredit >= value){
      
      window.currentcredit -= value;
      console.log("createAnti")

    }
    
  }
    
  
  
  return (
  
    <><DragPreviewImage connect={preview} src={`image/antivirus/Anti${id}.png`} /><img onClick={selectAnti}
      /* ref={drag} */
      src={url}
      width="150px"
      style={{ border: isDragging ? "5px solid pink" : "0px" }}>

    </img></>

      
  );
}
