import React from "react";  
import "./App.css";
// import payloadSample from './payloadSample'

import { BrowserRouter as Router, Route } from "react-router-dom";
import Home from './Home'
import Summary from './Summary'
import axios from 'axios'

class App extends React.Component {
  constructor() {
    super()

    this.state ={
      name: "",
      email: "",
      donationAmount: "",
      topMessage: "",
      tiers: [],
      prizes: [],
      ticketNum: 0,
      entries: {

      }      
    }
  }

  setTicketNum = (ticketNum) => {
    // const [ticketNum, setTicketNum] = useState("")
    this.setState({ticketNum: ticketNum})
  }

  handleNameChange = (name) => {
    this.setState({name: name})
  };

  handleEmailChange = (email) => {
    this.setState({email: email})
  };

  handleDonationAmountChange = (donationAmount) =>{
    this.setState({donationAmount: donationAmount})
  };

  handleTicketInputEnable = (isEnabled) => {
    this.setState({isTicketInputEnabled: isEnabled})
  }

  validateEmail = (email) => {
    return email.match(/\w+@\w+[.]\w+/)
  }

  checkUserInfo = () => {
    let name = this.state.name
    let email = this.state.email
    let donationAmount = this.state.donationAmount

    let arr = [];
    let emailValidated = false;

    if (!name) arr.push("name");
    if (!email) arr.push("email");
    else {
      emailValidated = this.validateEmail(email);
      if (!emailValidated) arr.push("email");
    }
    if (!donationAmount) arr.push("donation");
  
    let result 

    switch (arr.length) {
      case 1:
        result = 1
        break;
      case 2:
          result = 2
        break;
      case 3:
          result = 3
        break;
      case 0:
      default:
          result = 0
        break;
    }
    return [result, arr]
  }

  handleTicketNumEntered = (prizeId, num) => {
    if(num === '') num = 0

    num = Math.abs(parseInt(num))
      // let newPrizes = JSON.parse(JSON.stringify(this.state.prizes))

      // newPrizes.forEach(prize => {
      //   if(prize.id === prizeId) {
      //     return prize['currentUserTicketsEntered'] = num
      //   }
      // })

      /*
        entries: {
          id: num
        }
      */

      const entries = {...this.state.entries, [prizeId+'']: num}
      
      this.setState({entries: entries})
    
      
  }

  handleClearTicketNum = () => {


    
    this.setState({entries: {}})

      
  }


  checkTicketsEntered = () => {
    let [result] = this.checkUserInfo()
    let totalNum = this.state.tiers[this.state.donationAmount]

    const reducer = (accumulator, val) => {
      return accumulator + val
    }

    const values = Object.values(this.state.entries)

    let ticketNumEntered = values.reduce(reducer, 0)
    let calResult = totalNum - ticketNumEntered
    let response = null

    if(result === 0) {
      if(calResult === 0)
        response = 0
      else if (calResult > 0)
        response = calResult
      else if (calResult < 0)
        response = calResult
      // 
      else 
        response = null
    }
    
    return response
  }

  getPrizeInfo = (id) => {
    for(let i = 0; i <= this.state.prizes.length; i++) {
      if(this.state.prizes[i].id === parseInt(id)) {
        return this.state.prizes[i]
      }
    }
    return null
  }

  allFunc() {
    return {
      handleNameChange: this.handleNameChange,
      handleEmailChange: this.handleEmailChange,
      handleDonationAmountChange: this.handleDonationAmountChange,
      handleTicketInputEnable: this.handleTicketInputEnable,
      checkUserInfo: this.checkUserInfo,
      validateEmail: this.validateEmail,
      checkTicketsEntered: this.checkTicketsEntered,
      handleTicketNumEntered: this.handleTicketNumEntered,
      handleClearTicketNum: this.handleClearTicketNum,
      setTicketNum: this.setTicketNum,
      getPrizeInfo: this.getPrizeInfo
    }
  }


  componentDidMount() {
    axios.get('https://localhost:8000/')
      .then(response => {
        console.log(`first load, response.data, ${response.data}`)

        let initialPayLoad = response.data
        console.log('initialPayLoad', initialPayLoad)
    
        let tiers = {}
        initialPayLoad.tiers.forEach(tier => {
          tiers[parseInt(tier['amount'])] = tier['tickets']
        })
    
        this.setState({
          prizes: initialPayLoad.prizes,
          tiers: tiers
    
        })

      })
      .catch(err => {
        console.error(`first load, error ${err}`)
      })

      /* 
      this is the temp code to retrieve mock data 
      */
    // let response = payloadSample()
    // let initialPayLoad = response.initialPayLoad
    // console.log('initialPayLoad', initialPayLoad)

    // let tiers = {}
    // initialPayLoad.tiers.forEach(tier => {
    //   tiers[parseInt(tier['amount'])] = tier['tickets']
    // })

    // this.setState({
    //   prizes: initialPayLoad.prizes,
    //   tiers: tiers

    // })
  }


    render() {
      return (
        <div className="App">
          <Router>
            <Route 
              exact
              path='/' 
              render={() => (
                <Home info={this.state} allFunc={this.allFunc()} {...this.state}/>
              )}
            />

            <Route 
              path='/summary'
              render={() => (
                <Summary {...this.state} {...this.allFunc()} />
              )}
            />
          </Router>

          
        </div>
      )
    }
  
}

export default App;