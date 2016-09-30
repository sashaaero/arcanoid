package arcanoid

class Ball(private val game: Game, var x: Int = 50, var y: Int = 50, val d: Int = 50){
    fun move(){
        x++;
        y++;
    }
}
