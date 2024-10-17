package nl.ns.game.service

import nl.ns.game.domain.CirclePlayer
import nl.ns.game.domain.SignType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PlayServiceTest {

    @Autowired
    private lateinit var playService: PlayService

    private var layoutManagementService: LayoutManagementService = mock(LayoutManagementService::class.java)

    @Test
    fun `should be able to find a correct move when there are still empty slots`() {
        //GIVEN
        `when`(layoutManagementService.getCurrentGameLayout())
            .thenReturn(
                arrayOf(
                    arrayOf(SignType.CIRCLE, SignType.CIRCLE, SignType.CIRCLE),
                    arrayOf(SignType.CIRCLE, SignType.CIRCLE, SignType.CIRCLE),
                    arrayOf(SignType.CIRCLE, SignType.CIRCLE, SignType.EMPTY),
                )
            )

        //WHEN
        val player = CirclePlayer()
        playService.makeAMove(player)

        //THEN
        val countOfCirclesAfterMove = layoutManagementService.getCurrentGameLayout()
            .count { markTypes -> markTypes.any { it == SignType.CIRCLE } }

        assertThat(countOfCirclesAfterMove - countOfCirclesBeforeMove).isOne()
    }

    @Test
    fun `should fill the slot with the player sign`() {
        //GIVEN
        val countOfCirclesBeforeMove = layoutManagementService.getCurrentGameLayout()
            .count { markTypes -> markTypes.any { it == SignType.CIRCLE } }


        //WHEN
        val player = CirclePlayer()
        playService.makeAMove(player)

        //THEN
        val countOfCirclesAfterMove = layoutManagementService.getCurrentGameLayout()
            .count { markTypes -> markTypes.any { it == SignType.CIRCLE } }

        assertThat(countOfCirclesAfterMove - countOfCirclesBeforeMove).isOne()

    }

    @Test
    fun `should not override already signed slot`() {
        //GIVEN
        val countOfCirclesBeforeMove = layoutManagementService.getCurrentGameLayout()
            .count { markTypes -> markTypes.any { it == SignType.CIRCLE } }


        //WHEN
        val player = CirclePlayer()
        playService.makeAMove(player)

        //THEN
        val countOfCirclesAfterMove = layoutManagementService.getCurrentGameLayout()
            .count { markTypes -> markTypes.any { it == SignType.CIRCLE } }

        assertThat(countOfCirclesAfterMove - countOfCirclesBeforeMove).isOne()

    }
}