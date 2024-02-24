package model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserLottoTicketTest {
    @Test
    fun `로또의 번호는 6개이다`() {
        assertThrows<IllegalArgumentException> {
            UserLottoTicket(listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber((it)) })
        }
    }

    @Test
    fun `로또 번호는 1 ~ 45 이어야 한다`() {
        assertThrows<IllegalArgumentException> {
            UserLottoTicket(listOf(0, 99, 377, 422, 511, 642).map { LottoNumber((it)) })
        }
    }
}