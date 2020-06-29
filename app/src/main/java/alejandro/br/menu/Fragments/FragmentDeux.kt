package alejandro.br.menu.Fragments

import alejandro.br.menu.R
import alejandro.br.menu.Adapters.ViewPagerAdapter
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class FragmentDeux : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val view = inflater.inflate(R.layout.fragment_deux, container, false)

        val sectionsPagerAdapter = context?.let { ViewPagerAdapter(it, childFragmentManager) }
        val viewPager: ViewPager = view.findViewById( R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = view.findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        tabs.getTabAt(0)!!.select()

        return view
    }

}