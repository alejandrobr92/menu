package alejandro.br.menu.data

import alejandro.br.menu.R
import alejandro.br.menu.model.CategoryMenu
import alejandro.br.menu.model.Meal
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_categorie.view.*

class CategoriesMenuAdapter (private val list: ArrayList<CategoryMenu>,
                             private val context: Context): RecyclerView.Adapter<CategoriesMenuAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesMenuAdapter.ViewHolder {
        // Create our view from our xml
        val view = LayoutInflater.from(context).inflate(R.layout.card_categorie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesMenuAdapter.ViewHolder, position: Int) {
        holder!!.bindItem(list[position])
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