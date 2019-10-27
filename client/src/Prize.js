import React from "react";  
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const useStyles = makeStyles(theme => ({
  container: {
    display: 'flex',
    flexWrap: 'wrap',
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1),
  },
  dense: {
    marginTop: theme.spacing(2),
  },
  menu: {
    width: 200,
  },
}));

export default function Prize(props) {
  const classes = useStyles();

  let entry = props.entries[props.id] 
    ? props.entries[props.id]
    : ''

  return (
    <div className='prize-container'>
      <h4>{props.name}</h4>
      <img height='250' width='250' src={props.imageUrl} alt='prize'></img>
      <h5>Current Entries: {props.ticketsEntered}</h5>
      <div>
        <h3>Tickets</h3>
        <TextField
          disabled={!props.isUserInfoAllEntered}
          id="outlined-bare"
          className={classes.textField}
          margin="normal"
          variant="outlined"
          inputProps={{ 'aria-label': 'bare' }}
          value={entry}
          onChange={(e) => {
            // props.allFunc.setTicketNum(e.target.value)
            props.allFunc.handleTicketNumEntered(props.id, e.target.value)
          }
        }
          
        />
      </div>
    </div>
  )
}