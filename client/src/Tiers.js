import React from "react";

export default function Tiers(props) {
  const tiers = []

  for(let i in props.info.tiers) {
    tiers.push(<div key={i} className='tier'>${i}: {props.info.tiers[i]} tickets</div>)
  }

  return (
    <div className='tiers-container'>
      <h2 className='text-left tiers-title'>Tiers</h2>    
      <ul className='tiers-info'>{tiers}</ul>

    </div>
  )
}