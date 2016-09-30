package arcanoid

import java.awt.*
import javax.swing.*

class GUI(private val game: Game): JFrame(), Runnable{
    /*
        Class provides visual content of a game
        Take game as parameter to have a connection to it
        Have own thread for drawing
     */
    private val thread = Thread(this)
    private val drawPanel = DrawPanel(game)

    init{
        this.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        this.setSize(800, 600)
        this.add(drawPanel)
        this.isVisible = true
    }

    fun runThread(){
        thread.start()
    }

    fun panelSize() = Pair<Int, Int>(drawPanel.width, drawPanel.height)

    override public fun run(){
        while (true) {
            Thread.sleep(50)
            game.ball.move()
            drawPanel.repaint()
        }
    }

    class DrawPanel(val game: Game): JPanel(){
        override fun paintBorder(g_: Graphics?) {
            val g = (g_ as Graphics2D)
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
            g.color = Color.WHITE
            g.fillRect(0, 0, this.width, this.height)
        }

        override fun paintChildren(g_: Graphics?) {
            val g = (g_ as Graphics2D)
            g.color = Color.RED
            g.fillOval(game.ball.x, game.ball.y, game.ball.d, game.ball.d)
        }

        override fun paintComponent(g_: Graphics?) {
        }
    }
}

