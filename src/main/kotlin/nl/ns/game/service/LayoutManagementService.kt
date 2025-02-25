package nl.ns.game.service

import com.fasterxml.jackson.databind.json.JsonMapper
import nl.ns.game.domain.Grid
import nl.ns.game.domain.SignType
import org.springframework.stereotype.Service

@Service
class LayoutManagementService {

    private final var grid: Array<Array<SignType>>

    private var objectMapper = JsonMapper()

    init {
        this.grid = prepareGameLayout()
    }

    private fun prepareGameLayout(): Array<Array<SignType>> {
        val grid = Grid()
        return Array(grid.width) { Array(grid.height) { SignType.EMPTY } }
    }

    fun getCurrentGameLayout(): Array<Array<SignType>> = grid


    fun printCurrentGameLayout(): String {
        val gameLayout = objectMapper.writeValueAsString(this.getCurrentGameLayout())
        println(gameLayout)
        return gameLayout
    }

    fun tryToSignTheSlot(sign: SignType, slotAddress: Pair<Int, Int>): Boolean {
        val proposedSlotContent = getCurrentGameLayout()[slotAddress.first][slotAddress.second]
        if (proposedSlotContent != SignType.EMPTY)
            return false
        else {
            getCurrentGameLayout()[slotAddress.first][slotAddress.second] = sign
            return true
        }
    }
}