import React from 'react'
import "./About.css"
import Nav from '../components/Nav';
let aboutData = {
    title: "About us",
    desc : "Eren Yerger"
}

export default function Credit() {
  return (
    <><Nav />
    <div id='credit'>
          <div className='about'>
              <div className='about-bg'>
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
      </div></>

  )
}
