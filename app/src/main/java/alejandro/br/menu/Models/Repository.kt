package alejandro.br.menu.Models

import alejandro.br.menu.Models.Pokos.MenuItem
import alejandro.br.menu.Models.Pokos.Order
import alejandro.br.menu.Models.Pokos.Restaurant
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class Repository(){

    val TAG =  "FIREBASE_REPOSITORY"
    var menuItems : MutableList<MenuItem> = mutableListOf()
    var firestore = FirebaseFirestore.getInstance()
    private var restaurants : MutableList<Restaurant> = mutableListOf()


    fun getRestaurants(callback: RestaurantsCallback) {

        firestore.collection("Restaurantes")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    restaurants.add(
                        Restaurant(
                            document.id,
                            document["name"].toString(),
                            document["photo"].toString(),
                            document["description"].toString()
                        )
                    )
                }
                callback.onCallback(restaurants)
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }


    fun getMenu(callback: MenuListCallback, idRest: String ) {

        firestore.collection("Restaurantes/$idRest/menu")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e)
                    return@addSnapshotListener
                }
                menuItems.clear()
                for (document in snapshot!!) {
                    var menuItem = document.toObject(MenuItem::class.java)
                    menuItem.id= document.id
                    menuItems.add(menuItem)
                }
                callback.onCallback(menuItems)
            }

    }


    fun saveOrder(idRest: String, listPedido: MutableMap<MenuItem, Int>, total: Double){
        // Creates a new order with and id
        var ref = firestore.collection("Restaurantes/$idRest/orders").document()
        var content = listPedido.mapKeys{ k -> k.key.id}
        var order = Order(arrayOf(content), Date(), "6", total)
        // Save the order in a document
        ref.set(order)
    }



    // Callback para esperar los resultados de Firebase
    interface MenuListCallback {
        fun onCallback(value:List<MenuItem>)
    }

    interface RestaurantsCallback {
        fun onCallback(value:MutableList<Restaurant>)
    }





    }


