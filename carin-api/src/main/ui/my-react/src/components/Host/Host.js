import React, { Component } from 'react'



export default class Host {
    constructor(anti,x, y) {
        this.state = {
            id: anti,
            x: x,
            y: y,
            health: 100,
            value: null,
            /* redius : 64*2,
            hitting: false, */
            /* selectedHero: false, */
        }


        if(this.state.id = "Knight"){
            this.state.value = 100;
            this.state.redius = 64*2;
        }else if(this.state.id = "Mage"){
            this.state.value = 100;
            this.state.redius = 64*4;
        }else if(this.state.id = "Shield"){
            this.state.value = 100;
            this.state.redius = 64*1;
        }



        /* this.spriteWidth = 64;
        this.spriteHeight = 64; */
    
    }

    

    render() {
        return (
        <div id='host'>
            <div className='host'>
                {/* <img src={(`/image/antivirus/Anti${this.id}.png`)}></img> */}
            </div>
        </div>
        )
    }
    
}
