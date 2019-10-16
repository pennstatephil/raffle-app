package com.pennstatephil.raffleapp.service

import com.pennstatephil.raffleapp.dataaccess.model.TierEntity
import com.pennstatephil.raffleapp.dataaccess.repo.TierRepository
import spock.lang.Specification
import spock.lang.Unroll

class RaffleServiceSpec extends Specification {
    TierRepository tierRepository = Mock()
    RaffleService raffleService;

    def setup() {
        raffleService = new RaffleService(null, null, tierRepository, null, null, prizeRepository)
    }

    @Unroll
    def "Ticket calculations are correct"() {
        given: "a raffle with tiers"
        tierRepository.getTiersByRaffleIdOrderByAmountDesc(1) >> [
                TierEntity.builder().amount(BigDecimal.TEN).tickets(25).build(),
                TierEntity.builder().amount(BigDecimal.valueOf(5)).tickets(10).build(),
                TierEntity.builder().amount(BigDecimal.ONE).tickets(1).build()
        ]

        when: "the amount of tickets are calculated"
        def tickets = raffleService.getTicketsByAmount(1, BigDecimal.valueOf(amount))

        then: "the result is correct"
        tickets == expected

        where:
        amount || expected
        0      || 0
        0.99   || 0
        1      || 1
        2      || 2
        5      || 10
        6      || 11
        10     || 25
        11     || 26
        15     || 35
        16     || 36
        20     || 50
        21     || 51
        25     || 60
        26     || 61
    }
}