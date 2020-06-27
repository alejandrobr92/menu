package alejandro.br.menu.Adapters

import alejandro.br.menu.Models.CategoryMenu
import alejandro.br.menu.Models.MenuItem
import alejandro.br.menu.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.frag_cat_bebidas_card.view.*

class MenuItemAdapter (private val menu : LiveData<List<MenuItem>>)
    : RecyclerView.Adapter<MenuItemAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.frag_cat_bebidas_card, parent, false)
        return ViewHolder(viewItem)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val itemMenu = menu.value!![position]
        with(holder){
            cardView.tag = itemMenu
            name.text= itemMenu.name
            price.text = itemMenu.price.toString()
        }
    }

    override fun getItemCount(): Int {
         return   menu.value?.size ?: 0
    }


     class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

         val cardView = itemView.findViewById<CardView>(R.id.menu_item_card)
         var name: TextView = itemView.findViewById<TextView>(R.id.menu_item_name)
         var price: TextView = itemView.findViewById<TextView>(R.id.menu_item_price)

    }


    interface MenuItemListener {
    }


}