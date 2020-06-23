package alejandro.br.menu.activities

import alejandro.br.menu.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SecondSplashActivity : AppCompatActivity() {

    private lateinit var handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_splash)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, MainActivity2::class.java)
            this.startActivity(intent)
            finish()
        }, 1500)
    }
}
