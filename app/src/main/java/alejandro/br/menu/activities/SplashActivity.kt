package alejandro.br.menu.activities

import alejandro.br.menu.Adapters.RestaurantAdapter
import alejandro.br.menu.Models.Restaurant
import alejandro.br.menu.Models.RestaurantViewModel
import alejandro.br.menu.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_select_rest.*

class SplashActivity : AppCompatActivity() {

    val TAG =  "LOADING_FROM_SPLAH"
    private lateinit var handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, SelectRestActivity::class.java)
            this.startActivity(intent)
            finish()
        }, 1000)

    }
}
