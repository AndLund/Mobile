package tads.ufrn.pdm.segundaprova.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import tads.ufrn.pdm.segundaprova.*
import tads.ufrn.pdm.segundaprova.adapter.ComidaAdapter
import tads.ufrn.pdm.segundaprova.databinding.FragmentHomeBinding
import tads.ufrn.pdm.segundaprova.dialog.HomeDialogFragment
import tads.ufrn.pdm.segundaprova.viewModel.HomeFragmentViewModel


class HomeFragment : Fragment() {
    lateinit var homeFragmentViewModel: HomeFragmentViewModel
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container,false)
        homeFragmentViewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        val adapter = ComidaAdapter()
        binding.recyclerviewHomeFragment.adapter = adapter

        homeFragmentViewModel.list.observe(viewLifecycleOwner, Observer {
            adapter.comidas = it
            //Log.i("aaaa", it.toString())
            adapter.notifyDataSetChanged()
        })

        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerviewHomeFragment.layoutManager = layout

        val rv = binding.recyclerviewHomeFragment
        rv.addOnItemTouchListener(
            ComidaRecyclerViewClickListener(requireContext(), rv,
            object : ComidaRecyclerViewClickListener.OnItemClickListener {
                override fun onItemClick(v: View, position: Int) {
                    val action = HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(position+1)
                    Navigation.findNavController(rv).navigate(action)
                }

                override fun onItemLongClick(v: View, position: Int) {
                    val action = HomeFragmentDirections.actionHomeFragmentToAlteraFragment(position+1)
                    Navigation.findNavController(rv).navigate(action)
                    //Navigation.findNavController(rv).navigate(R.id.alteraFragment)
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