package com.aliza.alizacomposes.wallet.data

import com.aliza.alizacomposes.wallet.model.CardModel
import kotlin.random.Random

object MockData {

    var cardList = ArrayList<CardModel>()
    var months = ArrayList<String>()

    init {
        cardList = arrayListOf(
            CardModel("3584 5478 5687 5522", "25/01", "Alireza shahsavari",2565),
            CardModel("3584 5478 5777 2512", "26/05", "Alireza shahsavari",2648),
            CardModel("3584 5479 5587 5458", "24/03", "Alireza shahsavari",4987),
            CardModel("3584 4155 5587 4545", "02/03", "Alireza shahsavari",4050),
            CardModel("3584 4141 5587 4558", "24/20", "Alireza shahsavari",6666),
        )
        months = arrayListOf(
            "Jan", // January
            "Feb", // February
            "Mar", // March
            "Apr", // April
            "May", // May
            "Jun", // June
            "Jul", // July
            "Aug", // August
            "Sep", // September
            "Oct", // October
            "Nov", // November
            "Dec"  // December
        )
    }
    fun createRandomFloatList(): List<Float> {
        val list = mutableListOf<Float>()
        (0..11).forEach { _ ->
            list.add(Random.nextFloat() * 10)
        }
        return list
    }
}