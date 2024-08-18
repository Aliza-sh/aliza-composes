package com.aliza.alizacomposes.foods.data

import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.foods.model.Chat
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

        private val chatList = listOf (
            Chat("Hossein", "bye"),
            Chat("Ali", "bye for now"),
            Chat("Ali", "of course"),
            Chat("Hossein", "Can we talk later"),
            Chat("Hossein", "I'm too busy"),
            Chat("Hossein", "Hi"),
            Chat("Ali", "Whuzzzzzup?"),
            Chat("Ali", "Hi")
        )

        fun getChatList(): List<Chat> {
            return chatList
        }
    }
}