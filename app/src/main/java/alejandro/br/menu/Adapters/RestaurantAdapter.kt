package alejandro.br.menu.Adapters

import alejandro.br.menu.Models.Restaurant
import alejandro.br.menu.R
import alejandro.br.menu.activities.MainActivity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RestaurantAdapter (private val list: List<Restaurant>) : RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_restaurant, parent, false)
        return ViewHolder(viewItem)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val restaurant = list[position]
        with(holder){
            cardView.tag = restaurant.id
            //name.text= restaurant.name
          //  desc.text= restaurant.desc
            Picasso.get().load(restaurant.photo).into(logo)
            cardView.setOnClickListener {
                val intent = Intent(itemView.context   , MainActivity::class.java)
                intent.putExtra("idRest",restaurant.id)
                itemView.context.startActivity(intent)
            }
        }
    }

    interface RestaurantListener {
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.card_rest)
       // val name: TextView = itemView.findViewById<TextView>(R.id.name__rest)
       // val desc: TextView = itemView.findViewById(R.id.desc_rest)
        val logo: ImageView= itemView.findViewById(R.id.logo_rest)

    }

}