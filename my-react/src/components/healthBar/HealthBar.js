import PropTypes from 'prop-types'
import React, { Component } from 'react'
import GameResult from '../Popup/GameResult';
import './HealthBar.css'



export default class HealthBar extends Component {
  constructor(props){
    super(props);

    this.state={
    health : 100,
    type : props,
    };

    this.setHealth = this.setProgress.bind(this);
    console.log(this.state.health)
    this.gameResult();
  }

  static getDerivedStateFromProps(props) {
    return {type: props.type ,};
  }

  
  setProgress(amount){
      this.setState({health : amount})
      console.log(amount);
  }

  setType(type){
    this.setState({type : type})
  }

   gameResult(){
     if(this.state.health <= 0){
      return GameResult();
     }
   }

  

  render() {
    return (
    <div className="Health-bar">
      <div className='health-con'>
        <div className='organ-icon'><img src={(`/image/organ/${this.state.type}_icon.png`)}></img></div>
        <div className='barr'>
          <div className='outner-bar'>
          <div className='inner-bar' style={{ 'width': this.state.health + '%' }} >{this.gameResult()}</div>
        </div>
          </div>
        
      </div>
      {/* <button onClick={this.setProgress.bind(this, this.state.health > 0 ? this.state.health - 20 : 0)}>Decrease</button>
      <button onClick={this.setProgress.bind(this, 100)}>Reset</button>
      <button onClick={this.setProgress.bind(this, this.state.health < 100 ? this.state.health + 20 : 100)}>Increase</button> */}
    </div>
    )
  }
}
