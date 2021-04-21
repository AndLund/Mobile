package tads.ufrn.pdm.segundaprova.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tads.ufrn.pdm.segundaprova.model.Comida
import tads.ufrn.pdm.segundaprova.ui.home.viewholder.ComidaViewHolder
import tads.ufrn.pdm.segundaprova.R

class ComidaAdapter(/*var c: Context, var comidas:List<Comida>*/): RecyclerView.Adapter<ComidaViewHolder>() {
    var comidas: List<Comida> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComidaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comida_inflater, parent, false)
        return ComidaViewHolder(view)
    }
    override fun getItemCount(): Int {
        return comidas.size
    }
    override fun onBindViewHolder(holder: ComidaViewHolder, position: Int) {
        val comidaescolhida = comidas[position]
        holder.textViewNomeComida.text = comidaescolhida.nomeComida
        //holder.img.setImageResource(comidaescolhida.img)
    }

}