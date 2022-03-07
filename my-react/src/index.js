import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import { BrowserRouter ,Router,Route,Link,Routes} from "react-router-dom";

import Banner from './home-section/Banner';
import Game from './home-section/Game';
import Nav from './components/Nav';
import Credit from './home-section/Credit';
import Carin_heart from './stage/Carin_heart';
import Carin_lungs from './stage/Carin_lungs';

ReactDOM.render(
<React.StrictMode>
	<App />
	<BrowserRouter>
		
		<Routes>
			<Route exact path='/' element={<Banner/>}/>
			<Route  path='home' element={<Banner/>}/>
			<Route  path='aboutus' element={<Credit/>}/>
			<Route  path='game' element={<Game/>}/>
			<Route  path='heart' element={<Carin_heart/>}/>
			<Route  path='lungs' element={<Carin_lungs/>}/>
		</Routes>
	</BrowserRouter>
</React.StrictMode>,
document.getElementById('root')
);
