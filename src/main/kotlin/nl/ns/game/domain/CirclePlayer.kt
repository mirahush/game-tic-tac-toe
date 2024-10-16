package nl.ns.game.domain

class CirclePlayer : Player() {
    override val playMark: MarkType
        get() = MarkType.CIRCLE
}