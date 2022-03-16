import React from 'react'
import "./About.css"
import Nav from '../components/Nav';

let aboutData = {
    title: "About Game",
    lead1: "Amidst the pandemic, the human bodies have responded!  Upon the arrival of Covid viruses, you as a player will be controlling the immune system to eliminate the incoming viruses before they destroy your body.",
    lead2: "You are in control of your antibodies.  At any time unit, you can choose to place a new antibody in an empty cell.  Alternatively, you can choose to move an existing antibody to another location.  But antibodies don't come for free.  At the beginning of time, your body has antibody credits that you can spend. Every time you place a new antibody, you lose some antibody credits.  You can gain additional antibody credits by having an antibody destroy a virus.",
}

export default function Credit() {
  return (
    <>
    <div id='aboutgame'>
        <div className='about'>
            <div className='about-container'>
                <div className='row wrapper'>                                      
                    <h1 className='about-text'>
                        <span>{aboutData.title}</span>
                    </h1>
                    <p className='lead'>
                        {aboutData.lead1}
                    </p>
                    <br/>
                    <p className='lead'>
                        {aboutData.lead2}
                    </p>
                </div>
            </div>
        </div>
    </div></>

  )
}
