package alejandro.br.menu.activities

import alejandro.br.menu.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

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
