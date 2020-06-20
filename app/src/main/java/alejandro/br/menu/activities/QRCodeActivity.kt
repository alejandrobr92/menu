package alejandro.br.menu.activities

import alejandro.br.menu.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_qrcode.*

class QRCodeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode)

        code_QR.setOnClickListener { v ->
            intent = Intent(this, SecondSplashActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}