package alejandro.br.menu.Fragments

import alejandro.br.menu.Adapters.PedidoAdapter
import alejandro.br.menu.Models.MenuViewModel
import alejandro.br.menu.Models.Pokos.MenuItem
import alejandro.br.menu.Models.Pokos.PedidoItem
import alejandro.br.menu.R
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.frag_pedido_card.view.*
import kotlinx.android.synthetic.main.fragment_trois.*


class FragmentTrois : Fragment(), View.OnClickListener {

    private lateinit var adapter: PedidoAdapter
    private lateinit var recyclerView: RecyclerView
    var listPedido: MutableList<PedidoItem>
    private lateinit var iconDelete :  Drawable
    private var  swipeBackgroud: ColorDrawable = ColorDrawable(Color.parseColor("#FF0000"))


    // Use the 'by activityViewModels()' Kotlin property delegate
    // from the fragment-ktx artifact
    private val menuViewModel: MenuViewModel by activityViewModels()

    init {
        listPedido = mutableListOf()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_trois, container, false)

        iconDelete=  ContextCompat.getDrawable(requireContext(), R.drawable.ic_delete)!!

       /* menuViewModel.pedidoItems.observe(viewLifecycleOwner, Observer {
            if (menuViewModel.pedidoItems.value != null) {
                for ((k, v) in menuViewModel.pedidoItems.value!!) {
                    var pedidoItem = PedidoItem(k.id, k.name, k.price, v, "delivered")
                    listPedido.add(pedidoItem)
                }
                calculateTotalPedido()
                fillPedido(root, listPedido)
            }
        })*/
        menuViewModel.contentOrder.observe(viewLifecycleOwner, Observer {
            if (menuViewModel.contentOrder.value != null) {
                // Update total
                menuViewModel.totalPedido.value =
                    menuViewModel.contentOrder.value!!.sumByDouble { it -> it.quantity * it.price }
                // Update recyclerView
                fillPedido(root, menuViewModel.contentOrder.value!!)
            }
        })


        menuViewModel.totalPedido.observe(viewLifecycleOwner, Observer {
            total.text = menuViewModel.totalPedido.value.toString()
        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_confirm.setOnClickListener {
            menuViewModel.saveOrder()
        }
    }

    // Function for set RecyclerView
    fun fillPedido(root: View, listPedido: MutableList<PedidoItem>) {
            recyclerView = root.findViewById(R.id.recycler_pedido)
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = PedidoAdapter(listPedido, this)
            recyclerView.adapter = adapter
            val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
            itemTouchHelper.attachToRecyclerView(recyclerView)
    }



    // Set swipe to delete
    val itemTouchHelperCallback = object :
        ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return false
        }

        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
            if (listPedido[viewHolder.adapterPosition].state.equals("delivered")){
                return 0
            }
            return super.getMovementFlags(recyclerView, viewHolder)
        }
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, position: Int) {
                var removedItem =  PedidoItem(
                    viewHolder.itemView.pedido_card.tag.toString(),
                    viewHolder.itemView.pedido_name.text.toString(),
                    viewHolder.itemView.pedido_price.text.toString().toDouble(),
                    viewHolder.itemView.pedido_quantity.text.toString().toLong(),
                      "delivered")
                var menuItem = MenuItem(
                viewHolder.itemView.pedido_card.tag.toString(),
                viewHolder.itemView.pedido_name.text.toString(),
                viewHolder.itemView.pedido_price.text.toString().toDouble()
                )
            adapter.removeItem(viewHolder as PedidoAdapter.ViewHolder, removedItem)
           // menuViewModel.pedidoItems.value?.remove(menuItem)
            calculateTotalPedido()
            }



        // Method to show red color and icon when deleting
        override fun onChildDraw(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            dX: Float,
            dY: Float,
            actionState: Int,
            isCurrentlyActive: Boolean
        ) {
            val itemView = viewHolder.itemView
            val iconMargin = (itemView.height - iconDelete!!.intrinsicHeight) /2
            if(dX>0){
                swipeBackgroud.setBounds(itemView.left, itemView.top, dX.toInt(), itemView.bottom)
                iconDelete.setBounds(itemView.left + iconMargin, itemView.top + iconMargin, itemView.left+iconMargin+  iconDelete.intrinsicWidth, itemView.bottom - iconMargin )
            }
            else{
                swipeBackgroud.setBounds(itemView.right+dX.toInt(), itemView.top, itemView.right, itemView.bottom)
                iconDelete.setBounds(itemView.right - iconMargin - iconDelete.intrinsicWidth, itemView.top + iconMargin, itemView.right - iconMargin , itemView.bottom - iconMargin )
            }
            swipeBackgroud.draw(c)
            iconDelete.draw(c)
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        }
    }

    // We do not need this function anymore, we do it in contentOrder.observe
    fun calculateTotalPedido(){
      //  menuViewModel.totalPedido.value = listPedido.sumByDouble { it -> it.quantity * it.price }
    }

    override fun onClick(p0: View?) {
    }
}