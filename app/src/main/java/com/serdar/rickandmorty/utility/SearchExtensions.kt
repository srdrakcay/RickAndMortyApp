package com.serdar.rickandmorty.utility

fun String.addSearchPrefix(prefix:String):String{
    return prefix.plus(this)
}

fun Int.addSearchPrefix(prefix:Int):Int{
    return prefix.plus(this)
}


infix fun String.okWith(bound: Int) = length > bound