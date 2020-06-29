package alejandro.br.menu.Fragments

import alejandro.br.menu.Models.MenuViewModel
import alejandro.br.menu.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_trois.*


class FragmentTrois : Fragment(){

    // Use the 'by activityViewModels()' Kotlin property delegate
    // from the fragment-ktx artifact
    private val menuViewModel: MenuViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_trois, container, false)

        Log.e("PEDIDO",menuViewModel.pedidoItems.value.toString())
        Log.e("FragmentTrois", "Called ViewModelProviders.of")

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuViewModel.pedidoItems.observe(viewLifecycleOwner, Observer {
            itempedido.text= it.get("cerveza")?.toString() ?: "No hay pedido"
            itempedido2.text = menuViewModel.pedidoItems.value?.get("cerveza")?.toString() ?: "0"
        })

    }
}