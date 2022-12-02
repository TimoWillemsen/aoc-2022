fun main() {
    val result = loadFile("day01.txt")
        .split("\n\n")
        .map { it -> it.split("\n").map { it.toInt() } }
        .map { it.sum() }
        .sortedDescending()

    println("First answer: ${result[0]}")
    println("Second answer:  ${result[0] + result[1] + result[2]}")
}