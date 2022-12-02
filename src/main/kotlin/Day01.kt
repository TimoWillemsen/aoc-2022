fun main() {
    loadFile("day01.txt")
        .split("\n\n")
        .map(String::readLinesAsInt)
        .map(List<Int>::sum)
        .sortedDescending()
        .also{ println("First answer ${it[0]}")}
        .also{ println("Second answer answer ${it[0] + it[1] + it[2]}")}
}