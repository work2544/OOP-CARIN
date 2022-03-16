import React, { Component } from 'react'


class Button extends Component {


    constructor(imageUrl ,width ,height,x ,y) {
      super(props)
      
      this.imageUrl = imageUrl;
      this.position = {
        x : x,
        y : y,
      }
      
    }

  render() {
    return (
      <div>Button</div>
    )
  }
}
