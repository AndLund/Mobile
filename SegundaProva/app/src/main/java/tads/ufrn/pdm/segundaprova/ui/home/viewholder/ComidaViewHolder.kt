package tads.ufrn.pdm.segundaprova.ui.home.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tads.ufrn.pdm.segundaprova.R

class ComidaViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val textViewNomeComida: TextView
    init {
        textViewNomeComida = v.findViewById(R.id.nomeComidaTextView)
    }
}