
fun main() {
    val lines = loadFile("day07.txt")
        .readLines()

    val node = processLines(lines.toMutableList(), Node(true, "", null))
    val diskSpace = 70000000
    val contentSize = node.size()
    val needed = 30000000
    val available = diskSpace - contentSize
    diff = needed-available
    println(diff)
    traverse(node)
    println(total)
    println(smallestDelete)
}
var diff = 0
var smallestDelete = Int.MAX_VALUE

fun traverse(node: Node){
    println("In directory ${node.name} - size: ${node.size()}")
    if(node.size() < 100000) total += node.size()
    if(node.size() > diff ){
        //Is large enough to be deleted
        if(node.size() < smallestDelete){
            smallestDelete = node.size()
        }
    }
    if(node.children.isEmpty()){
        return
    }else{
        node.children.filter { it.isDir }.forEach{traverse(it)}
    }
}

fun processLines(lines: MutableList<String>, node : Node) : Node{

    do {
        val line = lines.removeAt(0)
        when {
            line.startsWith("$ cd ..") -> { return node }
            line.startsWith("$ cd") -> {
                val subNode = processLines(lines, Node(true, line.removePrefix("$ cd "), null))
                node.add(subNode)
            }
            line.startsWith("$ ls") -> { }
            line.startsWith("dir") -> { }
            else -> {
                val file = line.split(' ')
                node.add(Node(false, file[1], file[0].toInt()))
            }

        }
    }while (lines.isNotEmpty())

    return node
}
var total = 0

class Node(val isDir: Boolean, val name : String, val size : Int?){
    val children: MutableList<Node> = mutableListOf()
    fun add(node: Node){
        children.add(node)
    }
    fun size() : Int {
        if(!this.isDir) return this.size!!
        return children.sumOf { it.size() }
    }
}