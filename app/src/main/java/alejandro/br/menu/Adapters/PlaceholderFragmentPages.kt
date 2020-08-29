package alejandro.br.menu.Adapters

import alejandro.br.menu.Models.MenuItem
import alejandro.br.menu.Models.MenuViewModel
import alejandro.br.menu.R
import alejandro.br.menu.Models.PageViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


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
            adapter= MenuItemAdapter(menuFiltered, this)
            recyclerView.adapter= adapter
        })
    }



    // Listener to add item to pedido
   override fun onClick(view: View) {

            val name= menuViewModel.menuItems.value!!.filter { mi -> mi.id==view.tag }.toList().get(0).name
            val price= menuViewModel.menuItems.value!!.filter { mi -> mi.id==view.tag }.toList().get(0).price
            var pedidoItem = MenuItem(view.tag as String,name, price)

            if(!menuViewModel.pedidoItems.value!!.isEmpty()){

                if (!menuViewModel.pedidoItems.value!!.contains(pedidoItem)) {
                    menuViewModel.pedidoItems.value!!.put(pedidoItem, 1)
                }
                else  {
                    var oldValue = menuViewModel.pedidoItems.value!!.get(pedidoItem)!!
                    menuViewModel.pedidoItems.value!!.put(pedidoItem, oldValue+1)
                    Log.e("PEDIDO", menuViewModel.pedidoItems.value.toString())
                }
            }
            else{
                menuViewModel.pedidoItems.value!!.put(pedidoItem, 1)

            }
        Log.e("PedidoItems", menuViewModel.pedidoItems.value.toString())

    }

}