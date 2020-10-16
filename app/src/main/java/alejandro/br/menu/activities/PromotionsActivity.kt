package alejandro.br.menu.activities

import alejandro.br.menu.Adapters.PromotionsAdapter
import alejandro.br.menu.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_promotions.*

class PromotionsActivity : AppCompatActivity() {

    private var adapter: PromotionsAdapter

    init{
        adapter = PromotionsAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promotions)

        grid_promotions.adapter= adapter

        grid_promotions.setOnItemClickListener{
            adapterView, view, position, l ->
            intent = Intent(this, PromotionFullImageActivity::class.java)
            intent.putExtra("url", position)
            startActivity(intent)

        }

    }
}