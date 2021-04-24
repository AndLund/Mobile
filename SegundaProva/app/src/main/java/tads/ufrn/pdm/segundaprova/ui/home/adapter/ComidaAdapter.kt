package tads.ufrn.pdm.segundaprova.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tads.ufrn.pdm.segundaprova.R
import tads.ufrn.pdm.segundaprova.model.Comida

class ComidaAdapter: ListAdapter<Comida, ComidaAdapter.ComidaViewHolder>(ComidaDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidaViewHolder {
        return ComidaViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ComidaViewHolder, position: Int) {
        val comidaescolhida = getItem(position)
        holder.bind(comidaescolhida)
    }

    class ComidaViewHolder private constructor(v: View) : RecyclerView.ViewHolder(v) {
        val textViewNomeComida: TextView
        init {
            textViewNomeComida = v.findViewById(R.id.nomeComidaTextView)
        }

        fun bind(comidaescolhida: Comida) {
            textViewNomeComida.text = comidaescolhida.nomeComida
            //img.setImageResource(comidaescolhida.img)
        }

        companion object {
            fun from(parent: ViewGroup): ComidaViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.comida_inflater, parent, false)
                return ComidaViewHolder(view)
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