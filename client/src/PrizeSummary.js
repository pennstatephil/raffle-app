import React from "react";  

export default function PrizeInSummary (props) {
  console.log('props', props)
  return (
    <div>
      <h5>
        {props.prize.name}
      </h5>
      <img height='250' width='250' src={props.prize.imageUrl} alt='prize'></img>
      <h5>
        tickets entered: {props.prize.entry}
      </h5>
    </div>
  )
}
