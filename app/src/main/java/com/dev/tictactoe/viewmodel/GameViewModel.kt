package com.dev.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.tictactoe.model.Board
import com.dev.tictactoe.model.Cell

class GameViewModel: ViewModel() {

    lateinit var board: Board
    lateinit var cells: ObservableArrayMap<String, String>
    var winner = MutableLiveData<String>()
    var noWinner = MutableLiveData<String>()

    fun init(playerOne: String, playerTwo: String){
        board = Board(playerOne, playerTwo)
        cells = ObservableArrayMap()
    }

    fun getWinner(): LiveData<String> = winner
    fun getNoWinner(): LiveData<String> = noWinner

    fun onClickedCellAt(row: Int, column: Int) {
        if (board.cells[row][column].isEmptyCell) {
            board.cells[row][column] = Cell(board.currentPlayer)
            cells[stringFromNumbers(row, column)] = board.currentPlayer.value
        }
    }

    fun updateGameStatus() {
        if(board.isWinnerAvailable())
            winner.postValue(board.currentPlayer.name)

    }
    fun stringFromNumbers(vararg numbers: Int): String {
        val sNumbers = StringBuilder()
        for (number in numbers)
            sNumbers.append(number)
        return sNumbers.toString()
    }
}