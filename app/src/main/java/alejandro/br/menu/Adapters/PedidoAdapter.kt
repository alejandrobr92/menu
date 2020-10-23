package alejandro.br.menu.Adapters

import alejandro.br.menu.Models.Pokos.MenuItem
import alejandro.br.menu.Models.Pokos.PedidoItem
import alejandro.br.menu.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.frag_pedido_card.view.*

class PedidoAdapter (private val pedido : MutableList<PedidoItem>, val itemClickListener: View.OnClickListener) : RecyclerView.Adapter<PedidoAdapter.ViewHolder>() {

    private var removedPosition = 0
  //  private  var removedItem = PedidoItem()

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
            var name: TextView = itemView.findViewById(R.id.pedido_name)
            var signX: TextView = itemView.findViewById(R.id.pedido_sign_x)
            var price: TextView = itemView.findViewById(R.id.pedido_price)
            var quantity: TextView = itemView.findViewById(R.id.pedido_quantity)
            var totalParcial: TextView = itemView.findViewById(R.id.pedido_total_parcial)

            cardView.tag = pedidoItem.id
            name.text = pedidoItem.name
            price.text = pedidoItem.price.toString()
            signX.text = "x"
            quantity.text = pedidoItem.quantity.toString()
            totalParcial.text = (pedidoItem.price as Double * pedidoItem.quantity).toString()

            // Fade item if is already delivered
            if(pedidoItem.state.equals("delivered")){
               cardView.alpha= 0.5F
            }

        }
    }

    // Remove function for swipe
    fun removeItem(viewHolder: ViewHolder, itemRemoved : PedidoItem){
        // To undo item removed
        removedPosition = viewHolder.adapterPosition

        pedido.removeAt(viewHolder.adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)

      /*  Snackbar.make(viewHolder.itemView, "Item deleted", Snackbar.LENGTH_LONG).setAction("DESHACER"){
            pedido.add(removedPosition,itemRemoved)
            notifyItemInserted(removedPosition)
        }.show()

       */

    }
}
