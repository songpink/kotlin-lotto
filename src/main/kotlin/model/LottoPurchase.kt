package model

import model.LottoNumber.Companion.MAX_LOTTO_NUMBER
import model.LottoNumber.Companion.MIN_LOTTO_NUMBER

class LottoPurchase(private val purchasePrice: Int) {
    private fun makeUserTicket(): UserLottoTicket {
        return UserLottoTicket(
            (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled().take(6).sorted().map { LottoNumber(it) },
        )
    }

    fun makeUserTickets(): List<UserLottoTicket> {
        val userTickets: MutableList<UserLottoTicket> = mutableListOf()
        repeat(purchasePrice / PRICE_OF_LOTTO_TICKET) {
            userTickets.add(makeUserTicket())
        }
        return userTickets
    }

    companion object {
        const val PRICE_OF_LOTTO_TICKET = 1000
    }
}
