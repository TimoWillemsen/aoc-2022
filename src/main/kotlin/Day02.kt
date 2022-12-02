fun main() {
    val resultCache = mapOf(
        "A X" to (4 to 3),
        "B X" to (1 to 1),
        "C X" to (7 to 2),
        "C Y" to (2 to 6),
        "A Y" to (8 to 4),
        "B Y" to (5 to 5),
        "B Z" to (9 to 9),
        "A Z" to (3 to 8),
        "C Z" to (6 to 7)
    )
    loadFile("day02.txt")
        .split("\n")
        .map { resultCache.getValue(it) }
        .also { println(it.sumOf { r -> r.first }) }
        .also { println(it.sumOf { r -> r.second }) }
}