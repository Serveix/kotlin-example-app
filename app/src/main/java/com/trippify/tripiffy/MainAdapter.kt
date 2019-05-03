package com.trippify.tripiffy

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trippify.tripiffy.model.Trip
import kotlinx.android.synthetic.main.row_main.view.*

class MainAdapter: RecyclerView.Adapter<CustomViewHolder>() {
    private val trips = listOf(
        Trip(
            "Cancun",
            "Diviertete en la playa mas famosa de Mexico",
            "https://media-server.clubmed.com/image/jpeg/1200/675/crop/center/60/https%3A%2F%2Fns.clubmed.com%2Fdream%2FRESORTS_3T___4T%2FCaraibes_et_Cotes_Americaines%2FCancun_Yucatan%2F13594-k3b93t78hm-swhr.jpg",
            "Fiesta",
            "Playa"
        ),
        Trip(
            "Puerto Vallarta",
            "Famosa por su espectacular playa, ven y ten unas vacaciones inolvidables",
            "https://www.garzablancaresort.com.mx/blog/wp-content/uploads/2015/12/the-best-beaches-in-puerto-vallarta-e1506119214708.jpg",
            "Fiesta",
            "Playa"
        ),
        Trip(
            "Mazatlan",
            "Ambiente familiar y de fiesta. Increibles caminatas nocturnas.",
            "https://themazatlanpost.com/wp-content/uploads/2018/05/malecon-mazatlan-1-1070x600.jpg",
            "Fiesta, familiar",
            "Playa"
        )
    )

    override fun getItemCount(): Int {
        return trips.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow  = layoutInflater.inflate(R.layout.row_main, parent, false)

        return CustomViewHolder(cellForRow)
    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) = holder.bind(trips[position])

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    fun bind(trip: Trip) = with(itemView) {

        picTitle.text = trip.title
        tripMainImage.setImageBitmap(trip.getImage())
        picDesc.text = trip.description
        setOnClickListener {
            val intent = Intent(this.context, TripDetailsActivity::class.java)
            val activity =  this.context as Activity
            intent.putExtra("trip", trip)
            this.context.startActivity(intent)
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}