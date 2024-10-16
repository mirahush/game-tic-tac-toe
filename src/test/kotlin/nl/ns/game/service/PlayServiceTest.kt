package nl.ns.game.service

import nl.ns.game.domain.CirclePlayer
import nl.ns.game.domain.MarkType
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PlayServiceTest {

    @Autowired
    private lateinit var playService: PlayService

    @Autowired
    private lateinit var gameLayoutCreatorService: GameLayoutCreatorService

    @Test
    fun makeAMove() {
        //GIVEN
        val countOfCirclesBeforeMove = gameLayoutCreatorService.getCurrentGameLayout()
            .count { markTypes -> markTypes.any { it == MarkType.CIRCLE } }


        //WHEN
        val player = CirclePlayer()
        playService.makeAMove(player)

        //THEN
        val countOfCirclesAfterMove = gameLayoutCreatorService.getCurrentGameLayout()
            .count { markTypes -> markTypes.any { it == MarkType.CIRCLE } }

        assertThat(countOfCirclesAfterMove - countOfCirclesBeforeMove).isOne()

    }
}