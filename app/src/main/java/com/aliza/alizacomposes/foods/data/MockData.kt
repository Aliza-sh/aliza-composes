package com.aliza.alizacomposes.foods.data

import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.foods.model.Food

class MockData {
    companion object {
        private val filterList =
            listOf("\uD83C\uDF57 Chicken", "\uD83C\uDF55 Pizza", "\uD83C\uDF54 Burger")
        fun getFilterList(): List<String> {
            return filterList
        }

        private val foodList = listOf(
            Food(
                "Piper Pizza",
                "Spicy Chicken, Cheese, Olives, Arugula",
                5.99f,
                true,
                R.drawable.pizza
            ),
            Food(
                "Italian Pasta",
                "Spicy Chicken, Cheese, Olives, Arugula",
                5.99f,
                false,
                R.drawable.pasta
            ),
        )
        fun getFoodList(): List<Food> {
            return foodList
        }
    }
}