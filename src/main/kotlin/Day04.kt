fun main() {
    val input = loadFile("day04.txt")
        .readLines()
        .map {
            row -> row.split(',')
                .map { elf -> elf.split('-').map { digit -> digit.toInt() } }
            .map { it[0] .. it[1]  }
        }

    input
        .count { it[0].subtract(it[1]).isEmpty() || it[1].subtract(it[0]).isEmpty() }
        .also { println(it) }

    input.count{ it[0].subtract(it[1]).count() < it[0].count() || it[1].subtract(it[0]).count() < it[1].count() }
        .also { println(it) }

}

