fun loadFile(filename: String) : String {
    return object {}.javaClass.classLoader.getResource(filename)?.readText() ?: throw IllegalArgumentException("file not found")
}

fun String.readLines() : List<String> {
    return this.split("\n")
}

fun String.readLinesAsInt() : List<Int> {
    return this.readLines()
        .map(String::toInt)
}