package alejandro.br.menu.Models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Repository(){

    val TAG =  "FIREBASE_REPOSITORY"
    var database = FirebaseDatabase.getInstance().reference
    var menuItems : MutableList<MenuItem> = mutableListOf()
    var firestore = FirebaseFirestore.getInstance()
    private var restaurants : MutableList<Restaurant> = mutableListOf()


    fun getRestaurants(callback: RestaurantsCallback) {
        firestore.collection("Restaurantes")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.e(TAG, "${document.id} => ${document.data}")
                    restaurants.add(Restaurant(document.id.toString(),document["name"].toString(), document["photo"].toString(), document["description"].toString()))
                }
                callback.onCallback(restaurants)
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }


    fun getMenu(callback: MenuListCallback, idRest: String ) {
        Log.e("Repo:", idRest)
        firestore.collection("Restaurantes/$idRest/menu")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.e(TAG, "${document.id} => ${document.data}")
                    var menuItem = document.toObject(MenuItem::class.java)
                    menuItems.add(menuItem)
                    Log.e(idRest, menuItem.toString() )
                }
                callback.onCallback(menuItems)
            }
            .addOnFailureListener { exception ->
                Log.e(TAG, "Error getting documents: ", exception)
            }
    }



    // Callback para esperar los resultados de Firebase
    interface MenuListCallback {
        fun onCallback(value:List<MenuItem>)
    }

    interface RestaurantsCallback {
        fun onCallback(value:List<Restaurant>)
    }





    }


