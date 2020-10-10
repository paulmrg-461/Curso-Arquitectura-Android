package com.anncode.offersandcoupons.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.ApiAdapter
import com.anncode.offersandcoupons.presenter.CouponsPresenter
import com.anncode.offersandcoupons.presenter.CouponsPresenterImpl
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity(), CouponView {

    private var couponPresenter: CouponsPresenter? = null
    private var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponPresenter = CouponsPresenterImpl(this)

        rvCoupons = findViewById(R.id.rvCoupons) //UI
        rvCoupons?.layoutManager = LinearLayoutManager(this)
        getCoupons()
    }

    override fun showCoupons(coupons: ArrayList<Coupon>?) {
        try {
            rvCoupons!!.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
        } catch (e: Exception){
            e.printStackTrace()
        }

    }

    override fun getCoupons() {

        couponPresenter?.getCoupons()
    }
}
