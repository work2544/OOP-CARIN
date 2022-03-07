import React, { useState } from 'react'
import { useDrag , DragPreviewImage} from "react-dnd";
import { GiMouse } from 'react-icons/gi';




function AntiItem({ id, url }) {
  
  const [{ isDragging }, drag,preview] = useDrag(() => ({
    type: "image",
    item: { id: id },
    collect: (monitor) => ({
      isDragging: !!monitor.isDragging(),
    }),
  }));

  const [click, setClick] = useState(false);
  const selectAnti = () => {
    setClick(!click)
    console.log("createAnti")
  }
  
  
  
  
  return (
    <>
    <DragPreviewImage connect={preview} src={`image/antivirus/Anti${id}.png`} />
    <img onClick={selectAnti}
      ref={drag}
      src={url}
      width="150px"
      style={{ border: isDragging ? "5px solid pink" : "0px" }} 
      />
      </>
  );
}

export default AntiItem;