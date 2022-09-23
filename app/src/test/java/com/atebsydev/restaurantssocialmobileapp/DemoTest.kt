package com.atebsydev.restaurantssocialmobileapp

import org.junit.Assert
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList


class DemoTest {

    @Test
    fun parseCsv() {
        val csv = ""
        val separator = ","
        val quote = "\""

        val actual:ArrayList<ArrayList<String>> = Demo().parseCsv(csv,separator,quote)

        Assert.assertEquals(listOf(Arrays.asList("'one', 'two wraps\\nonto \"two\" lines', 'three'"),Arrays.asList("'4', '', '6'")), actual)

    }
}