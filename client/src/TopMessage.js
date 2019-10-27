import React from "react";

export default function TopMessage(props) {
  let newStr = "Please enter your ";
  const [result, arr] = props.allFunc.checkUserInfo(props.info)

  switch (result) {
    case 0:
        let number = props.info.tiers[props.info.donationAmount]
        newStr = `Thanks! You have ${number} tickets to spend.`;
        break;
    case 1:
      newStr += `${arr.join()}.`;
      break;
    case 2:
      newStr += `${arr.join(' and ')}.`;
      break;
    case 3:
      newStr += `${arr[0]}, ${arr[1]}, and ${arr[2]}.`;
      break;
    default:
      newStr = ''
      break;
  }


  return <h3>{newStr}</h3>

}
