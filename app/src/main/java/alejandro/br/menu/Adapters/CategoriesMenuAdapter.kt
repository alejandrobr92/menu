package alejandro.br.menu.Adapters

import alejandro.br.menu.R
import alejandro.br.menu.Models.CategoryMenu
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriesMenuAdapter (private val list: MutableList<CategoryMenu>,
                             private val context: Context): RecyclerView.Adapter<CategoriesMenuAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create our view from our xml
        val view = LayoutInflater.from(context).inflate(R.layout.card_categorie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItem(category: CategoryMenu){
            var name : TextView = itemView.findViewById(R.id.name__category) as TextView
            name.text = category.name
        }
    }
}