package nl.ns.game.service

import com.fasterxml.jackson.databind.json.JsonMapper
import nl.ns.game.domain.Grid
import nl.ns.game.domain.MarkType
import org.springframework.stereotype.Service

@Service
class GameLayoutCreatorService() {

    //TODO: Grid should be singleton
    private final var grid: Array<Array<MarkType>>

    private var objectMapper = JsonMapper()

    init {
        this.grid = prepareGameLayout()
    }

    private fun prepareGameLayout(): Array<Array<MarkType>> {
        val grid = Grid()
        return Array(grid.width) { Array(grid.height) { MarkType.EMPTY } }
    }

    fun getCurrentGameLayout(): Array<Array<MarkType>> = grid


    fun printCurrentGameLayout(): String {
        val gameLayout = objectMapper.writeValueAsString(this.getCurrentGameLayout())
        println(gameLayout)
        return gameLayout
    }
}