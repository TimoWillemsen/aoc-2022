fun main() {
    val range = ('a' .. 'z') + ('A' .. 'Z')
    loadFile("day03.txt")
        .readLines()
        .apply {
            map { it.chunked(it.length / 2) }
                .sumOf { range.indexOf((it[0] intersect it[1]).first()) + 1 }
                .also { println(it) }
        }
        .apply {
            chunked(3)
                .sumOf { range.indexOf((it[0] intersect it[1] intersect it[2]).first()) + 1 }
                .also { println(it) }
        }
}

