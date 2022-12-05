fun main() {
    loadFile("day01.txt")
        .split("\n\n")
        .map(String::readLinesAsInt)
        .map(List<Int>::sum)
        .sortedDescending()
        .also{ println("First answer ${it.first()}")}
        .also{ println("Second answer answer ${it.take(3).sum()}")}
}