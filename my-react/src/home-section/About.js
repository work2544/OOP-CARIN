import React from 'react'
import "./About.css"

let aboutData = {
    title: "ABOUT",
    desc : "Mai wai raw"
}

export default function About() {
  return (
      <div id='about' >
    <div className='about-bg'>
        <div className='about'>
            <div className='container'>
                <div className='about-con'>
                    <div className='about-text'>
                        <h1>{aboutData.title}</h1>
                        <p>
                        {aboutData.desc}
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>

  )
}
