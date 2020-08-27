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


    fun getRestaurants() :  MutableList<Restaurant> {
        Log.e("Repository", "getRest executed")
        firestore.collection("Restaurantes")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.e(TAG, "${document.id} => ${document.data}")
                    restaurants.add(Restaurant(document.id.toString(),document["name"].toString(), document["photo"].toString(), document["description"].toString()))
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
        return restaurants
    }


    fun getMenu(callback: MenuListCallback) {

        val menuItemListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                menuItems.clear()
                dataSnapshot.children.mapNotNullTo(menuItems){
                    it.getValue<MenuItem>(MenuItem::class.java)
                }
                callback.onCallback(menuItems)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        database.child("Carta").addListenerForSingleValueEvent(menuItemListener)
    }

    // Callback para esperar los resultados de Firebase
    interface MenuListCallback {
        fun onCallback(value:List<MenuItem>)
    }
}