import React, { Component } from 'react';
import './App.css';


import Tail from './home-section/Tail';
import Banner from './home-section/Banner';
import Game from './home-section/Game';
import Nav from './components/Nav';
import About from './home-section/About';
import Credit from './home-section/Credit';


import { DndProvider } from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";
import Carin from './home-section/Carin';
import DragDrop from './controller/DragDrop';
import AnitiBar from './components/AntiBar';




export default class App extends Component {
	render(){
		return (
	<>
	<Nav/>
	<Banner/>
	<About/>
	<Game/>
	<Credit/>
	<Tail/>
	</>
	
	)
	}
}




