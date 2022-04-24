import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import com.zj.compose.fps.ui.page.particle.particles
import com.zj.compose.fps.ui.page.particle.red
import com.zj.compose.fps.ui.page.particle.toColor
import io.data2viz.color.Colors
import io.data2viz.scale.Scales

@Composable
fun ParticlesCanvas(time: Long, partCount: Int, modifier: Modifier) {
    Canvas(
        modifier = modifier
    ) {
        val xScale = Scales.Continuous.linear {
            domain = listOf(.0, 5.0)
            range = listOf(this@Canvas.size.width / 2.0, this@Canvas.size.width.toDouble())
        }
        val yScale = Scales.Continuous.linear {
            domain = listOf(.0, 5.0)
            range = listOf(this@Canvas.size.height / 2.0, this@Canvas.size.height.toDouble())
        }

        drawIntoCanvas {
            val fake = time //without this line the rendering is not done for all frames

            drawRect(red)
            (0 until partCount).forEach { id ->
                val particle = particles[id]
                val x = xScale(particle.x).toFloat()
                val y = yScale(particle.y).toFloat()
                val color = Colors.Web.aliceblue.toColor()
                drawCircle(
                    color = color,
                    radius = 5f,
                    center = Offset(x, y)
                )
            }
        }
    }
}