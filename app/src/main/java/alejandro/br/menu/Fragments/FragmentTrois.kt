package alejandro.br.menu.Fragments

import alejandro.br.menu.Adapters.MenuItemAdapter
import alejandro.br.menu.Adapters.PedidoAdapter
import alejandro.br.menu.Models.MenuViewModel
import alejandro.br.menu.Models.PedidoItem
import alejandro.br.menu.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_trois.*


class FragmentTrois : Fragment(), View.OnClickListener{

    private lateinit var adapter : PedidoAdapter
    private lateinit var recyclerView: RecyclerView
    var listPedido : MutableList<PedidoItem>

    // Use the 'by activityViewModels()' Kotlin property delegate
    // from the fragment-ktx artifact
    private val menuViewModel: MenuViewModel by activityViewModels()
    init {
        listPedido = mutableListOf()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_trois, container, false)

        Log.e("PEDIDO",menuViewModel.pedidoItems.value.toString())
        Log.e("FragmentTrois", "Called ViewModelProviders.of")

        menuViewModel.pedidoItems.observe(viewLifecycleOwner, Observer {
            if( menuViewModel.pedidoItems.value != null) {
                for ((k, v) in menuViewModel.pedidoItems.value!!) {
                    println("value of $k is $v")
                    var pedidoItem = PedidoItem(k.name, k.price, v)
                    listPedido.add(pedidoItem)
                }
                fillPedido(root, listPedido)
            }
        })


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    fun fillPedido(root: View, listPedido: List<PedidoItem>){
            menuViewModel.pedidoItems.observe(viewLifecycleOwner, Observer {
            recyclerView = root.findViewById(R.id.recycler_pedido)
            recyclerView.layoutManager= LinearLayoutManager(context)
            adapter= PedidoAdapter(listPedido, this)
            recyclerView.adapter= adapter
        })
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}