const prizes = [
  {
    id: 1,
    name: "One MILLION Dollars",
    ticketsEntered: 10,
    wonBy: null,
    current: 1
  },
  {
    id: 2,
    name: "One BILLION Dollars",
    ticketsEntered: 25,
    wonBy: null
  }
]

  const reducer = (acc, obj) => {
    if(obj.current && obj.current > 0)
      return acc + obj.current
    
    return acc
  }


  console.log(prizes.reduce(reducer, 0))