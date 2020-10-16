package alejandro.br.menu.activities

import alejandro.br.menu.Adapters.PromotionsAdapter
import alejandro.br.menu.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_promotion_full_image.*

class PromotionFullImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promotion_full_image)

        val intent = intent
        var position = intent.extras.getInt("url")
        val adapter = PromotionsAdapter(this)
        Picasso.get().load(adapter.promotions[position]).into(full_image_promotion)


    }
}