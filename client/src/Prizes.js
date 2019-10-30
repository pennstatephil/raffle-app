import React from "react";  
import Prize from './Prize';

export default function Prizes(props) {
  const [result] = props.checkUserInfo(props.info)
  let isUserInfoAllEntered = false

  result === 0 ? isUserInfoAllEntered = true : isUserInfoAllEntered = false

  return (
    props.prizes.map(prize => {
      return <Prize key={prize.id} 
        isUserInfoAllEntered={isUserInfoAllEntered} {...props} {...prize}
      />
    })
  )
}


