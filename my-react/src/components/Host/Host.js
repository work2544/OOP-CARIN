import React, { Component } from 'react'
import '../Cell.css'

export class Host {
    constructor( anti, x, y ) {
        this.state = {
            id: anti,
            x: x,
            y: y,
            health: 100,
            value: null,
            hitting: false,
            selectedHero: false,
        }

        console.log(this.state)

        return (
            <div id='host'>
                <div className='host'>
                    <img  src={`image/antivirus/Anti${this.state.id}.png`}></img>
                </div>
            </div>
        )

    }
}
