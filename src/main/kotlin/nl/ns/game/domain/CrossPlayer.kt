package nl.ns.game.domain

class CrossPlayer : Player() {
    override val playMark: MarkType
        get() = MarkType.CROSS
}