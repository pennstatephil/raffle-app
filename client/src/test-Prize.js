// import React, { useState, useEffect } from "react";  
import React from "react";  


export default class Prize extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      ticketNum: 0
    }
  }

  handleTickNumChange = e => {
    this.setState({ticketNum:  e.target.value})
  }
 
  componentDidUpdate() {
    console.log('componentDidUpdate', this.props.prize.currentUserTicketsEntered, this.state.ticketNum)
    if(this.props.prize.currentUserTicketsEntered !== this.state.ticketNum) {
    console.log('componentDidUpdate', this.props.prize.currentUserTicketsEntered, this.state.ticketNum)

      this.setState({ticketNum: 0})
    console.log('componentDidUpdate', this.props.prize.currentUserTicketsEntered, this.state.ticketNum)

    }
  }
  
  render() {
    return (
        <div>
          <h3>Tickets</h3>
          <input
            value={this.state.ticketNum}
            onChange={(e) => {
              this.handleTickNumChange(e.target.value)
              this.props.allFunc.handleTicketNumEntered(this.props.prize.id, e.target.value)
            }
          }
            
          />
      </div>
    
    )

  }
    

}