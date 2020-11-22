package alejandro.br.menu.activities

import alejandro.br.menu.Adapters.PromotionsAdapter
import alejandro.br.menu.Models.MenuViewModel
import alejandro.br.menu.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_promotion_full_image.*

class PromotionFullImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promotion_full_image)

        val menuViewModel: MenuViewModel by viewModels()

   /*     val intent = intent
        var position = intent.extras.getInt("url")
        val adapter = PromotionsAdapter(this, menuViewModel.promotions.value!!)
        Picasso.get().load(adapter.promotions[position]).into(full_image_promotion)


    */

    }
}