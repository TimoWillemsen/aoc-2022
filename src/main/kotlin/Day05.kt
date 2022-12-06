import java.time.Instant

fun main() {

    val input = loadFile("day05.txt")
        .split("\n\n")

    val instructions = parseInstructions(input[1])

    instructions.fold(parseInventory(input[0])) { c, instruction ->
        repeat(instruction.amount) {
            c.move(instruction.from, instruction.to, 1)
        }
        c
    }
        .also { println(it.crateStacks.map { it.first() }.joinToString("")) }

    instructions.fold(parseInventory(input[0])) { c, instruction ->
        c.move(instruction.from, instruction.to, instruction.amount)
        c
    }
        .also { println(it.crateStacks.map { it.first() }.joinToString("")) }
}

fun parseInventory(value: String) : Crates{
    return value.readLines().dropLast(1)
        .map { it.chunked(4).mapNotNull { it[1] } }
        .fold(Crates()) {
                crates, characters ->
            characters.forEachIndexed(crates::addItem)
            crates
        }
}

fun parseInstructions(value: String) : List<Instruction> {
    return value
        .readLines()
        .map {
            val line = it.split(' ')
            Instruction(line[3].toInt(), line[5].toInt(), line[1].toInt())
        }
}


data class Instruction(val from : Int, val to : Int, val amount : Int)

class Crates {
    val crateStacks = mutableListOf<MutableList<Char>>()
    init {
        repeat(9) {
            crateStacks.add(mutableListOf())
        }
    }

    fun addItem(stackNumber: Int, value: Char) {
        if (value != ' ') crateStacks[stackNumber].add(value)
    }
    fun move(from: Int, to : Int, amount : Int){
        var firstSlice = crateStacks[from-1].slice(0 until  amount)
        crateStacks[from-1] = crateStacks[from-1].slice(amount until crateStacks[from-1].size).toMutableList()
        crateStacks[to-1].addAll(0, firstSlice)
    }
}
