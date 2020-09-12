package alejandro.br.menu.Models.Pokos

import com.google.firebase.Timestamp
import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class Order (/*id: String, content: Map<MenuItem,Int>, @ServerTimestamp  val timeStamp: Date? = null, table: String, total: Double)*/
    val content: Map<String, Int>,
    @ServerTimestamp  val time : Date,
    val table: String,
    val total: Double
)
/*{

    constructor( id: String, content: Map<MenuItem,Int>, table: String, total: Double) :  this(id, content, null , table, total){
    }
}*/