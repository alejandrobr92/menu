package alejandro.br.menu.Adapters

import alejandro.br.menu.Models.MenuItem
import alejandro.br.menu.R
import alejandro.br.menu.activities.DetailMealTwoActivity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MenuItemAdapter (private val menu : List<MenuItem>, val itemClickListener: View.OnClickListener) : RecyclerView.Adapter<MenuItemAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.frag_cat_card, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      holder.bindItem(menu[position])
    }

    override fun getItemCount(): Int {
         return   menu.size ?: 0
    }

  inner    class ViewHolder(itemView: View ): RecyclerView.ViewHolder(itemView){

        fun bindItem(menuItem : MenuItem) {
            val cardView = itemView.findViewById<CardView>(R.id.menu_item_card)
            var name: TextView = itemView.findViewById<TextView>(R.id.menu_item_name)
            var price: TextView = itemView.findViewById<TextView>(R.id.menu_item_price)
            val boton = itemView.findViewById<Button>(R.id.addItemToPedido)
            boton.tag = position
            name.text= menuItem.name
            price.text = menuItem.price.toString()

            boton.setOnClickListener(itemClickListener)
            cardView.setOnClickListener {
                val intent = Intent(itemView.context   , DetailMealTwoActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    }


}