package nl.ns.game.service

import nl.ns.game.domain.Player
import org.springframework.stereotype.Service
import kotlin.random.Random
import kotlin.random.nextInt

@Service
class PlayService(var gameLayoutCreatorService: LayoutManagementService) {

    fun makeAMove(player: Player) {
        do {
            val possibleNexSlot = chooseNextMove()
            val result = gameLayoutCreatorService.tryToSignTheSlot(player.sign, possibleNexSlot)
        } while (!result)

        gameLayoutCreatorService.printCurrentGameLayout()
    }

    //TODO: possible moves should be provided by the layoutService
    private fun chooseNextMove(): Pair<Int, Int> = Pair(Random.nextInt(IntRange(1, 3)), Random.nextInt(IntRange(1, 3)))

}