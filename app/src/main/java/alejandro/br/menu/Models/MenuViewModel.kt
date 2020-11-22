package alejandro.br.menu.Models

import alejandro.br.menu.Database.DatabaseHandler
import alejandro.br.menu.Models.Pokos.*
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    var idRest = ""
    var menuItems : MutableLiveData<List<MenuItem>> = MutableLiveData()
    //We observe contentOrder only
    var contentOrder: MutableLiveData<MutableList<PedidoItem>> = MutableLiveData()
    var currentContentPart: MutableLiveData<Long> = MutableLiveData()
    lateinit var currentOrderId: String
    var totalPedido = MutableLiveData<Double>()
    lateinit var db:DatabaseHandler

    private val repository = Repository()


    init {
        currentContentPart.value = 0
        Log.e("MenuViewModel", "MenuViewModel created with idRest= $idRest")
    }


    fun initMenuViewModel(context: Context){
        getMenuItems(idRest)
        db = DatabaseHandler(context)
        createEmptyCurrentOrder(idRest)
    }

    // Obtiene el menu
    // desde Firebase
    private fun getMenuItems(idRest: String) {

        repository.getMenu(object:
            Repository.MenuListCallback {
            // Se crea el LiveData cuando el menu está listo
            override fun onCallback(menu: List<MenuItem>) {
                menuItems.value = menu
            }
        }, idRest)
    }

    fun createEmptyCurrentOrder(idRest: String){
        Log.e("Counter Function", "una vez más")
        repository.createEmptyCurrentOrder(object:
            Repository.FirstOrderCalback{
            override fun onCallback(content: MutableList<PedidoItem>, orderId: String) {
                contentOrder.value= content
                currentOrderId = orderId
               // db.addCurrentOrderId(currentOrderId)
            }
        }, idRest)
    }


    fun saveOrder(){
        // TODO Check for ivalid orders
        currentContentPart.value = currentContentPart.value!! +1
        repository.saveOrder(idRest, contentOrder.value!!, currentOrderId, totalPedido.value!!, currentContentPart.value!!)
    }

}