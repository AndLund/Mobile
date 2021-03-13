package tads.ufrn.pdm.minhaprova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import tads.ufrn.pdm.minhaprova.databinding.ActivityAcao2Binding
import tads.ufrn.pdm.minhaprova.databinding.ActivityAcao3Binding

class ActivityAcao3 : AppCompatActivity() {

    lateinit var binding: ActivityAcao3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_acao3)

        val db = LivroDBOpener(this)
        var idChange = 1
        var livros = db.findAll()
        /*
        livros.forEach {
            Log.i("minhaprova", it.toString())
        }
         */
        if(idChange > 1){
            binding.anteriorButton.isEnabled = false
        }


        binding.apply {
            var livro = db.findById(idChange)
            tituloTextView.text = "Titulo: ${livro.nome}"
            autorTextView.text = "Autor: ${livro.autor}"
            anoTextView.text = "Ano: ${livro.ano}"
            notaTextView.text = "Nota: ${livro.nota}"
        }

        binding.anteriorButton.setOnClickListener() {

            if(idChange > 1){
                binding.proximoButton.isEnabled = true
            }

            var livro = db.findById(--idChange)
            binding.apply {
                tituloTextView.text = "Titulo: ${livro.nome}"
                autorTextView.text = "Autor: ${livro.autor}"
                anoTextView.text = "Ano: ${livro.ano}"
                notaTextView.text = "Nota: ${livro.nota}"
            }
            if(idChange == 1){
                binding.anteriorButton.isEnabled = false
            }
        }

        binding.proximoButton.setOnClickListener() {
            var livro = db.findById(++idChange)
            binding.apply {
                tituloTextView.text = "Titulo: ${livro.nome}"
                autorTextView.text = "Autor: ${livro.autor}"
                anoTextView.text = "Ano: ${livro.ano}"
                notaTextView.text = "Nota: ${livro.nota}"
            }

            if(idChange == livros.size){
                binding.proximoButton.isEnabled = false
            }

            if(idChange>1){
                binding.anteriorButton.isEnabled = true
            }
        }
    }
}