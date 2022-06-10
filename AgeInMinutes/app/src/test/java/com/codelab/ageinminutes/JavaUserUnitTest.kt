package com.codelab.ageinminutes


import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test

class JavaUserUnitTest {

    private val first = "Alice"
    private val last = "Simmons"
    private val user = JavaUser(first, last)
    private val userSame = JavaUser(first, last)
    private val userDifferent = JavaUser("Alex", "Smith")

    @Test
    fun readProperties() {
        assertEquals(first, user.first)
        assertEquals(last, user.last)
    }

    @Test
    fun writeProperties() {
        user.first = "Alex"
        user.last = "Smith"

        assertNotEquals(first, user.first)
        assertNotEquals(last, user.last)
    }

    @Test
    fun checkHashCode() {
        assertNotEquals(user.hashCode(), userDifferent.hashCode())
    }

    @Test
    fun checkEquals() {
        assert(user == userSame)
    }

    @Test
    fun checkNotEquals() {
        assert(user != userDifferent)
    }

}