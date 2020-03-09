package com.dev.tictactoe.model

import org.junit.Assert
import org.junit.Test

class BoardTest {
    private val playerOne = "John"
    private val game = Board(playerOne)

    @Test
    fun `Given function should return expected player, when player one called`(){
        val expectedResult = playerOne

        val actualResult = game.playerOne

        Assert.assertEquals(expectedResult, actualResult)
    }
}