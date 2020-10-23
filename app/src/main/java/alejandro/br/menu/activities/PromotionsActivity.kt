package alejandro.br.menu.activities

import alejandro.br.menu.Adapters.PromotionsAdapter
import alejandro.br.menu.Models.MenuViewModel
import alejandro.br.menu.Models.Repository
import alejandro.br.menu.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_promotions.*

class PromotionsActivity : AppCompatActivity() {

    lateinit var adapter: PromotionsAdapter
    private val repository= Repository()
    var promotions = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promotions)
        getPromotions(intent.getStringExtra("idRest"))


    }
    private fun getPromotions(idRest: String){
        repository.getPromotions(object :
            Repository.PromotionsCallback{
            override fun onCallback(prom: MutableList<String>){
                promotions = prom
                adapter = PromotionsAdapter(this@PromotionsActivity, promotions)
                grid_promotions.adapter= adapter

                grid_promotions.setOnItemClickListener{
                        adapterView, view, position, l ->
                        intent = Intent(view.context, PromotionFullImageActivity::class.java)
                        intent.putExtra("url", position)
                        startActivity(intent)

                }
            }
        }
            , idRest)
    }
}