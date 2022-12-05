fun main() {
    val resultCache = mapOf(
        "A X" to (4 to 3),
        "A Y" to (8 to 4),
        "A Z" to (3 to 8),
        "B X" to (1 to 1),
        "B Y" to (5 to 5),
        "B Z" to (9 to 9),
        "C X" to (7 to 2),
        "C Y" to (2 to 6),
        "C Z" to (6 to 7)
    )
    loadFile("day02.txt")
        .readLines()
        .map(resultCache::getValue)
        .reduce { acc, i -> acc.first + i.first to acc.second + i.second }
        .also { println(it.first) }
        .also { println(it.second) }
}

