package alejandro.br.menu.Models.Pokos

import com.google.firebase.Timestamp
import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class Order(

    var content: MutableList<PedidoItem>?,
   // val content: Array<Map<String, Any>>?,
    //Change to list of orderItems
   // val content: Array<Map<String, Int>>,
    @ServerTimestamp var time: Date?,
    var table: String?,
    var total: Double,
    var currentContentPart: Long

)
{
    constructor() :  this( null, null , null, 0.0, 0){
    }
}