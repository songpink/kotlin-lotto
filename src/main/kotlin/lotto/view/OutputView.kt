package lotto.view

import lotto.model.Rank
import lotto.model.Rank.FIFTH
import lotto.model.Rank.FIRST
import lotto.model.Rank.FOURTH
import lotto.model.Rank.SECOND
import lotto.model.Rank.THIRD
import lotto.model.UserLottoTicket

class OutputView {
    fun printLottoCount(lottoCount: Int) {
        println(PURCHASE_MESSAGE.format(lottoCount))
    }

    fun printLottoTickets(userLottoTickets: List<UserLottoTicket>) {
        val lottoTicketsInt = userLottoTickets.map { it.userLottoTicket.map { it.number } }
        lottoTicketsInt.forEach {
            println(it)
        }
    }

    fun printWinningChart(rankMap: Map<Rank, Int>) {
        for (rank in listOf(FIFTH, FOURTH, THIRD, SECOND, FIRST)) {
            println(
                MATCH_MESSAGE.format(
                    rank.countOfMatch,
                    if (rank == Rank.bonusNeededRank) ", 보너스 볼 일치" else "",
                    rank.winningMoney,
                    rankMap[rank],
                ),
            )
        }
    }

    fun printWinningRate(winningRate: Float) {
        println(TOTAL_WINNING_RATE_MESSAGE.format(winningRate))
    }

    companion object {
        private const val PURCHASE_MESSAGE = "%d개를 구매했습니다."
        private const val MATCH_MESSAGE = "%d개 일치%s (%d원) - %d개"
        private const val TOTAL_WINNING_RATE_MESSAGE = "총 수익률은 %.2f입니다."
    }
}
