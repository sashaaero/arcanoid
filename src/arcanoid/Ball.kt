package arcanoid

class Ball(private val game: Game){
    /*
        Class provides an activity of ball
     */
    val d = 10
    var x = 400
    var y = 250
    val width = game.gui.panelSize().first
    val height = game.gui.panelSize().second
    enum class directions {rightup, leftup, leftdown, rightdown}
    var direction = directions.rightup
    var speed = 10

    fun move(){
        when (direction){
            directions.rightup -> {
                x += speed
                y -= speed
                if (x + (d / 2) >= width) direction = directions.leftup
                if (y - (d / 2) <= 0) direction = directions.rightdown
            }
            directions.leftup -> {
                x -= speed
                y -= speed
                if (y - (d / 2) <= 0) direction = directions.leftdown
                if (x - (d / 2) <= 0) direction = directions.rightup
            }
            directions.leftdown -> {
                x -= speed
                y += speed
                if (x - (d / 2) <= 0) direction = directions.rightdown
                if (y + (d / 2) >= height) direction = directions.leftup
            }
            directions.rightdown -> {
                x += speed
                y += speed
                if (x + (d / 2) >= width) direction = directions.leftdown
                if (y + (d / 2) >= height) direction = directions.rightup
            }
        }
    }
}
