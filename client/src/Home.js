import React from 'react'
import UserForm from "./UserForm";
import Tiers from "./Tiers"
import TopMessage from './TopMessage'
import Prizes from './Prizes'
import BottomMessage from './BottomMessage'
import Buttons from './Buttons'

export default function Home(props) {
  return (
    <div>
      <div className="top-container">
        <UserForm info={props.info} allFunc={props.allFunc}/>
        <Tiers info={props.info}/>
      </div>
      <div className='top-message-container'>
        <TopMessage info={props.info} allFunc={props.allFunc}/>
      </div>
        <div className='prizes-container'>
          <Prizes info={props.info} allFunc={props.allFunc} {...props}/>
        </div>
        <BottomMessage info={props.info} allFunc={props.allFunc} />
        <div className='buttons-container'>
          <Buttons  info={props.info} allFunc={props.allFunc}  />
        </div>
    </div>
  )
}
