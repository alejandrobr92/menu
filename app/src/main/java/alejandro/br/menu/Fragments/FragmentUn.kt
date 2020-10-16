package alejandro.br.menu.Fragments

import alejandro.br.menu.R
import alejandro.br.menu.Adapters.FCategoriesAdapter
import alejandro.br.menu.Models.Pokos.Category
import alejandro.br.menu.activities.PromotionsActivity
import alejandro.br.menu.activities.RecommendationsActivity
import alejandro.br.menu.activities.SelectRestActivity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_un.*

class FragmentUn() : Fragment(), FCategoriesAdapter.CategorytItemListener{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view =inflater.inflate(R.layout.fragment_un, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layout_promotions.setOnClickListener{
            val intent = Intent(context, PromotionsActivity::class.java)
            this.startActivity(intent)
        }

        layout_recomm.setOnClickListener{
            val intent = Intent(context, RecommendationsActivity::class.java)
            this.startActivity(intent)
        }


    }
}