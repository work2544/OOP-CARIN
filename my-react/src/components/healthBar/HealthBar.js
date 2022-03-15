import PropTypes from 'prop-types'
import React, { Component } from 'react'
import GameResult from '../Popup/GameResult';
import './HealthBar.css'



export default class HealthBar extends Component {
  constructor(props){
    super(props)
    this.state={
    type : props,
    health : 100,

    
    };

    this.setHealth = this.setProgress.bind(this);
<<<<<<< HEAD
    console.log(this.state.health);
    this.gameResult();
  }
  
  
=======
    console.log(this.state.health)
    this.gameResult();
  }

>>>>>>> 231589286dfbe68e989d7ddc36434f9f0694b0d8
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

<<<<<<< HEAD
  setHealth(health){
    this.setState({health : health})
  }

=======
>>>>>>> 231589286dfbe68e989d7ddc36434f9f0694b0d8
   gameResult(){
     if(this.state.health <= 0){
      return GameResult();
     }
   }

  

  render() {
    return (
    <div className="Health-bar">
      <div className='health-con'>
        <div className='organ-icon'><img src={(`/image/organ/${this.props.type}_icon.png`)} onClick = {console.log(this.props)}></img></div>
        <div className='barr'>
          <div className='outner-bar'>
          <div className='inner-bar' style={{ 'width': this.state.health + '%' }} >{this.gameResult()}</div>
        </div>
          </div>
        
      </div>
<<<<<<< HEAD
      <button onClick={this.setProgress.bind(this, this.state.health > 0 ? this.state.health-20 : 100)}>Decrease</button>
      <button onClick={this.setProgress.bind(this, 100)}>Reset</button>
      <button onClick={this.setProgress.bind(this, this.state.health < 100 ? this.state.health + 20 : 100)}>Increase</button>
=======
      {/* <button onClick={this.setProgress.bind(this, this.state.health > 0 ? this.state.health - 20 : 0)}>Decrease</button>
      <button onClick={this.setProgress.bind(this, 100)}>Reset</button>
      <button onClick={this.setProgress.bind(this, this.state.health < 100 ? this.state.health + 20 : 100)}>Increase</button> */}
>>>>>>> 231589286dfbe68e989d7ddc36434f9f0694b0d8
    </div>
    )
  }
}
