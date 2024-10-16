package nl.ns.game.service

import nl.ns.game.domain.Player
import org.springframework.stereotype.Service

@Service
class PlayService(var gameLayoutCreatorService : GameLayoutCreatorService) {

    fun makeAMove(player: Player) {
        var currentLayout = gameLayoutCreatorService.getCurrentGameLayout()
        //should make a change on the game layout
        currentLayout[0][0] = player.playMark
        //var afterMoveGameLayout = gameLayoutCreatorService.getCurrentGameLayout()
        gameLayoutCreatorService.printCurrentGameLayout()
    }
}