import React ,{ useState } from 'react'
import {Link} from 'react-scroll'
import "./Banner.css"

let bannerData = {
    title: "CARIN",
    desc: "Amidst the pandemic, the human bodies have responded!  Upon the arrival of Covid viruses, you as a player will be controlling the immune system to eliminate the incoming viruses before they destroy your body."
}

function Banner() {

    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);
    console.log(click);
    const closeMobileMenu = () => setClick(false);

    return (
        <div className="banner-bg">
        <div className="container">
            <div className="banner-con" >
                <div className="banner-text">
                    <h1>{bannerData.title}</h1>
                    <p>
                        {bannerData.desc}
                    </p>
                    <Link to='game' spy={true} smooth={true}>
                    <a path="game" className="banner-btn">Play</a></Link>
                    
                </div>
            </div>
            
        </div>
    </div>
    )
}

export default Banner