package com.trippify.tripiffy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.trippify.tripiffy.model.Trip
import kotlinx.android.synthetic.main.activity_trip_details.*

class TripDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_details)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val trip = intent.getSerializableExtra("trip") as Trip

        tripMainImage.setImageBitmap(trip.getImage())
        tripTitle.text = trip.title
        tripLongDescription.text = trip.description
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
