import React, { Component } from 'react';
import './App.css';


import Tail from './home-section/Tail';
import Banner from './home-section/Banner';
import Game from './home-section/Game';
import Nav from './components/Nav';
import About from './home-section/About';
import Credit from './home-section/Credit';

import { BrowserRouter ,Router,Route,Link,Routes} from "react-router-dom";
import { DndProvider } from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";
import DragDrop from './controller/DragDrop';
import AnitiBar from './components/AntiBar';





export default class App extends Component {
	render(){
		return (
	<div></div>
	)
	}
}



