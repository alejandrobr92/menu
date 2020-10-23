package alejandro.br.menu.Models.Pokos

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class Recommendation( val title:String, val photo:String, val price: Double, val rating:Double){
    constructor(): this ("",  "", 0.0,0.0)
}