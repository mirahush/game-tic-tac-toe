package nl.ns.game.domain

class CirclePlayer : Player() {
    override val sign: SignType
        get() = SignType.CIRCLE
}