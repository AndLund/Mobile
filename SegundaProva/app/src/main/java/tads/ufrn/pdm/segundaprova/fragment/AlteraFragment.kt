package tads.ufrn.pdm.segundaprova.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import tads.ufrn.pdm.segundaprova.dialog.AlteraDialogFragment
import tads.ufrn.pdm.segundaprova.viewModel.AlteraViewModel
import tads.ufrn.pdm.segundaprova.R
import tads.ufrn.pdm.segundaprova.databinding.FragmentAlteraBinding



class AlteraFragment : Fragment() {

    lateinit var alteraViewModel: AlteraViewModel
    lateinit var binding: FragmentAlteraBinding

    val args: AlteraFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container,false)
        alteraViewModel = ViewModelProvider(this).get(AlteraViewModel::class.java)

        alteraViewModel.setComidaAt(args.id)

        binding.lifecycleOwner = this
        binding.viewmodelaltera = alteraViewModel

        binding.confirmaButton.setOnClickListener(){
            this.alteraViewModel.atualizaCadastro()
            var action = AlteraFragmentDirections.actionAlteraFragmentToHomeFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.option_menu){
            var dialog = AlteraDialogFragment()
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