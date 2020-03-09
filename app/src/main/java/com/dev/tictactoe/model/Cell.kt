package com.dev.tictactoe.model

class Cell(var player: Player?){

    val isEmptyCell = player == null || player?.value.isNullOrEmpty()

    fun hasCellValuesAreEqual(vararg cells: Cell): Boolean {
        if (cells.isEmpty()) return false
        return true
    }
}