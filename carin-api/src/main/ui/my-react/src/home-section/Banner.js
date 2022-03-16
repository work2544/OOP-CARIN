import React ,{ useState } from 'react'
import {Link} from 'react-scroll'
import "./Banner.css"
import Nav from '../components/Nav';
import About from "./About";
let bannerData = {
    title: "CARIN",
    desc: "Astra Sinovac is the Best."
}

function Banner() {

    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);
    console.log(click);
    const closeMobileMenu = () => setClick(false);

    return (
        <>
        <Nav/>
        <div className='banner'>
            <div className="banner-bg">
                <div className="container">
                    <div className="banner-con">
                        <div className='banner-logo'>
                            <div className="banner-text">
                                {/* <h1>{bannerData.title}</h1>
    <p>
        {bannerData.desc}
    </p> */}

                                <a className="banner-btn" href='/game'>Play</a>
                            </div>
                        </div>
                        
                    </div>
                   
                </div>
                <About/> 
            </div>
            
        </div>
        
        
        </>
    )
}

export default Banner