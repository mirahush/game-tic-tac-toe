package nl.ns.game.domain

class CrossPlayer : Player() {
    override val sign: SignType
        get() = SignType.CROSS
}