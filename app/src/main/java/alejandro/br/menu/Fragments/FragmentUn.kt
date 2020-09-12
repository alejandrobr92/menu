package alejandro.br.menu.Fragments

import alejandro.br.menu.R
import alejandro.br.menu.Adapters.FCategoriesAdapter
import alejandro.br.menu.Models.Pokos.Category
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentUn() : Fragment(), FCategoriesAdapter.CategorytItemListener{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =inflater.inflate(R.layout.fragment_un, container, false)

        return view
    }

}