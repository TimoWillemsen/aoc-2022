fun loadFile(filename: String) : String {
    return object {}.javaClass.classLoader.getResource(filename)?.readText() ?: throw IllegalArgumentException("file not found")
}