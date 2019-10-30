import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Button from "@material-ui/core/Button";
import { useHistory } from "react-router-dom";
import axios from 'axios'

const useStyles = makeStyles(theme => ({
  button: {
    margin: theme.spacing(1),
    'background-color': '#659EC7'
  },
  input: {
    display: "none"
  }
}));

export default function Buttons(props) {
  let history = useHistory();
  const classes = useStyles();

  const handleSubmitButton = () => {
    const url = `https://localhost:8000/raffles/${props.id}/entry`
    const entries = []

    for (let i in props.entries) {
      entries.push(
        {
          prize: {
            id: i
          },
          tickets: props.entries[i]
        }
      )
    }

    const info = {
      user: {
        name: props.name,
        email: props.email
      },
      donation: {
        amount: props.donationAmount
      },
      entries: entries
    }


    axios.post(url, info)
      .then(response => {
        console.log(`post request, response.data, ${response.data}`)
        history.push('/summary')
      })
      .catch(err => {
        console.error(`post request, error ${err}`)
       alert('Somethng went wrong. Please notify the Admin')
      })

    /*
    mocking successful post request
    */
    // history.push('/summary')
  }


  let result = props.checkTicketsEntered()

  if (result === 0) result = true
  else              result = false

  return (
    <div>
      <Button
        variant="contained"
        color="primary"
        disabled={!result} 
        className={classes.button}
        onClick={handleSubmitButton}
      >
        Submit
      </Button>
      <Button
        variant="contained"
        color="primary"
        disabled={!result}
        className={classes.button}
        onClick={props.handleClearTicketNum}
      >
        Clear Tickets
      </Button>
    </div>
  );
}
