fun removeDuplicates(numbers: IntArray): Int {
    println("RemoveDuplicates before numbers = ${numbers.joinToString(",")}")
    var finalCount: Int = 0
    if(numbers.isNotEmpty()) {
        var slowIndex = 0

        for (fastIndex in 1 .. numbers.size - 1) {
            if(numbers[fastIndex] != numbers[slowIndex]) {
                slowIndex ++
                numbers[slowIndex] = numbers[fastIndex]
            }
        }
        finalCount = slowIndex + 1
    }
    println("RemoveDuplicates after numbers = ${numbers.joinToString(",")}")
    println("RemoveDuplicates finalCount = $finalCount")
    return finalCount
}

fun assertResult(result: Boolean) {
    if(!result) {
        throw Exception("assert fail $result")
    }
}

fun main() {
    val numbers1: IntArray = intArrayOf(0, 0, 1, 1, 1, 2)
    val count1 = removeDuplicates(numbers1)
    assertResult(count1 == 3)

    val numbers2: IntArray = intArrayOf(0, 1, 2, 3, 4, 5)
    val count2 = removeDuplicates(numbers2)
    assertResult(count2 == 6)

    val numbers3: IntArray = intArrayOf(0, 0, 0, 0)
    val count3 = removeDuplicates(numbers3)
    assertResult(count3 == 1)
}