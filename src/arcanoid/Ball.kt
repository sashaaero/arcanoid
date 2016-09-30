package arcanoid

class Ball(private val game: Game, var x: Int = 50, var y: Int = 50, val d: Int = 50){
    /*
        Class provides an activity of ball
     */
    enum class directions {rightup, leftup, leftdown, rightdown}
    var direction = directions.rightup
    var speed = 5

    fun move(){
        when (direction){
            directions.rightup -> {
                x += speed
                y -= speed
            }
            directions.leftup -> {
                x -= speed
                y -= speed
            }
            directions.leftdown -> {
                x -= speed
                y += speed
            }
            directions.rightdown -> {
                x += speed
                y += speed
            }
        }
    }
}
