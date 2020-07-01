package alejandro.br.menu.Adapters

import alejandro.br.menu.Models.MenuItem
import alejandro.br.menu.Models.PedidoItem
import alejandro.br.menu.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class PedidoAdapter (private val pedido : List<PedidoItem>, val itemClickListener: View.OnClickListener) : RecyclerView.Adapter<PedidoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context).inflate(R.layout.frag_pedido_card, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(pedido[position])
    }

    override fun getItemCount(): Int {
        return pedido.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(pedidoItem: PedidoItem) {
            val cardView = itemView.findViewById<CardView>(R.id.pedido_card)
            var name: TextView = itemView.findViewById<TextView>(R.id.pedido_name)
            var price: TextView = itemView.findViewById(R.id.pedido_price)
            var quantity: TextView = itemView.findViewById<TextView>(R.id.pedido_quantity)
            var totalParcial: TextView = itemView.findViewById(R.id.pedido_total_parcial)

            name.text = pedidoItem.name
            price.text = pedidoItem.price.toString()
            quantity.text = "X "+pedidoItem.quantity.toString()
            totalParcial.text = (pedidoItem.price * pedidoItem.quantity).toString()
            cardView.setOnClickListener(itemClickListener)

        }
    }
}