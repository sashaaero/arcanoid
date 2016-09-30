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
    private val drawPanel = DrawPanel(game.ball)

    init{
        this.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        this.setSize(800, 600)
        this.add(drawPanel)
        this.isVisible = true
        thread.start()
    }

    override public fun run(){
        while (true) {
            Thread.sleep(50)
            game.ball.move()
            drawPanel.repaint()
        }
    }

    class DrawPanel(val ball: Ball): JPanel(){
        override fun paintBorder(g_: Graphics?) {
            val g = (g_ as Graphics2D)
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
            g.color = Color.WHITE
            g.fillRect(0, 0, this.width, this.height)
        }

        override fun paintChildren(g_: Graphics?) {
            val g = (g_ as Graphics2D)
            g.color = Color.RED
            g.fillOval(ball.x, ball.y, ball.d, ball.d)
        }

        override fun paintComponent(g_: Graphics?) {
        }
    }
}

