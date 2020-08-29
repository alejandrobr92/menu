package alejandro.br.menu.activities

import alejandro.br.menu.Adapters.MenuItemAdapter
import alejandro.br.menu.Adapters.RestaurantAdapter
import alejandro.br.menu.Models.Repository
import alejandro.br.menu.Models.Restaurant
import alejandro.br.menu.Models.RestaurantViewModel
import alejandro.br.menu.R
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_select_rest.*

class SelectRestActivity : AppCompatActivity() {

    val TAG =  "FIREBASE_REPOSITORY"
    private lateinit var adapter: RestaurantAdapter
    private var restaurantList: MutableList<Restaurant> = mutableListOf()
   // private val restaurantViewModel: RestaurantViewModel by viewModels()
    var firestore = FirebaseFirestore.getInstance()
    val repository = Repository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_rest)

        recycler_restaurant.layoutManager = LinearLayoutManager(this)

        repository.getRestaurants(object:Repository.RestaurantsCallback{
            override fun onCallback(restaurants: List<Restaurant>) {
                Log.e("Rest FROM FIREBASE" , restaurants.toString())

                adapter = RestaurantAdapter(restaurants)
                recycler_restaurant.adapter = adapter
            }
        })

    }
}
