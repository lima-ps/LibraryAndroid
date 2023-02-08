package pt.ismai.project2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class Show : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val myBottomNavigationView = findViewById<BottomNavigationView>(R.id.BottomNavigation)

        myBottomNavigationView?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.profile -> {
                    val obj_a= Intent(this, ProfileActivity::class.java)
                    startActivity(obj_a)
                }

                R.id.movies -> {
                    val obj_b= Intent(this, MainActivity::class.java)
                    startActivity(obj_b)
                }

                R.id.books -> {
                    val obj_c= Intent(this, Book::class.java)
                    startActivity(obj_c)
                }

            }
            return@setOnItemSelectedListener true
        }

    }
}