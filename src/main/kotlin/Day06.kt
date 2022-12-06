fun main() {
    fun String.findMarker(markerSize: Int) = this
        .windowed(markerSize, 1)
        .map { it.toList().distinct().size }
        .also { println(it.indexOf(markerSize) + markerSize) }

    loadFile("day06.txt")
        .apply { findMarker(4) }
        .apply { findMarker(14) }
}