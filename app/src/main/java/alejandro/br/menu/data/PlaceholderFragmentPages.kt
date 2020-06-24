package alejandro.br.menu.data

import alejandro.br.menu.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders


/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragmentPages : Fragment() {

    private lateinit var pageViewModel: PageViewModel

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
                root = inflater.inflate(R.layout.frag_cat_postres, container, false)
                val textView: TextView = root.findViewById(R.id.section_label)
                pageViewModel.text.observe(viewLifecycleOwner, Observer<String> { textView.text = it })
                return root
            }

            2 -> {
                root = inflater.inflate(R.layout.frag_cat_bebidas, container, false)
                return root
            }

            3 -> {
                root = inflater.inflate(R.layout.frag_cat_postres, container, false)
                val textView: TextView = root.findViewById(R.id.section_label)
                pageViewModel.text.observe(viewLifecycleOwner, Observer<String> { textView.text = it })
                return root
            }
            4 -> {
                root = inflater.inflate(R.layout.frag_cat_postres, container, false)
                val textView: TextView = root.findViewById(R.id.section_label)
                pageViewModel.text.observe(viewLifecycleOwner, Observer<String> { textView.text = it })
                return root
            }
            else -> return  inflater.inflate(R.layout.frag_cat_postres, container, false)
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