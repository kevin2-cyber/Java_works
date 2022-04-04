package com.jakarta

import main.jakarta.Dao

class Script(data: Int, money: Int) : Dao(data, money) {
    override fun getData(): Int {
        return super.getData()
    }

    override fun getMoney(): Int {
        return super.getMoney()
    }
}