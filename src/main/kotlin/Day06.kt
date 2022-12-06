import java.time.Instant

fun main() {

    loadFile("day06.txt")
        .windowed(14, 1)
        .map { it.toList().distinct().size }
        .also { println(it.indexOf(14) + 14) }

    loadFile("day06.txt")
        .windowed(4, 1)
        .map { it.toList().distinct().size }
        .also { println(it.indexOf(4) +4) }
}