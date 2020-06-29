package alejandro.br.menu.Adapters

import alejandro.br.menu.Models.MenuViewModel
import alejandro.br.menu.R
import alejandro.br.menu.Models.PageViewModel
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.frag_cat_postres_card.*


/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragmentPages : Fragment(), View.OnClickListener {

    private lateinit var pageViewModel: PageViewModel
    private lateinit var adapter : MenuItemAdapter
    private lateinit var recyclerView: RecyclerView
//    private lateinit var menuViewModel  : MenuViewModel

    private val menuViewModel: MenuViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        lateinit var root: View
      //  menuViewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)


        when (arguments?.getInt(ARG_SECTION_NUMBER)) {
            1 -> {

                root = inflater.inflate(R.layout.frag_cat_postres, container, false)
                menuViewModel.menuItems.observe(viewLifecycleOwner, Observer {

                   var menuFiltered = it.filter { it.category.equals("bebidas") }
                    recyclerView = root.findViewById(R.id.recycler_cat_postres)
                    recyclerView.layoutManager= LinearLayoutManager(context)
                    adapter= MenuItemAdapter(menuFiltered, this)
                    recyclerView.adapter= adapter

                 })


                return root

            }

            2 -> {
                root = inflater.inflate(R.layout.frag_cat_bebidas, container, false)
                return root
            }

            3 -> {
                root = inflater.inflate(R.layout.frag_cat_bebidas, container, false)
                return root

            }
            4 -> {
               root = inflater.inflate(R.layout.frag_cat_bebidas, container, false)
                return root

            }

            else -> return  inflater.inflate(R.layout.frag_cat_bebidas, container, false)
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragmentPages {
            return PlaceholderFragmentPages().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onClick(view: View) {
        view.findViewById<CardView>(R.id.menu_item_card)?.setOnClickListener{
            menuViewModel.pedidoItems.value!!.put(view.findViewById<TextView>(R.id.menu_item_name).text.toString(), 2)
            Log.e("PEDIDO",menuViewModel.pedidoItems.value.toString())
        }

    }
}