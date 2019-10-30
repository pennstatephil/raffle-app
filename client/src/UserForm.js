import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";

const useStyles = makeStyles(theme => ({
  container: {
    display: "flex",
    flexFlow: "column",
    "padding-right": '150px'
  },
  textField: {
    marginLeft: theme.spacing(1),
    marginRight: theme.spacing(1)
  },
  dense: {
    marginTop: theme.spacing(2)
  },
  menu: {
    width: 200
  }
}));

export default function UserForm(props) {
  const classes = useStyles();
  const [values, setValues] = React.useState({
    name: "",
    email: "",
    donationAmount: ""
  });

  const handleNameChange = name => event => {
    setValues({ ...values, [name]: event.target.value });
    debugger
    props.handleNameChange(event.target.value)
  };

  const handleEmailChange = email => event => {
    setValues({ ...values, [email]: event.target.value });
    props.handleEmailChange(event.target.value)
  };

  const handleDonationAmountChange = donationAmount => event => {
    setValues({ ...values, [donationAmount]: event.target.value });
    props.handleDonationAmountChange(event.target.value)

  };

  return (
    <form className={classes.container} noValidate autoComplete="off">
      <TextField
        required
        id="outlined-name"
        label="Name"
        className={classes.textField}
        value={values.name}
        onChange={handleNameChange("name")}
        margin="normal"
        variant="outlined"
      />
      <TextField
        required
        id="outlined-email"
        label="Email"
        className={classes.textField}
        value={values.email}
        onChange={handleEmailChange("email")}
        margin="normal"
        variant="outlined"
      />
      <TextField
        required
        id="outlined-donation-amount"
        label="Donation Amount ($)"
        className={classes.textField}
        value={values.donationAmount}
        onChange={handleDonationAmountChange("donationAmount")}
        margin="normal"
        variant="outlined"
      />
    </form>
  );
}
