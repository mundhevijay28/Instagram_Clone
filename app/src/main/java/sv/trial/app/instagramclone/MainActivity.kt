package sv.trial.app.instagramclone

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import sv.trial.app.instagramclone.Fragment.HomeFragment
import sv.trial.app.instagramclone.Fragment.NotificationFragment
import sv.trial.app.instagramclone.Fragment.ProfileFragment
import sv.trial.app.instagramclone.Fragment.SearchFragment
import sv.trial.app.instagramclone.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

 private var selectedFragment: Fragment? = null

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_home -> {

                selectedFragment = HomeFragment()
            }
            R.id.nav_search -> {

                selectedFragment = SearchFragment()
            }
            R.id.nav_add_post -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_notifications -> {

                selectedFragment = NotificationFragment()
            }
            R.id.nav_profile -> {

                selectedFragment = ProfileFragment()
            }
        }

        if(selectedFragment != null){
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,
                selectedFragment!!
            ).commit()
        }

        false
    }




    private lateinit var binding: ActivityMainBinding
//
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
//    val navView = findViewById<>(R.id.nav_view)


        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    supportFragmentManager.beginTransaction().replace(
        R.id.fragment_container,
        HomeFragment()
    ).commit()


    binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val navView = BottomNavigationView = findViewById(R.id.nav_view)
//        val navView: BottomNavigationView = binding.navView

//        var textMessage = findViewById(androidx.appcompat.R.id.message)
//
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
//        textview = findViewById(R.id.message)
        navView.setupWithNavController(navController)
    }
}