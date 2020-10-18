package alejandro.br.menu.Adapters

import alejandro.br.menu.Models.MenuViewModel
import alejandro.br.menu.Models.PageViewModel
import alejandro.br.menu.Models.Pokos.MenuItem
import alejandro.br.menu.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.frag_menu_item_card.view.*


/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragmentPages : Fragment(), View.OnClickListener {

    private lateinit var pageViewModel: PageViewModel
    private lateinit var adapter : MenuItemAdapter
    private lateinit var recyclerView: RecyclerView

    private val menuViewModel: MenuViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        lateinit var root: View
        when (arguments?.getInt(ARG_SECTION_NUMBER)) {
            1 -> {
                root = inflater.inflate(R.layout.frag_category, container, false)
                fillCategory(root, getString(R.string.tab_cat_un))
                return root
            }
            2 -> {
                root = inflater.inflate(R.layout.frag_category, container, false)
                fillCategory(root,  getString(R.string.tab_cat_deux))
                return root
            }
            3 -> {
                root = inflater.inflate(R.layout.frag_category, container, false)
                fillCategory(root, getString(R.string.tab_cat_trois))
                return root
            }
            4 -> {
               root = inflater.inflate(R.layout.frag_category, container, false)
                fillCategory(root,getString(R.string.tab_cat_quatre))
                return root
            }
            else -> return  inflater.inflate(R.layout.frag_category, container, false)
        }
    }

    companion object {

        // * The fragment argument representing the section number for this fragment.

        private const val ARG_SECTION_NUMBER = "section_number"

        // * Returns a new instance of this fragment for the given section number.
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragmentPages {
            return PlaceholderFragmentPages().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    // Logic for filling the RecyvlerView for each category
    fun fillCategory(root: View, category: String){
        menuViewModel.menuItems.observe(viewLifecycleOwner, Observer {
            var menuFiltered = it.filter { it.category.equals(category) }
            recyclerView = root.findViewById(R.id.recycler_category)
            recyclerView.layoutManager= LinearLayoutManager(context)
            adapter= MenuItemAdapter(menuFiltered, this, menuViewModel)
            recyclerView.adapter= adapter
        })
    }

    // Listener to add item to pedido
   override fun onClick(view: View) {

        /*    val name= menuViewModel.menuItems.value!!.filter { mi -> mi.id==view.tag }.toList().get(0).name
            val price= menuViewModel.menuItems.value!!.filter { mi -> mi.id==view.tag }.toList().get(0).price
            val quantity = view.rootView.counter.text.toString().toInt()
            var pedidoItem = MenuItem(
                view.tag as String,
                name,
                price
            )

            if(!menuViewModel.pedidoItems.value!!.isEmpty()){

                if (!menuViewModel.pedidoItems.value!!.contains(pedidoItem)) {
                    menuViewModel.pedidoItems.value!!.put(pedidoItem, quantity)
                }
                else  {
                    var oldValue = menuViewModel.pedidoItems.value!!.get(pedidoItem)!!
                    menuViewModel.pedidoItems.value!!.put(pedidoItem, oldValue+quantity)
                }
            }
            else{
                menuViewModel.pedidoItems.value!!.put(pedidoItem, quantity)

            }
        Log.e("PedidoItems", menuViewModel.pedidoItems.value.toString())
        */
    }

}