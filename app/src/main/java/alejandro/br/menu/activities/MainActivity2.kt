package alejandro.br.menu.activities

import alejandro.br.menu.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        setSupportActionBar(toolbar)

        val navController = findNavController(R.id.nav_host_fragment)
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .setupWithNavController(navController)
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