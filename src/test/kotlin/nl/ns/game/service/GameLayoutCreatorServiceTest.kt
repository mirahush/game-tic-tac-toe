package nl.ns.game.service

import nl.ns.game.domain.MarkType
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class GameLayoutCreatorServiceTest {

    @Autowired
    lateinit var gameLayoutCreatorService: GameLayoutCreatorService

    @Test
    fun `game initial layout can be created successfully`() {
        //WHEN
        val gameLayout = gameLayoutCreatorService.prepareGameLayout()

        //THEN
        assertThat(gameLayout).isNotNull
        assertThat(gameLayout[0]).containsOnly(MarkType.EMPTY)
        assertThat(gameLayout[1]).containsOnly(MarkType.EMPTY)
        assertThat(gameLayout[2]).containsOnly(MarkType.EMPTY)
    }

    @Test
    fun `print game layout successfully`() {
        //WHEN
        val gameLayout = gameLayoutCreatorService.writeCurrentGameLayout()

        //THEN
        assertThat(gameLayout).isEqualTo("[[\"EMPTY\",\"EMPTY\",\"EMPTY\"],[\"EMPTY\",\"EMPTY\",\"EMPTY\"],[\"EMPTY\",\"EMPTY\",\"EMPTY\"]]")
    }
}