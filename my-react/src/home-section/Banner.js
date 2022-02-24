import React ,{ useState } from 'react'
import {Link} from 'react-scroll'
import "./Banner.css"

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
        <div id='banner'>
        <div className="banner-bg">
        <div className="container">
            <div className="banner-con" >
                <div className='banner-logo'>
                <div className="banner-text">
                    {/* <h1>{bannerData.title}</h1>
                    <p>
                        {bannerData.desc}
                    </p> */}
                    <Link to='/game' spy={true} smooth={true}>
                    <a className="banner-btn">Play</a></Link>
                    </div>
                </div>
            </div>
            
        </div>
        </div>
    </div>
    )
}

export default Banner