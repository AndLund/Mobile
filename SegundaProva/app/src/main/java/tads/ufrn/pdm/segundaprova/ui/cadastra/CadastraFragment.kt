package tads.ufrn.pdm.segundaprova.ui.cadastra

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import tads.ufrn.pdm.segundaprova.ui.dialogs.CadastraDialogFragment
import tads.ufrn.pdm.segundaprova.R
import tads.ufrn.pdm.segundaprova.databinding.CadastraFragmentBinding
import tads.ufrn.pdm.segundaprova.ui.altera.AlteraFragmentDirections

//import tads.ufrn.pdm.segundaprova.fragment.CadastraFragmentDirections

class CadastraFragment : Fragment() {

    lateinit var cadastraViewModel: CadastraViewModel
    lateinit var binding: CadastraFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.cadastra_fragment, container,false)
        cadastraViewModel = ViewModelProvider(this).get(CadastraViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewmodelcadastra = cadastraViewModel

        setHasOptionsMenu(true)

        cadastraViewModel.eventCadastraComida.observe(viewLifecycleOwner, { hasChanged ->
            if(hasChanged){
                var action = CadastraFragmentDirections.actionCadastraFragmentToHomeFragment()
                Navigation.findNavController(requireView()).navigate(action)
                cadastraViewModel.onCadastraComidaComplete()
            }
        })

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.option_menu){
            var dialog = CadastraDialogFragment()
            dialog.show(requireActivity().supportFragmentManager,"Ajuda Home")
        }
        return NavigationUI.onNavDestinationSelected(item,
            Navigation.findNavController(requireView()))
                || super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.nav_option_menu_ajuda, menu)
    }
}