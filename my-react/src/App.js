import React, { Component } from 'react';
import './App.css';


import Home from './pages/Home';
import Banner from './home-section/Banner';
import Game from './home-section/Game';
import Nav from './components/Nav';
import About from './home-section/About';
import Credit from './home-section/Credit';




export default class App extends Component {
	render(){
		return (

	<>	
	
		<Nav/>
		<Banner/>
		<About/>
		<Game/>
		<Credit/>
		<Home />
	</>
	)
	}
}




