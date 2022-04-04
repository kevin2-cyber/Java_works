package com.jakarta

import main.jakarta.Main

open class Script : Main() {
    override fun printData(data: String?) {
        super.printData("Hello")
    }
}