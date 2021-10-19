fun findingTheBoundary(flags: BooleanArray): Int {
    var indexOfFindNumber = -1
    var indexLeft = 0
    var indexRight = flags.size
    while(indexLeft <= indexRight) {
        val indexMid = (indexLeft + indexRight) / 2
        val valueMid = flags[indexMid]
        if(valueMid == false) {
            indexLeft = indexMid + 1
        } else {
            indexRight = indexMid - 1
            indexOfFindNumber = indexMid
        }
    }

    println("FindingTheBoundary flags = ${flags.joinToString(",")}")
    println("FindingTheBoundary index = $indexOfFindNumber")
    return indexOfFindNumber
}

fun assertResult(result: Boolean) {
    if(!result) {
        throw Exception("assert fail $result")
    }
}

fun main() {
    val flags1: BooleanArray = booleanArrayOf(false, false, false, false, true)
    val index1 = findingTheBoundary(flags1)
    assertResult(index1 == 4)

    val flags2: BooleanArray = booleanArrayOf(false, true, true, true)
    val index2 = findingTheBoundary(flags2)
    assertResult(index2 == 1)

    val flags3: BooleanArray = booleanArrayOf(true, true, true, true, true, true , true, true, true )
    val index3 = findingTheBoundary(flags3)
    assertResult(index3 == 0)

}