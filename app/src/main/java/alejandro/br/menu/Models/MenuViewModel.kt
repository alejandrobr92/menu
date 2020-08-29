package alejandro.br.menu.Models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    val TAG = "MENU_VIEW_MODEL"
    var idRest = "ORoDlpiidmmId2F60boJ"
    var menuItems : MutableLiveData<List<MenuItem>> = MutableLiveData()
    var pedidoItems : MutableLiveData<MutableMap<MenuItem, Int>> = MutableLiveData()
    private val repository = Repository()

    init {
        Log.e("MenuViewModel", "MenuViewModel created with idRest= $idRest")
        pedidoItems.value = mutableMapOf()
        getMenuItems(idRest)
}

    // Obtiene el menu
    // desde Firebase
    private fun getMenuItems(idRest: String) {

        repository.getMenu(object:Repository.MenuListCallback{
            // Se crea el LiveData cuando el menu está listo
            override fun onCallback(menu: List<MenuItem>) {
                Log.e("MENU FROM MenuViewModel" , menu.toString())
                menuItems.value = menu
            }
        }, idRest)
    }
}