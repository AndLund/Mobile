package tads.ufrn.pdm.segundaprova

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComidaViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val textViewNomeComida: TextView
    init {
        textViewNomeComida = v.findViewById(R.id.nomeComidaTextView)
    }
}