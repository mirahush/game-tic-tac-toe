package nl.ns.game.service

import com.fasterxml.jackson.databind.json.JsonMapper
import nl.ns.game.domain.Grid
import nl.ns.game.domain.MarkType
import org.springframework.stereotype.Service

@Service
class GameLayoutCreatorService {

    //TODO: Grid should be singleton
    private var grid = prepareGameLayout()

    private var objectMapper =  JsonMapper()

    fun prepareGameLayout(): Array<Array<MarkType>> {
        val grid = Grid()
        return Array(grid.width) { Array(grid.height) { MarkType.EMPTY } }
    }

    fun writeCurrentGameLayout(): String {
        return objectMapper.writeValueAsString(grid)
    }

    fun printCurrentGameLayout() {
        return print(objectMapper.writeValueAsString(grid))
    }
}