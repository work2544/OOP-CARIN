import React, {useState} from 'react';
import './ProgressBar.css';


const Range = (props) => {
    return (
        <div className="range" style={{width: `${props.percentRange}%`}}/>
    );
};

const ProgressBar = (props) => {
    return (
        <div className="progress-bar">
            <Range percentRange={props.percentRange}/>
        </div>
    );
};


export function ProgressBarContainer  (percent)  {
    let [percentRange ,setProgress] = useState(percent);
    console.log(percentRange);
    function gameOver(props) {
        if(percentRange <= 0 ){
            
        }
    }
    return (
        <div className="progress-container">
            <ProgressBar percentRange={percentRange}/>
            <div className="toggle-buttons">
                <button onClick={() => setProgress(percentRange > 0 ? percentRange - 20 : 0)}>Decrease</button>
                <button onClick={() => setProgress(percentRange < 100 ? percentRange + 20 : 100)}>Increase</button>
                <button onClick={() => setProgress(100)}>Reset</button>
            </div>
        </div>
    );
};