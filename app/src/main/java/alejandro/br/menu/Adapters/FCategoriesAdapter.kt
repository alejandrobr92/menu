package alejandro.br.menu.Adapters

import alejandro.br.menu.R
import alejandro.br.menu.Models.CategoryMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FCategoriesAdapter (private val list: List<CategoryMenu>,
                          private val categoryListener : CategorytItemListener) : RecyclerView.Adapter<FCategoriesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_categorie, parent, false)
        return ViewHolder(viewItem)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val category = list[position]
        with(holder){
            cardView.tag = category
            //cardView.setOnClickListener()
            name.text= category.name
        }

    }

    interface CategorytItemListener {

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.card_category)
        var name: TextView = itemView.findViewById<TextView>(R.id.name__category)

    }

}