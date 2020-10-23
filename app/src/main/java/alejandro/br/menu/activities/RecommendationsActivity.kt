package alejandro.br.menu.activities

import alejandro.br.menu.Adapters.PromotionsAdapter
import alejandro.br.menu.Adapters.RecommendationsAdapter
import alejandro.br.menu.Adapters.RestaurantAdapter
import alejandro.br.menu.Models.Pokos.Recommendation
import alejandro.br.menu.Models.Repository
import alejandro.br.menu.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_promotions.*
import kotlinx.android.synthetic.main.activity_recommendations.*
import kotlinx.android.synthetic.main.activity_select_rest.*

class RecommendationsActivity : AppCompatActivity() {

    private lateinit var adapter: RecommendationsAdapter
    private val repository= Repository()
    private lateinit var recommendations:  MutableList<Recommendation>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendations)
        getRecommendations(intent.getStringExtra("idRest"))

    }

    private fun getRecommendations(idRest: String){
        repository.getRecommendations(object :
            Repository.RecommendationsCallback {
            override fun onCallback(recomms: MutableList<Recommendation>) {
                recommendations = recomms
                adapter= RecommendationsAdapter(recomms)
                recycler_recommendations.layoutManager = GridLayoutManager(this@RecommendationsActivity, 2)
                recycler_recommendations.adapter = adapter
            }
        }
            , idRest)
    }

}