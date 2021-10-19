fun findMinimumInRotatedSortedArray(numbers: IntArray): Int {
    var indexOfFindNumber = -1

    if(numbers.size == 1) {
        indexOfFindNumber = 0;
    } else {
    
        var leftIndex = 0
        var rightIndex = numbers.size - 1
        val lastValue = numbers[numbers.size - 1]
        while(leftIndex <= rightIndex) {
            val midIndex = (leftIndex + rightIndex) / 2
            if(numbers[midIndex] < lastValue) {
                rightIndex = midIndex - 1
                indexOfFindNumber = midIndex
            } else {
                leftIndex = midIndex + 1
            }
        }
    }

    println("FindMinimumInRotatedSortedArray numbers = ${numbers.joinToString(",")}")
    println("FindMinimumInRotatedSortedArray index = $indexOfFindNumber")
    return indexOfFindNumber
}

fun assertResult(result: Boolean) {
    if(!result) {
        throw Exception("assert fail $result")
    }
}

fun main() {
    val numbers1: IntArray = intArrayOf(30, 40, 50, 10, 20)
    val index1 = findMinimumInRotatedSortedArray(numbers1)
    assertResult(index1 == 3)

    val numbers2: IntArray = intArrayOf(0, 1, 2, 3, 4, 5)
    val index2 = findMinimumInRotatedSortedArray(numbers2)
    assertResult(index2 == 0)

    val numbers3: IntArray = intArrayOf(0)
    val index3 = findMinimumInRotatedSortedArray(numbers3)
    assertResult(index3 == 0)

}