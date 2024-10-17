package nl.ns.game.service

import com.fasterxml.jackson.databind.json.JsonMapper
import nl.ns.game.domain.Grid
import nl.ns.game.domain.MarkType
import org.springframework.stereotype.Service

@Service
class LayoutManagementService {

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

    fun tryToUpdateLayout(sign: MarkType, slotAddress: Pair<Int, Int>): Boolean {
        val proposedSlotContent = getCurrentGameLayout()[slotAddress.first][slotAddress.second]
        if (proposedSlotContent != MarkType.EMPTY)
            return false
        else {
            getCurrentGameLayout()[slotAddress.first][slotAddress.second] = sign
            return true
        }
    }
}