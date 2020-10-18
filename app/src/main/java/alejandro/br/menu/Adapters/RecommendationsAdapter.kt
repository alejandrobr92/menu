package alejandro.br.menu.Adapters

import alejandro.br.menu.Models.Pokos.PedidoItem
import alejandro.br.menu.Models.Pokos.Recommendation
import alejandro.br.menu.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecommendationsAdapter (private val recommendations : MutableList<Recommendation>) : RecyclerView.Adapter<RecommendationsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.card_recommendations, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(recommendations[position])
    }

    override fun getItemCount(): Int {
        return recommendations.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(recommendation: Recommendation) {
          //  val cardView = itemView.findViewById<CardView>(R.id.card_recomm)
            var title: TextView = itemView.findViewById(R.id.title_recommendations)
            var price: TextView = itemView.findViewById(R.id.price_recommendations)
            var rating:TextView = itemView.findViewById(R.id.rating_recommendations)


            title.text = recommendation.title
            price.text = recommendation.price.toString()
            rating.text = recommendation.rating.toString()

    }



    }
}