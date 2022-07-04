package com.enuygun.casestudy.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enuygun.casestudy.Extensions.getProgressDrawable
import com.enuygun.casestudy.Extensions.loadImage
import com.enuygun.casestudy.databinding.RowFlightPlansBinding
import com.enuygun.casestudy.model.enuygun.Airlines
import com.enuygun.casestudy.model.enuygun.Departure
import com.enuygun.casestudy.model.enuygun.Segments

class FlightsListAdapter(
    private var airlines: ArrayList<Airlines>,
    private var flights: ArrayList<Departure>
) :
    RecyclerView.Adapter<FlightsListAdapter.FlightViewHolder>() {

    private lateinit var binding: RowFlightPlansBinding

    fun updateFlight(_airlines: List<Airlines>?, _flights: List<Departure>?) {
        airlines.clear()
        flights.clear()
        _airlines?.let { airlines.addAll(it) }
        _flights?.let { flights.addAll(it) }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val binding =
            RowFlightPlansBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return FlightViewHolder(binding)
    }


    override fun getItemCount() = airlines.size

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bind(airlines[position], flights[position], flights[position].segments[0])
    }

    class FlightViewHolder(val binding: RowFlightPlansBinding) :
        RecyclerView.ViewHolder(binding.root) {


        private val progressDrawable = getProgressDrawable(context = binding.viewView.context)

        fun bind(airlines: Airlines, flights: Departure, _segments: Segments) {
            with(binding) {
                airBrandName.text = airlines.name
                originName.text = _segments.origin
                destinationName.text = _segments.destination
                arrivalTime.text = _segments.arrivalDatetime?.time
                departureTime.text = _segments.departureDatetime?.time
                priceText.text =
                    flights.averagePriceBreakdown?.total.toString() + " " + flights.averagePriceBreakdown?.displayedCurrency
                airBrandIcon.loadImage(airlines.image, progressDrawable)

            }

        }
    }

}