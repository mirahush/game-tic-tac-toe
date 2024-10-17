package nl.ns.game.service

import nl.ns.game.domain.SignType
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class LayoutManagementServiceTest {

    @Autowired
    lateinit var layoutManagementService: LayoutManagementService

    @Test
    fun `game initial layout can be created successfully`() {
        //WHEN
        val gameLayout = layoutManagementService.getCurrentGameLayout()

        //THEN
        assertThat(gameLayout).isNotNull
        assertThat(gameLayout[0]).containsOnly(SignType.EMPTY)
        assertThat(gameLayout[1]).containsOnly(SignType.EMPTY)
        assertThat(gameLayout[2]).containsOnly(SignType.EMPTY)
    }

    @Test
    fun `print game layout successfully`() {
        //WHEN
        val gameLayout = layoutManagementService.printCurrentGameLayout()

        //THEN
        assertThat(gameLayout).isEqualTo("[[\"EMPTY\",\"EMPTY\",\"EMPTY\"],[\"EMPTY\",\"EMPTY\",\"EMPTY\"],[\"EMPTY\",\"EMPTY\",\"EMPTY\"]]")
    }
}