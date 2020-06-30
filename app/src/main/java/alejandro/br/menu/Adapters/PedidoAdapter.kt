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
            var amount: TextView = itemView.findViewById<TextView>(R.id.pedido_amount)
            var quantity: TextView = itemView.findViewById<TextView>(R.id.pedido_quantity)

            name.text = pedidoItem.name
            amount.text = pedidoItem.price.toString()
            quantity.text = pedidoItem.quantity.toString()
            cardView.setOnClickListener(itemClickListener)

        }
    }
}