fun main() {
    
    val board1: Array<IntArray> = arrayOf(
        intArrayOf(4, 4, 5, 1, 1),
        intArrayOf(5, 3, 1, 5, 4),
        intArrayOf(3, 1, 4, 5, 3),
        intArrayOf(1, 5, 3, 3, 5),
        intArrayOf(1, 2, 3, 3, 4)
    )

    val board2: Array<IntArray> = arrayOf(
        intArrayOf(4, 4, 4, 1, 1),
        intArrayOf(5, 4, 1, 5, 4),
        intArrayOf(1, 4, 3, 3, 3),
        intArrayOf(1, 5, 3, 3, 5),
        intArrayOf(1, 2, 3, 3, 4)
    )

    val board2Copy: Array<IntArray> = arrayOf(
        intArrayOf(4, 4, 4, 1, 1),
        intArrayOf(5, 4, 1, 5, 4),
        intArrayOf(1, 4, 3, 3, 3),
        intArrayOf(1, 5, 3, 3, 5),
        intArrayOf(1, 2, 3, 3, 4)
    )
    
    showBoard(board2, "Board")

    for (row in 0..4) {
        var leftIndex: Int = 0
        var rightIndex: Int = 1
        
        do {
            
            val startIndex = leftIndex
            var endIndex = rightIndex
            var isEndChainSame = false
            if(board2[row][leftIndex] != board2[row][rightIndex]) {
                leftIndex = rightIndex
                isEndChainSame = true
                endIndex--
            } else if(rightIndex >= 4) {
                isEndChainSame = true
            }

            val distanceSame = endIndex - startIndex + 1

            if(distanceSame >= 3 && isEndChainSame) {
                for (i in startIndex..endIndex) {
                    board2Copy[row][i] = 0
                }
            }

            rightIndex ++
        } while(rightIndex < 5)
    }

    for (col in 0..4) {
        var topIndex: Int = 0
        var bottomIndex: Int = 1
        
        do {
            
            val startIndex = topIndex
            var endIndex = bottomIndex
            var isEndChainSame = false
            if(board2[topIndex][col] != board2[bottomIndex][col]) {
                topIndex = bottomIndex
                isEndChainSame = true
                endIndex--
            } else if(bottomIndex >= 4) {
                isEndChainSame = true
            }

            val distanceSame = endIndex - startIndex + 1

            if(distanceSame >= 3 && isEndChainSame) {
                for (i in startIndex..endIndex) {
                    board2Copy[i][col] = 0
                }
            }

            bottomIndex ++
        } while(bottomIndex < 5)
    }

    showBoard(board2Copy, "Board after clear win cells")
}

fun showBoard(board: Array<IntArray>, boardName: String) {
    println("$boardName")
    for (row in 0..4) {
        for (col in 0..4) {
            val cell = board[row][col]
            print("$cell  ")
        }
        print("\n")
    }
}