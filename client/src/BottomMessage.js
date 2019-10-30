import React from "react";

export default function BottomMessage(props) {
  let message = ''
  let result = props.checkTicketsEntered()

  if(result === 0)
    message = `Ready to submit`
  else if (result > 0)
    message = `Warning: you have ${result} tickets remaining`
  else if (result < 0)
    message = `Warning: you have entered more tickets than you've donated`
  else
    message = ''

  return <h3>{message}</h3>

}
