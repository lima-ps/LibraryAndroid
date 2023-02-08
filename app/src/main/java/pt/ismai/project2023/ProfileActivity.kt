package pt.ismai.project2023

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import pt.ismai.project2023.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myBottomNavigationView = findViewById<BottomNavigationView>(R.id.BottomNavigation)

        myBottomNavigationView?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.movies -> {
                    val obj_a= Intent(this, MainActivity::class.java)
                    startActivity(obj_a)
                }

                R.id.shows -> {
                    val obj_b= Intent(this, Show::class.java)
                    startActivity(obj_b)
                }

                R.id.books -> {
                    val obj_c= Intent(this, Book::class.java)
                    startActivity(obj_c)
                }
            }
            return@setOnItemSelectedListener true

        }

        firebaseAuth = FirebaseAuth.getInstance()

        if (firebaseAuth.currentUser != null) {
            firebaseAuth.currentUser?.let {
                binding.myProfile.text = it.email
            }
        }

        binding.signOut.setOnClickListener {
            firebaseAuth.signOut()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


}