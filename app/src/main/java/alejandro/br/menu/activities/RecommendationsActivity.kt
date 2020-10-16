package alejandro.br.menu.activities

import alejandro.br.menu.Adapters.PromotionsAdapter
import alejandro.br.menu.Adapters.RecommendationsAdapter
import alejandro.br.menu.Adapters.RestaurantAdapter
import alejandro.br.menu.Models.Pokos.Recommendation
import alejandro.br.menu.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_promotions.*
import kotlinx.android.synthetic.main.activity_recommendations.*
import kotlinx.android.synthetic.main.activity_select_rest.*

class RecommendationsActivity : AppCompatActivity() {

    private var adapter: RecommendationsAdapter
    private lateinit var recommendations:  MutableList<Recommendation>
    init{
        recommendations= mutableListOf()
        recommendations.add(Recommendation("Grinbergen", "null", 28.5, 4.8))
        recommendations.add(Recommendation("Grinbergen", "null", 28.5, 4.8))
        recommendations.add(Recommendation("Grinbergen", "null", 28.5, 4.8))
        recommendations.add(Recommendation("Grinbergen", "null", 28.5, 4.8))
        recommendations.add(Recommendation("Grinbergen", "null", 28.5, 4.8))
        recommendations.add(Recommendation("Grinbergen", "null", 28.5, 4.8))
        recommendations.add(Recommendation("Grinbergen", "null", 28.5, 4.8))
        recommendations.add(Recommendation("Grinbergen", "null", 28.5, 4.8))

        adapter = RecommendationsAdapter(recommendations)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recommendations)

        recycler_recommendations.layoutManager = GridLayoutManager(this, 2)
        recycler_recommendations.adapter = adapter
    }
}