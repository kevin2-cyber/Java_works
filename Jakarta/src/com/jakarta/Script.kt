package com.jakarta

import main.jakarta.Dao

class Script(data: Int, money: Int) : Dao(data, money) {
    override fun getData(): Int {
        return super.getData()
    }

    override fun getMoney(): Int {
        return super.getMoney()
    }

    override fun setData(data: Int) {
        super.setData(data)
    }

    override fun setMoney(money: Int) {
        super.setMoney(money)
    }
}