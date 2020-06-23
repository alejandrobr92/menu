package alejandro.br.menu.Fragments

import alejandro.br.menu.R
import alejandro.br.menu.data.FCategoriesAdapter
import alejandro.br.menu.model.CategoryMenu
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_categories.*

class FragmentUn() : Fragment(), FCategoriesAdapter.CategorytItemListener{

    private lateinit var adapter : FCategoriesAdapter
    private lateinit var recyclerView: RecyclerView
    //private lateinit var categoriesList : MutableList<CategoryMenu>

    private  var categoriesList : List<CategoryMenu> = listOf(CategoryMenu("Comida"),CategoryMenu( "Bebidas"),
            CategoryMenu("Postres"),CategoryMenu( "Veganos"),
            CategoryMenu("Cerveza"),CategoryMenu( "Ensaladas"))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =inflater.inflate(R.layout.fragment_un, container, false)

        recyclerView = view.findViewById(R.id.recycler_categories_new)
        recyclerView.layoutManager= LinearLayoutManager(context)




        //data

      /*  categoriesList.add(CategoryMenu("Comida"))
        categoriesList.add(CategoryMenu("Bebidas"))
        categoriesList.add(CategoryMenu("Ensaladas"))
        categoriesList.add(CategoryMenu("Postres"))
        categoriesList.add(CategoryMenu("Veganos"))
        categoriesList.add(CategoryMenu("Tradicionales"))
        categoriesList.add(CategoryMenu("Cerveza"))
        categoriesList.add(CategoryMenu("Licores"))
        categoriesList.add(CategoryMenu("Snacks"))
*/

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter= FCategoriesAdapter (categoriesList, this)
        recyclerView.adapter= adapter
    }






}