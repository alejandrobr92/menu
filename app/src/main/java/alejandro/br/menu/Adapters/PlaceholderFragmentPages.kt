package alejandro.br.menu.Adapters

import alejandro.br.menu.Models.MenuViewModel
import alejandro.br.menu.R
import alejandro.br.menu.Models.PageViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragmentPages : Fragment() {

    private lateinit var pageViewModel: PageViewModel

    private lateinit var adapter : MenuItemAdapter
    private lateinit var recyclerView: RecyclerView
    private val menuViewModel  = MenuViewModel()


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
                val menu = menuViewModel.getMenuItems()
                root = inflater.inflate(R.layout.frag_cat_postres, container, false)
                recyclerView = root.findViewById(R.id.recycler_cat_postres)
                recyclerView.layoutManager= LinearLayoutManager(context)
                adapter= MenuItemAdapter(menu)
                recyclerView.adapter= adapter
                return root
            }

            2 -> {
                root = inflater.inflate(R.layout.frag_cat_bebidas, container, false)
                return root
            }

            3 -> {
                root = inflater.inflate(R.layout.frag_cat_bebidas, container, false)
              //  val textView: TextView = root.findViewById(R.id.section_label)
             //   pageViewModel.text.observe(viewLifecycleOwner, Observer<String> { textView.text = it })
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
}