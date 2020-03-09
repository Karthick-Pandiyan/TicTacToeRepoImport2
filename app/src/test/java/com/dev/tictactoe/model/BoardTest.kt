package com.dev.tictactoe.model

import org.junit.Assert
import org.junit.Test

class BoardTest {
    private val playerOne = "John"
    private val playerTwo = "Harry"
    private val playerOneValue = Board.PLAYER_ONE_VALUE
    private val playerTwoValue = Board.PLAYER_TWO_VALUE
    private val board = Board(playerOne, playerTwo)
    private val player1 = Player(playerOne, playerOneValue)
    private val player2 = Player(playerTwo, playerTwoValue)

    @Test
    fun `Given function should return expected player, when player one called`(){
        val expectedResult = playerOne

        val actualResult = board.playerOne

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected player, when player two called`(){
        val expectedResult = playerTwo

        val actualResult = board.playerTwo

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, player one is configured`(){
        val expectedResult = player1.name

        val actualResult = board.player1.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, when player two is configured`(){
        val expectedResult = player1.name

        val actualResult = board.player2.name

        Assert.assertNotEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return current player name as player one name, when board starts on first time`(){
        val expectedResult = player1.name

        val actualResult = board.currentPlayer.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return player 2 when switching player, if current player is player 1`(){
        val expectedResult = player2.name

        board.switchPlayer()

        val actualResult = board.currentPlayer.name

        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun `Given function should return expected result, when winner available in board`(){
        val actualResult = board.isWinnerAvailable()

        Assert.assertFalse(actualResult)
    }

    @Test
    fun `Given function should return expected result, when player have same values in horizontal cells`(){

        val cell = Cell(board.player1)
        board.cells[0][0] = cell
        board.cells[0][1] = cell
        board.cells[0][2] = cell
        val actualResult = board.isWinnerAvailable()

        Assert.assertTrue(actualResult)
    }

    @Test
    fun `Given function should return expected result, when player have same values in vertical cells`(){

        val cell = Cell(board.player1)
        board.cells[0][0] = cell
        board.cells[1][0] = cell
        board.cells[2][0] = cell
        val actualResult = board.isWinnerAvailable()

        Assert.assertTrue(actualResult)
    }

    @Test
    fun `Given function should return expected result, if it has three same diagonal cells from Left`() {

        val cell = Cell(board.player1)
        board.cells[0][0] = cell
        board.cells[1][1] = cell
        board.cells[2][2] = cell
        val actualResult = board.isWinnerAvailable()

        Assert.assertTrue(actualResult)
    }

    @Test
    fun `Given function should return expected result, if it has three same Diagonal cells from Right`() {

        val cell = Cell(board.player1)
        board.cells[0][2] = cell
        board.cells[1][1] = cell
        board.cells[2][0] = cell
        val actualResult = board.isWinnerAvailable()

        Assert.assertTrue(actualResult)
    }

    @Test
    fun `Given function should return expected result, when selected a position in board`() {

        val selectedPosition = board.getSelectedPosition(0,0)

        val actualResult = selectedPosition.isEmptyCell

        Assert.assertTrue(actualResult)
    }

    @Test
    fun `Given function should return false when board board is not full`(){
        val actualResult = board.isFull()

        Assert.assertFalse(actualResult)
    }
}