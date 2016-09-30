package arcanoid

class Game(){
    val gui = GUI(this)
    val ball = Ball(this)

    init {}

    fun start(){
        gui.runThread()
    }
}
