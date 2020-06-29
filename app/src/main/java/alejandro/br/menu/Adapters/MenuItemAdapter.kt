package alejandro.br.menu.Adapters

import alejandro.br.menu.Models.CategoryMenu
import alejandro.br.menu.Models.MenuItem
import alejandro.br.menu.Models.MenuViewModel
import alejandro.br.menu.R
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.frag_cat_postres_card.view.*

class MenuItemAdapter (private val menu : List<MenuItem>, val itemClickListener: View.OnClickListener) : RecyclerView.Adapter<MenuItemAdapter.ViewHolder>(){

    var menuViewModel : MenuViewModel

    init {
        menuViewModel = MenuViewModel()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.frag_cat_postres_card, parent, false)
        return ViewHolder(viewItem)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bindItem(menu[position])

    }

    override fun getItemCount(): Int {
         return   menu.size ?: 0
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindItem(menuItem : MenuItem) {
            val cardView = itemView.findViewById<CardView>(R.id.menu_item_card)
            var name: TextView = itemView.findViewById<TextView>(R.id.menu_item_name)
            var price: TextView = itemView.findViewById<TextView>(R.id.menu_item_price)

            name.text= menuItem.name
            price.text = menuItem.price.toString()
            cardView.setOnClickListener(itemClickListener)

        }
    }


}