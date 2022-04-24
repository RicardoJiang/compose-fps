
/**
 * A particle with a 2D position that will move randomly beetween approximatively -5,-5 and +5,+5
 */
class RandomParticle {

    var x = .0
    var y = .0

    var vx = .0
    var vy = .0

    fun updatePositionAndSpeed() {
        x += vx
        y += vy
        vx += .04 * (Math.random() - .5) - .05 * vx - .0005 * x
        vy += .04 * (Math.random() - .5) - .05 * vy - .0005 * y
    }
}