package alejandro.br.menu.data

import alejandro.br.menu.R
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.lang.reflect.Array.newInstance

private val TAB_TITLES = arrayOf(R.string.tab_cat_un, R.string.tab_cat_deux, R.string.tab_cat_trois, R.string.tab_cat_quatre)


class ViewPagerAdapter (private val context : Context, fm : FragmentManager) :  FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragmentPages.newInstance(position + 1)
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

}