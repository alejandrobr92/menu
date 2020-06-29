package alejandro.br.menu.Models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import alejandro.br.menu.Models.Repository
import androidx.lifecycle.ViewModel

class MenuViewModel : ViewModel() {

    val TAG = "MENU_VIEW_MODEL"
    var menuItems : MutableLiveData<List<MenuItem>> = MutableLiveData()
    var pedidoItems : MutableLiveData<MutableMap<String, Int>> = MutableLiveData()
    val repository = Repository()

    init {
        Log.e("MenuViewModel", "MenuViewModel created!")
        pedidoItems.value = mutableMapOf()
        getMenuItems()
}

    // Obtiene el menu
    // desde Firebase
    fun getMenuItems() { //: LiveData<List<MenuItem>> {

        repository.getMenu(object:Repository.MenuListCallback{
            // Se crea el LiveData cuando el menu está listo
            override fun onCallback(menu: List<alejandro.br.menu.Models.MenuItem>) {
                Log.e("MENU FROM FIREBASE2" , menu.toString())
                menuItems.value = menu
            }
        })
    }

  /*  fun getPedidoItems() { //: LiveData<MutableMap<String,Int>>{

        pedidoItems.value = mutableMapOf<String, Int>()
      //  return pedidoItems
    }

   */
}