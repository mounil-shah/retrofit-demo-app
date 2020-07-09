package com.example.retrofitdemoapp

import org.junit.Test

class UserDetailsFragmentTest {
    //high order function
    @Test
    fun `high order function test`() {
        myLet(::mySimpleFunction)
        myLet({ println("Hello Universe") })
        myLet() { println("Hello Universe") }
        myLet { println("Hello Universe") }
    }

    fun myLet(blockOfCode: () -> Unit) {
//        blockOfCode.invoke()
        blockOfCode()
    }

    //fun mySimpleFunction(): Unit
    //mySimpleFunction(): Unit
    //(): Unit
    //() -> Unit

    fun mySimpleFunction(): Unit {
        println("Hello World")
    }

    @Test
    fun `high order function with parameter`() {
        myHighOrderFunction2(::myParameterFunction)
        myHighOrderFunction2 {
            println("You Entered $it")
        }
    }

//    fun myParameterFunction(num: Int): Unit
    //myParameterFunction(num: Int): Unit
    //(num: Int): Unit
    //(num: Int) -> Unit
    //(Int) -> Unit

    fun myParameterFunction(num: Int): Unit {
        val double = num * 2
        println("You Entered Half of $double")
    }

    fun myHighOrderFunction2(blockOfCode: (Int) -> Unit){
        blockOfCode(8)
    }

    //fun myReturningFunction(): Int
    //myReturningFunction(): Int
    //(): Int
    //() -> Int

    fun myHighOrderFunction3(blockOfCode: () -> Int){
        val myReturnValue = blockOfCode()
        println(myReturnValue)
    }

    @Test
    fun test(){
        myHighOrderFunction3 { 6 }
    }
}