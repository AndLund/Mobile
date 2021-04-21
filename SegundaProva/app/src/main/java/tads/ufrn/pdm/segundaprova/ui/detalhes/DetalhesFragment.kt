package tads.ufrn.pdm.segundaprova.ui.detalhes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import tads.ufrn.pdm.segundaprova.ui.dialogs.DetalhesDialogFragment
import tads.ufrn.pdm.segundaprova.R
import tads.ufrn.pdm.segundaprova.databinding.DetalhesFragmentBinding
//import tads.ufrn.pdm.segundaprova.fragment.DetalhesFragmentArgs

class DetalhesFragment : Fragment() {
    lateinit var detalhesViewModel: DetalhesViewModel
    lateinit var binding: DetalhesFragmentBinding

    val args: DetalhesFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.detalhes_fragment, container,false)
        detalhesViewModel = ViewModelProvider(this).get(DetalhesViewModel::class.java)

        detalhesViewModel.setComida(args.id)

        binding.lifecycleOwner = this
        binding.viewmodeldetalhes = detalhesViewModel
        binding

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.option_menu){
            var dialog = DetalhesDialogFragment()
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