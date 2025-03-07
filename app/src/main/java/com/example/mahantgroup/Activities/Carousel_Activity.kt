package com.example.mahantgroup.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.mahantgroup.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Carousel_Activity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var skipButton: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousel)
        supportActionBar?.hide()
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        skipButton = findViewById(R.id.cardView)


        val carouselAdapter = CarouselAdapter(getOnboardingPages())
        viewPager.adapter = carouselAdapter


        TabLayoutMediator(tabLayout, viewPager) { _, _ ->

        }.attach()

        skipButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }

    private fun getOnboardingPages(): List<OnboardingPage> {
        return listOf(
            OnboardingPage(
                R.drawable.groceries_bag,
                "Groceries Made Simple!",
                "Shop your daily essentials from fresh produce to pantry staples — all at your fingertips."
            ),
            OnboardingPage(
                R.drawable.delivery,
                "Fast Delivery",
                "Get your groceries delivered right to your door within 30 minutes or less."
            )
        )
    }
}


data class OnboardingPage(
    val imageRes: Int,
    val title: String,
    val description: String
)


class CarouselAdapter(private val pages: List<OnboardingPage>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_carousel, parent, false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.bind(pages[position])
    }

    override fun getItemCount(): Int = pages.size

    class CarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.carouselImage)
        private val titleText: TextView = itemView.findViewById(R.id.carouselTitle)
        private val descriptionText: TextView = itemView.findViewById(R.id.carouselDescription)

        fun bind(page: OnboardingPage) {
            imageView.setImageResource(page.imageRes)
            titleText.text = page.title
            descriptionText.text = page.description
        }
    }
}