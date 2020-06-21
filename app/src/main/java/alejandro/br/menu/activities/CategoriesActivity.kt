package alejandro.br.menu.activities

import alejandro.br.menu.R
import alejandro.br.menu.data.CategoriesMenuAdapter
import alejandro.br.menu.model.CategoryMenu
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_categories.*

class CategoriesActivity : AppCompatActivity() {

    private var adapter : CategoriesMenuAdapter? = null
    private var categoriesList : ArrayList<CategoryMenu>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        categoriesList = ArrayList<CategoryMenu>()
        layoutManager =  LinearLayoutManager(this)
        adapter = CategoriesMenuAdapter(categoriesList!!,this )


        recycler_categories.layoutManager= layoutManager
        recycler_categories.adapter= adapter

        //data
        categoriesList!!.add(CategoryMenu("Comida"))
        categoriesList!!.add(CategoryMenu("Bebidas"))
        categoriesList!!.add(CategoryMenu("Ensaladas"))
        categoriesList!!.add(CategoryMenu("Postres"))
        categoriesList!!.add(CategoryMenu("Veganos"))
        categoriesList!!.add(CategoryMenu("Tradicionales"))
        categoriesList!!.add(CategoryMenu("Cerveza"))
        categoriesList!!.add(CategoryMenu("Licores"))
        categoriesList!!.add(CategoryMenu("Snacks"))

        adapter!!.notifyDataSetChanged()

    }
}