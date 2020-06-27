package alejandro.br.menu.Models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Repository(){

    val TAG =  "FIREBASE_REPOSITORY"
    var database = FirebaseDatabase.getInstance().reference
    //var menuItems : MutableLiveData<List<MenuItem>> = MutableLiveData()
    var menuItems : MutableList<MenuItem> = mutableListOf()


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
                // ...
            }
        }
        database.child("Carta").addListenerForSingleValueEvent(menuItemListener)


    }

    // Callback para esperar los resultados de Firebases
    interface MenuListCallback {
        fun onCallback(value:List<MenuItem>)
    }

}