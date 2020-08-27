package alejandro.br.menu.Fragments

import alejandro.br.menu.R
import alejandro.br.menu.Adapters.FCategoriesAdapter
import alejandro.br.menu.Models.CategoryMenu
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentUn() : Fragment(), FCategoriesAdapter.CategorytItemListener{

    private lateinit var adapter : FCategoriesAdapter
    private lateinit var recyclerView: RecyclerView
    //private lateinit var categoriesList : MutableList<CategoryMenu>

    private  var categoriesList : List<CategoryMenu> = listOf(
        CategoryMenu("Comida"),
        CategoryMenu("Bebidas"),
        CategoryMenu("Postres"),
        CategoryMenu("Veganos"),
        CategoryMenu("Cerveza"),
        CategoryMenu("Ensaladas")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =inflater.inflate(R.layout.fragment_un, container, false)

        recyclerView = view.findViewById(R.id.recycler_categories_new)
        recyclerView.layoutManager= LinearLayoutManager(context)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter= FCategoriesAdapter(categoriesList, this)
        recyclerView.adapter= adapter

    }


}