package tinyflutterteam.binary_search


fun findNumber(numbers: IntArray, findNumber: Int): Int {
    var indexOfFindNumber = -1

    //0 1 2 3
    //1 2 5 7

    //0 1 2 3 4
    //1 2 5 7 8
    var indexLeft = 0
    var indexRight = numbers.size - 1
    
    while(indexLeft <= indexRight) {
        var midIndex = (indexLeft + indexRight) / 2
        if(indexLeft == 4 && indexRight == 6) {
            println("indexLeft $indexLeft indexRight $indexRight")
        }
        
        val midValue = numbers[midIndex]
        if(midValue == findNumber) {
            indexOfFindNumber = midIndex
            break
        }
        if(findNumber < midValue) {
            indexRight = midIndex - 1
        } else {
            indexLeft = midIndex + 1
        }
        
    }
    println("FindNumber numbers = ${numbers.joinToString(",")} findNumber = $findNumber")
    println("FindNumber index = $indexOfFindNumber")
    return indexOfFindNumber
}

fun assert(result: Boolean) {
    if(!result) {
        throw Exception("assert fail $result")
    }
}

fun main() {
    val numbers: IntArray = intArrayOf(1, 2, 5, 7 , 8, 9, 10)
    //val numbers: Array<Int> = arrayOf(1, 2, 5, 7 , 8, 9,10)

    val findNumber1 = 9
    val index1 = findNumber(numbers, findNumber1)
    assert(index1 == 5)

    val findNumber2 = 1
    val index2 = findNumber(numbers, findNumber2)
    assert(index2 == 0)

    val findNumber3 = 0
    val index3 = findNumber(numbers, findNumber3)
    assert(index3 == -1)

}