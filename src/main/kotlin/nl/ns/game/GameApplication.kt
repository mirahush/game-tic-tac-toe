package nl.ns.game

import nl.ns.game.service.GameLayoutCreatorService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GameApplication

fun main(args: Array<String>) {
    runApplication<GameApplication>(*args)
    val gameApplication = GameLayoutCreatorService()
    gameApplication.prepareGameLayout()
}
