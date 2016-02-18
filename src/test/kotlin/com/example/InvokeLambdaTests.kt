package com.example

import org.junit.Test
import java.util.function.Supplier

class InvokeLambdaTests {

    @Test
    fun foo() {
        assert(Supplier { true }.get())
    }

    // This simple unit test works
    @Test
    fun invokeLambda() {
        assert(Supplier::class.java.getMethod("get").invoke(Supplier<Boolean> { true }) as Boolean)
    }

}


