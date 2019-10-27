import React from 'react';

export default function ScratchPrize() {

  let prizes = [
    {
      id: 0,
      name: 'one'
    },
    {
      id: 1,
      name: 'two'
    }
  ]

  // if(prizes.length >= 1) {
    const [ticketNumObj, setTicketNumObj] = React.useState([
      {
        id: 0,
        ticketNum: ''
      }, {
        id: 1,
        ticketNum: ''
      }
    ])

    prizes = prizes.map((prize, index) => {
      console.log('index', index)
      console.log('ticketNumObj[index]', ticketNumObj[index])

      let blah = ticketNumObj[index]
        return (
          <div key={prize.id}>
            <h4>{prize.name}</h4>
            <div>
              <h3>Tickets</h3>
              <input
                type='text'
                value={blah.ticketNum}
                onChange={(e) => {
                  setTicketNumObj(prev => ({...prev, ticketNum: e.target.value}))
                }
              }               
              />
            </div>
          </div>
        )

      })

      return (
        <div>
          {prizes}
        </div>
      )
    // }
    // else {
    //   return <div></div>
    // }
     
    
}

