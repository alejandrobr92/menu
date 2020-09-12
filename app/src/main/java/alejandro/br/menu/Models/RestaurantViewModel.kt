package alejandro.br.menu.Models

import alejandro.br.menu.Models.Pokos.Restaurant
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RestaurantViewModel : ViewModel() {

    private val repository = Repository()
    var restaurants: MutableLiveData<List<Restaurant>> = MutableLiveData()

    init {
        Log.e("RestaurantViewModel", "RestaurantViewModel created!")
        getRestaurants()
    }

    // Get restaurants from Firebase
    private fun getRestaurants() {
        Log.e("ViewModel", "getRest executed")
    }



}