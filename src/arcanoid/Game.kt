package arcanoid

class Game(){
    val ball = Ball(this)

    init {}

    fun start(){
        GUI(this)
    }
}
