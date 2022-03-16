import React from 'react'
import "./Credit.css"
import Nav from '../components/Nav';

import VirusCount from '../assets/logo-carin.png'
let aboutData = {
    title: "About Us",
    desc : "Eren Yerger"
}

export default function Credit() {
  return (
    <><Nav />
    <div id='credit'>
          <div className='credit'>
              
                  <div className='credit-container'>
                    <h1 className='credit-text'>
                        <span>{aboutData.title}</span>
                    </h1>

                    <div className='main-card'>
                    <div className='cards'>
                        <div className='card'>
                            <div className='content'>
                                <div className='card-image'>
                                    <img src='https://scontent.fbkk5-6.fna.fbcdn.net/v/t39.30808-6/245962746_4309703632418793_4742555140405856488_n.jpg?_nc_cat=102&ccb=1-5&_nc_sid=09cbfe&_nc_eui2=AeHrKAi4tTFTgHBnm1ogEqc-wwFOZdmCxNXDAU5l2YLE1TZDMo-NF3qloGBUdWrll6BCr4jidxoTxP4QKu2CIVAj&_nc_ohc=AchKVp4vxkQAX9eOJbr&_nc_oc=AQnwB5GTsKDkIwj2IdiQ130LrBH9ARGkA3SM_ihGR_ueletHUEhnanIBjNUJUTkkjVE&tn=igO32Vvv7B8-8VoF&_nc_ht=scontent.fbkk5-6.fna&oh=00_AT-ad8UJCOzPqt5rDp7UdrfX1XoD9AVQNMT_axxvtX4EOw&oe=62335D3C' alt='Thun' draggable="false"></img>
                                    </div>
                                <div className='details'>
                                    <div className='name'>Thun Anuntarat</div>
                                    <div className='job'>Front-End</div>
                                    </div>
                                <div className='media-icons'>
                                    
                                    <a href="https://github.com/thunyoubun" target={'_blank'}>
                                        <img alt="fb" src="https://img.icons8.com/ios-glyphs/30/000000/github.png"
                                        width="30" height="30" object-fit="cover"></img>
                                        </a>
                                    <a href="https://www.facebook.com/switch.2412/" target={'_blank'}>
                                        <img alt="fb" src="https://img.icons8.com/fluency/48/000000/facebook-new.png"
                                        width="30" height="30" object-fit="cover"></img>
                                        </a>
                                </div>
                            </div>
                        </div>

                        <div className='card'>
                            <div className='content'>
                                <div className='card-image'>
                                <img src='https://scontent.fbkk5-4.fna.fbcdn.net/v/t1.6435-1/133725612_4840606656011156_4104838282884824006_n.jpg?stp=dst-jpg_p100x100&_nc_cat=103&ccb=1-5&_nc_sid=7206a8&_nc_eui2=AeGngUYKgm8j3BuemeyOinccJL3hKCRa3EIkveEoJFrcQrexMTHLbxbnHHiTjzwfwCuj_oTINRroxe9hL14uaUU_&_nc_ohc=eMNqxPmKOOQAX9rnWOB&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.fbkk5-4.fna&oh=00_AT9-U-CO4sPo2A9eCb78lIvFJ43VrWXR0Ew_KZTzP8lDPw&oe=624BCB9B' alt="Work" draggable="false"></img>
                                    </div>
                                <div className='details'>
                                    <div className='name'>Latthaphol Work</div>
                                    <div className='job'>Full-Stack</div>
                                    </div>
                                <div className='media-icons'>
                                    <a href="https://github.com/work2544" target={'_blank'}>
                                    <img alt="fb" src="https://img.icons8.com/ios-glyphs/30/000000/github.png"
                                        width="30" height="30" object-fit="cover"></img>
                                        </a>
                                    <a href="https://www.facebook.com/LatthapholWork" target={'_blank'}>
                                    <img alt="fb" src="https://img.icons8.com/fluency/48/000000/facebook-new.png"
                                        width="30" height="30" object-fit="cover"></img>
                                        </a>
                                </div>
                            </div>
                        </div>

                        <div className='card'>
                            <div className='content'>
                                <div className='card-image'>
                                <img src='https://scontent.fbkk5-7.fna.fbcdn.net/v/t1.6435-9/119127743_1213976578983602_1618818133765548127_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=09cbfe&_nc_eui2=AeGuka0hrca9uU8Izgn5R73N81t8yXQVL8XzW3zJdBUvxQJ8qvatXaNawmc3hpOLpp4FnztGgF-wAyWEwvnuq3eN&_nc_ohc=KljHfqIPsDAAX_uCsPO&_nc_ht=scontent.fbkk5-7.fna&oh=00_AT80COSEt_U3xx0w452tWfXMGAtY2SoSRvmxTcOAHIkGxA&oe=624CB6B3' alt="Thid" draggable="false"></img>
                                </div>
                                    
                                <div className='details'>
                                    <div className='name'>Thid Thidtanai </div>
                                    <div className='job'>Back-End</div>
                                </div>
                                <div className='media-icons'>
                                    <a href="https://github.com/Thidtanai" target={'_blank'}>
                                    <img alt="fb" src="https://img.icons8.com/ios-glyphs/30/000000/github.png"
                                        width="30" height="30" object-fit="cover"></img>
                                        </a>                            
                                    <a href="https://www.facebook.com/thidtanai.kaewphet" target={'_blank'}>
                                    <img alt="fb" src="https://img.icons8.com/fluency/48/000000/facebook-new.png"
                                        width="30" height="30" object-fit="cover"></img>
                                        </a>
                                </div>
                            </div>
                        </div>
                    </div>

                        
                    </div>
                 
              </div>
          </div>
      </div></>

  )
}
