import React from "react";  
import PrizeInSummmary from './PrizeSummary'

export default function Summary(props) {
  let prizeArr = []

  for (let key in props.entries) {
    let prize = props.getPrizeInfo(key)

    if(prize) {
      prize['entry'] = props.entries[key]
      prizeArr.push(<PrizeInSummmary key={key} prize={prize}/>) 
    }
    else  {
      console.error(`Summary | getPrizeInfo error: cannot find a matched id in prizes`)
      alert('Cannot display summary. Please notify the Admin')
    }
      
  }

  return (
    <div>
      <h3>Here's your summary:</h3>
      <h5>name: {props.name}</h5>
      <h5>email: {props.email}</h5>
      <h5>donation: ${props.donationAmount}</h5>
      <div className='prizes-container'>
        {prizeArr}
      </div>
    </div>
  )
}
