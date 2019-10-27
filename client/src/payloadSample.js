export default function payload() {
  let initialPayLoad = {
    id: 1,
    name: "First Raffle",
    createdBy: {
      id: 2,
      name: "Austin Powers",
      email: "austin@groovybaby.org",
      admin: false,
      created_at: "2019-10-11T14:39:09Z",
      updated_at: "2019-10-11T14:39:09Z"
    },
    active: true,
    startsAt: null,
    endsAt: null,
    prizes: [
      {
        id: 1,
        name: "One THOUSAND Dollars",
        imageUrl:
          "https://images.pexels.com/photos/259027/pexels-photo-259027.jpeg",
        ticketsEntered: 10,
        wonBy: null
      },
      {
        id: 2,
        name: "Ten THOUSAND Dollars",
        imageUrl:
          "https://images.pexels.com/photos/259027/pexels-photo-259027.jpeg",
        ticketsEntered: 25,
        wonBy: null
      },
      {
        id: 3,
        name: "One Hundred THOUSAND Dollars",
        imageUrl:
          "https://images.pexels.com/photos/259027/pexels-photo-259027.jpeg",
        ticketsEntered: 10,
        wonBy: null
      },
      {
        id: 4,
        name: "One MILLION Dollars",
        imageUrl:
          "https://images.pexels.com/photos/259027/pexels-photo-259027.jpeg",
        ticketsEntered: 25,
        wonBy: null
      },
      {
        id: 5,
        name: "One BILLION Dollars",
        imageUrl:
          "https://images.pexels.com/photos/259027/pexels-photo-259027.jpeg",
        ticketsEntered: 25,
        wonBy: null
      },
      {
        id: 6,
        name: "One MILLION Dollars",
        imageUrl:
          "https://images.pexels.com/photos/259027/pexels-photo-259027.jpeg",
        ticketsEntered: 25,
        wonBy: null
      },
      {
        id: 7,
        name: "One BILLION Dollars",
        imageUrl:
          "https://images.pexels.com/photos/259027/pexels-photo-259027.jpeg",
        ticketsEntered: 25,
        wonBy: null
      }
    ],
    tiers: [
      {
        id: 1,
        amount: 1.0,
        tickets: 1
      },
      {
        id: 2,
        amount: 5.0,
        tickets: 10
      },
      {
        id: 3,
        amount: 10.0,
        tickets: 25
      }
    ],
    createdAt: "2019-10-11T13:43:53Z",
    updatedAt: "2019-10-11T13:43:53Z"
  };

  // here’s the body for the POST to /raffles/{id}/entry to create a new entry for a raffle…
  // the server will throw a 400 if you try to submit too many total tickets (i.e. you’re only
  // entitled to 30 but you tried to submit a total of >30)
  let postForEntry = {
    user: {
      name: "Scott Evil",
      email: "scott@evil.com"
    },
    donation: {
      amount: 25.5
    },
    entries: [
      {
        prize: {
          id: 1
        },
        tickets: 10
      }
    ]
  };
  return {
    initialPayLoad, 
    postForEntry
  }
}
