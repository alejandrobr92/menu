package alejandro.br.menu.activities

import alejandro.br.menu.Models.MenuViewModel
import alejandro.br.menu.R
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.badge.BadgeDrawable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.bottom_navigation

class MainActivity : AppCompatActivity() {

    private lateinit var navController : NavController
    private lateinit var menuViewModel  : MenuViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuViewModel= ViewModelProviders.of(this).get(MenuViewModel::class.java)
       // menuViewModel.idRest= intent.getStringExtra("idRest")
        menuViewModel.idRest= "ORoDlpiidmmId2F60boJ"
        menuViewModel.initMenuViewModel()

        // Show notif
        /*menuViewModel.pedidoItems.observe(this, Observer {
            val badge: BadgeDrawable = bottom_navigation.getOrCreateBadge(
                R.id.fragmentTrois)
                badge.isVisible = true
        } )*/

        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)
        bottom_navigation.setupWithNavController(navController)


        // Disable buttons when selected
        bottom_navigation.setOnNavigationItemReselectedListener { item ->
            when(item.itemId) {
                R.id.fragmentUn-> { false }
                R.id.fragmentDeux -> { false }
                R.id.fragmentTrois -> { false }
            }
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.settings ->{
                Toast.makeText(this, "Ir a configuración", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.my_history ->{
                Toast.makeText(this,"Ir a mi historial", Toast.LENGTH_SHORT).show()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }



}