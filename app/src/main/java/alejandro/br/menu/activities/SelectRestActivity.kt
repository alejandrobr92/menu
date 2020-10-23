package alejandro.br.menu.activities

import alejandro.br.menu.Adapters.RestaurantAdapter
import alejandro.br.menu.Models.Repository
import alejandro.br.menu.Models.Pokos.Restaurant
import alejandro.br.menu.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_select_rest.*

class SelectRestActivity : AppCompatActivity() {

    private lateinit var adapter: RestaurantAdapter
    val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_rest)

        recycler_restaurant.layoutManager = LinearLayoutManager(this)

        repository.getRestaurants(object:Repository.RestaurantsCallback{
            override fun onCallback(restaurants: MutableList<Restaurant>) {
                adapter = RestaurantAdapter(restaurants)
                recycler_restaurant.adapter = adapter
            }
        })

    }
}
