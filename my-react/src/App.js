import React, { Component } from 'react';
import './App.css';

import {BrowserRouter,
	Routes,
	Route} from 'react-router-dom'

import Home from './pages/Home';
import Banner from './home-section/Banner';
import Game from './home-section/Game';
import Nav from './components/Nav';
import About from './home-section/About';
import {  } from "./components/middleSection";

export default class App extends Component {
	render(){
		return (

	<>
		<BrowserRouter>
		<Nav/>
		<Banner/>
		<About/>
		<Game/>
		<Routes>
				<Route path="/" element={<Home/>}>
				<Route path="about" element={<About />} />
				<Route path="game" element={<Game />} />
			</Route>
		</Routes>
	</BrowserRouter>
	
	
	</>
	)
	}
}




