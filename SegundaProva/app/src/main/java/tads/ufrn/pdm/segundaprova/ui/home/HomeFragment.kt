package tads.ufrn.pdm.segundaprova.ui.home

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tads.ufrn.pdm.segundaprova.*
import tads.ufrn.pdm.segundaprova.api.Endpoint
import tads.ufrn.pdm.segundaprova.api.NetworkUtils
import tads.ufrn.pdm.segundaprova.ui.home.adapter.ComidaAdapter
import tads.ufrn.pdm.segundaprova.databinding.FragmentHomeBinding
import tads.ufrn.pdm.segundaprova.model.Comida2
import tads.ufrn.pdm.segundaprova.ui.dialogs.HomeDialogFragment
import tads.ufrn.pdm.segundaprova.util.ComidaRecyclerViewClickListener


class HomeFragment : Fragment() {
    lateinit var homeFragmentViewModel: HomeFragmentViewModel
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container,false)
        val viewModelFactory = HomeFragmentViewModel.Factory((requireActivity().application as SegundaProvaApplication).repository)
        homeFragmentViewModel = ViewModelProvider(this, viewModelFactory).get(HomeFragmentViewModel::class.java)

        val adapter = ComidaAdapter()
        binding.recyclerviewHomeFragment.adapter = adapter

        homeFragmentViewModel.list.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerviewHomeFragment.layoutManager = layout

        val rv = binding.recyclerviewHomeFragment
        rv.addOnItemTouchListener(
            ComidaRecyclerViewClickListener(requireContext(), rv,
            object : ComidaRecyclerViewClickListener.OnItemClickListener {
                override fun onItemClick(v: View, position: Int) {
                    val action = HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(adapter.currentList[position].id)
                    Navigation.findNavController(rv).navigate(action)
                }

                override fun onItemLongClick(v: View, position: Int) {
                    val action = HomeFragmentDirections.actionHomeFragmentToAlteraFragment(adapter.currentList[position].id)
                    Navigation.findNavController(rv).navigate(action)
                }
            })
        )

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.option_menu){
            var dialog = HomeDialogFragment()
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