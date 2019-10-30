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
        <UserForm {...props} />
        <Tiers {...props}/>
      </div>
      <div className='top-message-container'>
        <TopMessage {...props} />
      </div>
        <div className='prizes-container'>
          <Prizes {...props} />
        </div>
        <BottomMessage {...props}  />
        <div className='buttons-container'>
          <Buttons  {...props}   />
        </div>
    </div>
  )
}
