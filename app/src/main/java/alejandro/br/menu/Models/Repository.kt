package alejandro.br.menu.Models

import alejandro.br.menu.Models.Pokos.*
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.util.*
import kotlin.collections.ArrayList

class Repository(){

    val TAG =  "FIREBASE_REPOSITORY"
    var menuItems : MutableList<MenuItem> = mutableListOf()
    var firestore = FirebaseFirestore.getInstance()
    private var restaurants : MutableList<Restaurant> = mutableListOf()
    private var recommendations : MutableList<Recommendation> = mutableListOf()
    private var promotions : MutableList<String> = mutableListOf()


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

    // Creates the order to start observing
    fun createEmptyCurrentOrder(callback: FirstOrderCalback, idRest: String){
        val ref= firestore.collection("Restaurantes/$idRest/orders").document()
        var preorder = Order(mutableListOf(), Date(), "2", 0.0, 0)
        ref.set(preorder).addOnCompleteListener{
        Log.e("RefID", ref.id)
           getCurrentOrder(idRest, ref.id, callback)
        }

    }

    fun getCurrentOrder(idRest: String, idCurrentOrder: String , callback: FirstOrderCalback){
        firestore.document("Restaurantes/$idRest/orders/$idCurrentOrder")
            .addSnapshotListener{ snapshot, e ->
                if (e != null) {
                    Log.e(TAG, "Listen failed.", e)
                    return@addSnapshotListener
                }
                if (snapshot != null && snapshot.exists()) {
                    // Creates a list with content's content
                    var arrayList : ArrayList<Map<String, Any>>
                    arrayList = snapshot.data!!.get("content") as ArrayList<Map<String, Any>>

                    var list = mutableListOf<PedidoItem>()
                    arrayList
                        .map {
                        PedidoItem(
                            it["id"] as String,
                            it["name"] as String,
                            it["price"].toString().toDouble()  ,
                            it["quantity"] as Long,
                            it["state"] as String,
                            it["part"] as Long
                        )
                    }.forEach { list.add(it) }

                    callback.onCallback(list, idCurrentOrder)

                } else {
                    Log.e(TAG, "Current data: null")
                    callback.onCallback(mutableListOf(), idCurrentOrder)
                }

                //order.total = snapshot?.get("total") as Double
            }
    }

    fun getPromotions(callback: PromotionsCallback, idRest: String){
        firestore.collection("Restaurantes/$idRest/promotions")
            .addSnapshotListener{ snapshot, e ->
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e)
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    for (document in snapshot){
                        var promotion = document.getString("url")!!
                        promotions.add(promotion)
                    }
                }
                callback.onCallback(promotions)
            }
    }

    fun getRecommendations(callback: RecommendationsCallback, idRest: String){
        firestore.collection("Restaurantes/$idRest/recommendations")
            .orderBy("rating", Query.Direction.DESCENDING)
            .addSnapshotListener{ snapshot, e ->
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e)
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    for (document in snapshot){
                        var recommendation = document.toObject(Recommendation::class.java)
                        recommendations.add(recommendation)
                    }
                }
                callback.onCallback(recommendations)
            }
    }
    fun saveOrder(idRest: String, listPedido: MutableList<PedidoItem>, orderId: String,total: Double, currentContentPart:Long){
        // Creates a new order with and id
        var ref = firestore.document("Restaurantes/$idRest/orders/$orderId")
        ref.update(mutableMapOf(Pair("content", listPedido), Pair("total",total), Pair("currentContentPart", currentContentPart)) as Map<String, Any>)


        //  var content = listPedido.mapKeys{ k -> k.key.id}
        //  var order = Order(arrayOf(content), Date(), "6", total)
        // Save the order in a document
        //  ref.set(order)
    }



    // Callback para esperar los resultados de Firebase
    interface MenuListCallback {
        fun onCallback(value:List<MenuItem>)
    }

    interface RestaurantsCallback {
        fun onCallback(value:MutableList<Restaurant>)
    }

    interface FirstOrderCalback {
        fun onCallback(value: MutableList<PedidoItem>, orderId: String )
    }

    interface  PromotionsCallback{
        fun onCallback(value: MutableList<String>)
    }

    interface  RecommendationsCallback{
        fun onCallback(value: MutableList<Recommendation>)
    }





    }


