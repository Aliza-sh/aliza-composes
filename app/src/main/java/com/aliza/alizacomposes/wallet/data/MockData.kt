package com.aliza.alizacomposes.wallet.data

import com.aliza.alizacomposes.wallet.model.CardModel

object MockData {

    var cardList = ArrayList<CardModel>()

    init {
        cardList = arrayListOf(
            CardModel("3584 5478 5687 5522", "25/01", "Alireza shahsavari",2565),
            CardModel("3584 5478 5777 2512", "26/05", "Alireza shahsavari",2648),
            CardModel("3584 5479 5587 5458", "24/03", "Alireza shahsavari",4987),
            CardModel("3584 4155 5587 4545", "02/03", "Alireza shahsavari",4050),
            CardModel("3584 4141 5587 4558", "24/20", "Alireza shahsavari",6666),
        )
    }
}