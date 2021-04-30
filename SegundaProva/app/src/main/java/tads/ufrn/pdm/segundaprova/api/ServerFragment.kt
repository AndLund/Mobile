package tads.ufrn.pdm.segundaprova.api

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tads.ufrn.pdm.segundaprova.R
import tads.ufrn.pdm.segundaprova.SegundaProvaApplication
import tads.ufrn.pdm.segundaprova.databinding.FragmentHomeBinding
import tads.ufrn.pdm.segundaprova.databinding.FragmentServerBinding
import tads.ufrn.pdm.segundaprova.model.Comida2
import tads.ufrn.pdm.segundaprova.ui.home.HomeFragmentDirections
import tads.ufrn.pdm.segundaprova.ui.home.HomeFragmentViewModel
import tads.ufrn.pdm.segundaprova.ui.home.adapter.ComidaAdapter
import tads.ufrn.pdm.segundaprova.util.ComidaRecyclerViewClickListener

class ServerFragment : Fragment() {
    lateinit var binding: FragmentServerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_server, container,false)

        getData()
        return binding.root
    }


    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("http://10.0.2.2:8080")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPosts()

        callback.enqueue(object : Callback<List<Comida2>> {
            override fun onFailure(call: Call<List<Comida2>>, t: Throwable) {
                Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Comida2>>, response: Response<List<Comida2>>) {
                response.body()?.forEach {
                    binding.serverTextView.text = binding.serverTextView.text.toString().plus(it.nomeComida+"\n\n")
                }
            }
        })

    }
}