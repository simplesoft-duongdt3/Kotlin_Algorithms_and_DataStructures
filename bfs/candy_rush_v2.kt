import java.util.Queue
import java.util.LinkedList

fun main() {
    val board2: Array<IntArray> = arrayOf(
        intArrayOf(4, 4, 4, 1, 1),
        intArrayOf(5, 4, 1, 5, 4),
        intArrayOf(1, 4, 3, 3, 3),
        intArrayOf(1, 5, 3, 3, 5),
        intArrayOf(1, 2, 3, 3, 4)
    )

    val sizeBoard = 5
    val maxIndex = sizeBoard - 1
    showBoardV2(board2, "Board", sizeBoard)

    for (row in 0..maxIndex) {
        markWinCellsAtRowV2(board2, row, sizeBoard)
    }

    for (col in 0..maxIndex) {
        markWinCellsAtColV2(board2, col, sizeBoard)
    }

    showBoardV2(board2, "Board after clear win cells", sizeBoard)

    for (col in 0..maxIndex) {
        rearrangeColAfterWinV2(board2, col, sizeBoard)
    }

    showBoardV2(board2, "Board after rearrange", sizeBoard)
    
}


fun rearrangeColAfterWinV2(boardResult: Array<IntArray>, colIndex: Int, sizeBoard: Int,) {
    var climbToTopIndex: Int = sizeBoard - 1
    val zeroQueue: Queue<Int> = LinkedList<Int>()
    
    do {
        val top = boardResult[climbToTopIndex][colIndex]
        if(top <= 0) {
            boardResult[climbToTopIndex][colIndex] = 0
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

fun markWinCellsAtColV2(board: Array<IntArray>, colIndex: Int, sizeBoard: Int,) {
    val maxIndex = sizeBoard - 1
    var index: Int = 0
    
    do {
        val valueCell = Math.abs(board[index][colIndex])
        val valueCellNext1 = Math.abs(board[index + 1][colIndex])
        val valueCellNext2 = Math.abs(board[index + 2][colIndex])
        if(valueCell > 0 && valueCell == valueCellNext1 && valueCell == valueCellNext2) {
            board[index][colIndex] = - 1 * valueCell
            board[index + 1][colIndex] = - 1 * valueCell
            board[index + 2][colIndex] = - 1 * valueCell
        }      
        index ++
    } while(index < maxIndex - 1)
}

fun markWinCellsAtRowV2(
    board: Array<IntArray>, 
    rowIndex: Int, 
    sizeBoard: Int,
    ) {
    val maxIndex = sizeBoard - 1
    var index: Int = 0
    
    do {
        val valueCell = Math.abs(board[rowIndex][index])
        val valueCellNext1 = Math.abs(board[rowIndex][index + 1])
        val valueCellNext2 = Math.abs(board[rowIndex][index + 2])
        if(valueCell > 0 && valueCell == valueCellNext1 && valueCell == valueCellNext2) {
            board[rowIndex][index] = - 1 * valueCell
            board[rowIndex][index + 1] = - 1 * valueCell
            board[rowIndex][index + 2] = - 1 * valueCell
        }      
        index ++
    } while(index < maxIndex - 1)
}

fun showBoardV2(board: Array<IntArray>, boardName: String, boardSize: Int) {
    println("$boardName")
    for (row in 0..boardSize-1) {
        for (col in 0..boardSize-1) {
            val cell = board[row][col]
            print("$cell  ")
        }
        print("\n")
    }
}