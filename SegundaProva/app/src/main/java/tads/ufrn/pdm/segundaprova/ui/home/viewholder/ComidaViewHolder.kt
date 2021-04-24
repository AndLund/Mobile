package tads.ufrn.pdm.segundaprova.ui.home.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tads.ufrn.pdm.segundaprova.R
import tads.ufrn.pdm.segundaprova.model.Comida

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