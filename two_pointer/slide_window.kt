fun slideWindow(numbers: IntArray, windowSide: Int): List<Int> {
    var result = mutableListOf<Int>()
    var maxNumbers = mutableListOf<Int>()
    for (i in 0..numbers.size-1) {
        val number = numbers[i]
        if(!maxNumbers.isEmpty()) {
            maxNumbers.removeAll({ index ->  
                numbers[index] < number || (i + 1 - index ) > windowSide
            })
            println("if numbers = ${maxNumbers.joinToString(",")}")
        }

        maxNumbers.add(i)
        if(i + 1 >= windowSide) {
            result.add(numbers[maxNumbers[0]])
        }
        println("end for numbers = ${maxNumbers.joinToString(",")}")
    }
    

    println("FirstElementNotSmallerThanTarget numbers = ${numbers.joinToString(",")} windowSide = $windowSide")
    println("FirstElementNotSmallerThanTarget result = ${result.joinToString(",")}")
    return result
}

fun assertResult(result: Boolean) {
    if(!result) {
        throw Exception("assert fail $result")
    }
}

fun main() {
    val numbers1: IntArray = intArrayOf(1, 3, 2, 5, 8, 7)
    val windowSide1 = 3
    val index1 = slideWindow(numbers1, windowSide1)
    //assertResult(index1 == 3588)
}