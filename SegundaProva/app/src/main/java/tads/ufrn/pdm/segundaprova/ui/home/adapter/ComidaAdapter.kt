package tads.ufrn.pdm.segundaprova.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tads.ufrn.pdm.segundaprova.R
import tads.ufrn.pdm.segundaprova.databinding.ComidaInflaterBinding
import tads.ufrn.pdm.segundaprova.model.Comida

class ComidaAdapter : ListAdapter<Comida, ComidaAdapter.ComidaViewHolder>(ComidaDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidaViewHolder {
        return ComidaViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ComidaViewHolder, position: Int) {
        val comidaescolhida = getItem(position)
        holder.bind(comidaescolhida)
    }

    class ComidaViewHolder private constructor(val binding: ComidaInflaterBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(comidaescolhida: Comida) {
            binding.comida = comidaescolhida
        }

        companion object {
            fun from(parent: ViewGroup): ComidaViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding:ComidaInflaterBinding = DataBindingUtil.inflate(inflater,R.layout.comida_inflater,parent,false)
                return ComidaViewHolder(binding)
            }
        }
    }
}

class ComidaDiffCallBack : DiffUtil.ItemCallback<Comida>(){
    override fun areItemsTheSame(oldItem: Comida, newItem: Comida): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Comida, newItem: Comida): Boolean {
        return oldItem.equals(newItem)
    }
}