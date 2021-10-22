import java.util.Queue
import java.util.LinkedList

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
    val sizeBoard = 5
    val maxIndex = sizeBoard - 1
    showBoard(board2, "Board", sizeBoard)

    for (row in 0..maxIndex) {
        markWinCellsAtRow(board2, row, board2Copy, sizeBoard)
    }

    for (col in 0..maxIndex) {
        markWinCellsAtCol(board2, col, board2Copy, sizeBoard)
    }

    showBoard(board2Copy, "Board after clear win cells", sizeBoard)

    for (col in 0..maxIndex) {
        rearrangeColAfterWin(board2Copy, col, sizeBoard)
    }

    showBoard(board2Copy, "Board after rearrange", sizeBoard)
    
}


fun rearrangeColAfterWin(boardResult: Array<IntArray>, colIndex: Int, sizeBoard: Int,) {
    var climbToTopIndex: Int = sizeBoard - 1
    val zeroQueue: Queue<Int> = LinkedList<Int>()
    
    do {
        val top = boardResult[climbToTopIndex][colIndex]
        if(top == 0) {
            zeroQueue.add(climbToTopIndex)
        } else {
            val zeroBottomIndex = zeroQueue.poll()
            if(zeroBottomIndex != null) {
                boardResult[zeroBottomIndex][colIndex] = top
                boardResult[climbToTopIndex][colIndex] = 0
                zeroQueue.add(climbToTopIndex)
            }
        }
        climbToTopIndex --
    } while(climbToTopIndex >= 0)
}

fun markWinCellsAtCol(board: Array<IntArray>, colIndex: Int, boardResult: Array<IntArray>, sizeBoard: Int,) {
    val maxIndex = sizeBoard - 1
    var topIndex: Int = 0
    var bottomIndex: Int = 1
    
    while(bottomIndex < maxIndex) {
        bottomIndex ++

        val startIndex = topIndex
        var endIndex = bottomIndex
        var isEndChainSame = false
        if(board[topIndex][colIndex] != board[bottomIndex][colIndex]) {
            topIndex = bottomIndex
            isEndChainSame = true
            endIndex--
        } else if(bottomIndex >= maxIndex) {
            isEndChainSame = true
        }

        val distanceSame = endIndex - startIndex + 1

        if(distanceSame >= 3 && isEndChainSame) {
            for (i in startIndex..endIndex) {
                boardResult[i][colIndex] = 0
            }
        }

        
    }
}

fun markWinCellsAtRow(
    board: Array<IntArray>, 
    rowIndex: Int, 
    boardResult: Array<IntArray>, 
    sizeBoard: Int,
    ) {
    val maxIndex = sizeBoard - 1
    var leftIndex: Int = 0
    var rightIndex: Int = 0
    
    while(rightIndex < maxIndex) {
        rightIndex ++
        val startIndex = leftIndex
        var endIndex = rightIndex
        var isEndChainSame = false

        if(board[rowIndex][leftIndex] != board[rowIndex][rightIndex]) {
            leftIndex = rightIndex
            isEndChainSame = true
            endIndex--
        } else if(rightIndex >= maxIndex) {
            isEndChainSame = true
        }

        val distanceSame = endIndex - startIndex + 1

        if(distanceSame >= 3 && isEndChainSame) {
            for (i in startIndex..endIndex) {
                boardResult[rowIndex][i] = 0
            }
        }        
    }
}

fun showBoard(board: Array<IntArray>, boardName: String, boardSize: Int) {
    println("$boardName")
    for (row in 0..boardSize-1) {
        for (col in 0..boardSize-1) {
            val cell = board[row][col]
            print("$cell  ")
        }
        print("\n")
    }
}