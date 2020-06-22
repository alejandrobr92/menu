package alejandro.br.menu.activities

import alejandro.br.menu.Fragments.FragmentDeux
import alejandro.br.menu.Fragments.FragmentTrois
import alejandro.br.menu.Fragments.FragmentUn
import alejandro.br.menu.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var fragmentSelected = Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->

            when(item.itemId) {
                R.id.fragmentUn -> {
                    // Respond to navigation item 1 click
                    fragmentSelected = FragmentUn()
                    loadFragment(fragmentSelected)
                    return@setOnNavigationItemSelectedListener true

                }
                R.id.fragmentDeux -> {
                    // Respond to navigation item 2 click
                    fragmentSelected = FragmentDeux()
                    loadFragment(fragmentSelected)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.fragmentTrois -> {
                    // Respond to navigation item 2 click
                    fragmentSelected = FragmentTrois()
                    loadFragment(fragmentSelected)
                    return@setOnNavigationItemSelectedListener true
                }
                else ->
                    false
            }
        }



    }


   private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
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
