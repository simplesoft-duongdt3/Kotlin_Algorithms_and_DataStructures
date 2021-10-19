fun findingFirstElementNotSmallerThanTarget(numbers: IntArray, targetNumber: Int): Int {
    var indexOfFindNumber = -1
    
    var leftIndex = 0
    var rightIndex = numbers.size - 1
    while(leftIndex <= rightIndex) {
        val midIndex = (leftIndex + rightIndex) / 2
        if(numbers[midIndex] >= targetNumber) {
            rightIndex = midIndex - 1
            indexOfFindNumber = midIndex
        } else {
            leftIndex = midIndex + 1
        }
    }

    println("FirstElementNotSmallerThanTarget numbers = ${numbers.joinToString(",")} targetNumber = $targetNumber")
    println("FirstElementNotSmallerThanTarget index = $indexOfFindNumber")
    return indexOfFindNumber
}

fun assertResult(result: Boolean) {
    if(!result) {
        throw Exception("assert fail $result")
    }
}

fun main() {
    val numbers: IntArray = intArrayOf(1, 3, 3, 5, 8, 8, 10)

    val findNumber1 = 2
    val index1 = findingFirstElementNotSmallerThanTarget(numbers, findNumber1)
    assertResult(index1 == 1)

    val findNumber2 = 11
    val index2 = findingFirstElementNotSmallerThanTarget(numbers, findNumber2)
    assertResult(index2 == -1)

    val findNumber3 = 5
    val index3 = findingFirstElementNotSmallerThanTarget(numbers, findNumber3)
    assertResult(index3 == 3)
}