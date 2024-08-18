package com.aliza.alizacomposes.foods.data

class MockData {
    companion object {
        private val filterList =
            listOf("\uD83C\uDF57 Chicken", "\uD83C\uDF55 Pizza", "\uD83C\uDF54 Burger")
        fun getFilterList(): List<String> {
            return filterList
        }
    }
}