package alejandro.br.menu.activities

import alejandro.br.menu.Fragments.FragmentDeux
import alejandro.br.menu.Fragments.FragmentTrois
import alejandro.br.menu.Fragments.FragmentUn
import alejandro.br.menu.R
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityNavHost : AppCompatActivity() {

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main_navhost)

        setSupportActionBar(toolbar)
      //  supportActionBar = findViewById<Toolbar>(R.id.toolbar)

        navController  = findNavController(R.id.nav_host_fragment)
        setupActionBarWithNavController(navController)

       // findViewById<BottomNavigationView>(R.id.bottom_navigation).setupWithNavController(navController)
            NavigationUI.setupActionBarWithNavController(this, navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
        //findNavController(R.id.nav_host_fragment).navigateUp()
       // return super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }
}