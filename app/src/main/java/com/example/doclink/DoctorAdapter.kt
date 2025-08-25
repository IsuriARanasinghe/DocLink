package com.example.doclink

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DoctorAdapter(
    private val context: Context,
    private val doctorList: List<Doctor>
) : RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {

    class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageDoctor: ImageView = itemView.findViewById(R.id.imageDoctor)
        val textDoctorName: TextView = itemView.findViewById(R.id.textDoctorName)
        val textSpecialty: TextView = itemView.findViewById(R.id.textSpecialty)
        val textAvailability: TextView = itemView.findViewById(R.id.textAvailability)
        val textReviews: TextView = itemView.findViewById(R.id.textReviews)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        val btnBookNow: Button = itemView.findViewById(R.id.btnBookNow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_doctor, parent, false)
        return DoctorViewHolder(view)
    }

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = doctorList[position]
        holder.textDoctorName.text = doctor.name
        holder.textSpecialty.text = doctor.specialty
        holder.textAvailability.text = "Available: ${doctor.availability}"
        holder.ratingBar.rating = doctor.rating
        holder.textReviews.text = "${doctor.rating} (${doctor.reviews} Reviews)"

        Glide.with(context).load(doctor.imageUrl).into(holder.imageDoctor)

        holder.btnBookNow.setOnClickListener {
            Toast.makeText(context, "Booking with ${doctor.name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = doctorList.size
}