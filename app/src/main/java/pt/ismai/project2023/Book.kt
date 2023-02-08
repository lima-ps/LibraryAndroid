package pt.ismai.project2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class Book : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        val myBottomNavigationView = findViewById<BottomNavigationView>(R.id.BottomNavigation)

        myBottomNavigationView?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> {
                    val obj_a= Intent(this, ProfileActivity::class.java)
                    startActivity(obj_a)
                }

                R.id.shows -> {
                    val obj_b= Intent(this, Show::class.java)
                    startActivity(obj_b)
                }

                R.id.movies -> {
                    val obj_c= Intent(this, MainActivity::class.java)
                    startActivity(obj_c)
                }
            }
            return@setOnItemSelectedListener true

        }

    }
}