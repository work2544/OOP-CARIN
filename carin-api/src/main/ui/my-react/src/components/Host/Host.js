import React, { Component } from 'react'



export default class Host {
    constructor(anti,x, y) {
        this.id = anti;
        this.x = x;
        this.y = y;
        this.health = 100;
        this.value = 0;
        this.hitting = false;   
        this.hitNow = false;
        this.selectedHero = false;

        if(this.id = "knight"){
            this.value = 100;
        }else if(this.id = "mage"){
            this.value = 150;
        }else if(this.id = "shield"){
            this.value = 200;
        }



        /* this.spriteWidth = 64;
        this.spriteHeight = 64; */
    
    }

    

    render() {
        return (
        <div id='host'>
            <div className='host'>
                <img className='anti-seclect' src={(`/image/antivirus/Anti${this.id}.png`)}></img>
            </div>
        </div>
        )
    }
    
}
