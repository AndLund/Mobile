package tads.ufrn.pdm.segundaprova.ui.home.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("BindingUtilsTV")
fun TextView.NotaDaComida(nota: Float?){
    nota?.let{
        text = it.toString()+"☺"
    }
}