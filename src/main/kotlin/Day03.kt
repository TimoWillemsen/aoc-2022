fun main() {
    val range = ('a'..'z') + ('A'..'Z')
    val input = loadFile("day03.txt")
        .readLines()
    input
        .map { it.chunked(it.length / 2) }
        .sumOf { range.indexOf((it[0] intersect it[1]).first()) + 1 }
        .also { println(it) }
    input
        .chunked(3)
        .sumOf { range.indexOf((it[0] intersect it[1] intersect it[2]).first()) + 1 }
        .also { println(it) }

}

