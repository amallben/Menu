package com.example.coronaproject

//import android.R

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
//    var drawerLayout: DrawerLayout? = null
//    var navigationView: NavigationView? = null
//    var toolbar: Toolbar? = null
//    var menu: Menu? = null
//    var textView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        drawerLayout= findViewById(R.id.drawer_layout);
//        navigationView=findViewById(R.id.nav_view);
//        textView=findViewById(R.id.textView);
//        toolbar=findViewById(R.id.toolbar);

        setSupportActionBar(toolbar)
//        nav_view.getMenu().getItem(R.id.nav_logout).setVisible(false)
//        nav_view.getMenu().getItem(R.id.nav_profile).setVisible(false)

        nav_view.bringToFront();

        var toggle = ActionBarDrawerToggle(this,
            drawer_layout, toolbar,
            R.string.navigation_drawer_close,
            R.string.navigation_drawer_close
        )

        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
        nav_view.setNavigationItemSelectedListener(this);
        nav_view.setCheckedItem(R.id.nav_home);
//    }
      }
   override fun onBackPressed() {
        if (drawer_layout!!.isDrawerOpen(GravityCompat.START)) {
            drawer_layout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
       }
   }



    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.getItemId()) {
            R.id.nav_home -> {

            }
            R.id.nav_infos -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    information()
                ).commit()
            }
            R.id.nav_login -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container,
                    infos()
                ).commit()

            }
//            R.id.nav_logout -> {
//
//                menu!!.findItem(R.id.nav_logout).isVisible = false
//                menu!!.findItem(R.id.nav_profile).isVisible = false
//                menu!!.findItem(R.id.nav_login).isVisible = true
//            }
            R.id.nav_reports -> Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
 }

