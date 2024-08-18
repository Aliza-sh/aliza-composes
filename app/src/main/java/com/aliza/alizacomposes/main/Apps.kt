package com.aliza.alizacomposes.main

import androidx.activity.ComponentActivity
import com.aliza.alizacomposes.R
import com.aliza.alizacomposes.foods.FoodsActivity
import com.aliza.alizacomposes.income_expenditure.IncAndExpActivity
import com.aliza.alizacomposes.instagram.InstagramActivity
import com.aliza.alizacomposes.movies.MoviesActivity
import com.aliza.alizacomposes.my_os.MyOsActivity
import com.aliza.alizacomposes.shoes.ShoesActivity
import com.aliza.alizacomposes.tourism.TourismActivity
import com.aliza.alizacomposes.vpn.VpnActivity
import com.aliza.alizacomposes.wallet.WalletActivity

sealed class Apps(val imageLight: Int,val imageDark: Int, val activity: ComponentActivity) {
    data object Instagram : Apps(R.drawable.instagram_light,R.drawable.instagram_dark, InstagramActivity())
    data object Tourism : Apps(R.drawable.tourist_light,R.drawable.tourist_dark, TourismActivity())
    data object Wallet : Apps(R.drawable.wallet_light,R.drawable.wallet_dark, WalletActivity())
    data object IncAndExp : Apps(R.drawable.inc_light,R.drawable.inc_dark, IncAndExpActivity())
    data object MyOs : Apps(R.drawable.myos_light,R.drawable.myos_dark, MyOsActivity())
    data object Movies : Apps(R.drawable.movies,R.drawable.movies, MoviesActivity())
    data object Vpn : Apps(R.drawable.vpn,R.drawable.vpn, VpnActivity())
    data object Shoes : Apps(R.drawable.shoes,R.drawable.shoes, ShoesActivity())
    data object Foods : Apps(R.drawable.img_samplebanner,R.drawable.img_samplebanner, FoodsActivity())
}