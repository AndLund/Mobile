package tads.ufrn.pdm.segundaprova.viewModel

import android.app.Application
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import tads.ufrn.pdm.segundaprova.BD.AppDatabase
import tads.ufrn.pdm.segundaprova.model.Comida

@Suppress("DEPRECATION")
class AlteraViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var comida: Comida
    var nome = ""
    var descricao = ""
    var criador = ""
    var restaurante = ""
    var regiao = ""
    var avaliacao = 0.0F

    val db: AppDatabase by lazy {
        Room.databaseBuilder(application.applicationContext, AppDatabase::class.java,"database-name.sqlite").build()
    }

//    init{
//        comida = listarComidaPorID(db,1).execute().get()
//        descricao = comida.descricao
//        criador = comida.criador
//        restaurante = comida.restaurante
//        regiao = comida.regiao
//        avaliacao = comida.avaliacao
//    }

    fun atualizaCadastro(){
        atualizaBD(db, comida).execute().get()
    }

    @Suppress("DEPRECATION")
    private inner class atualizaBD(var db: AppDatabase, var comida: Comida) : AsyncTask<Void, Void, Int>() {
        override fun doInBackground(vararg params: Void?): Int {
            return db.comidaDAO().update(comida)
        }
    }

    @Suppress("DEPRECATION")
    private inner class listarComidaPorID(var db: AppDatabase, var id: Int) : AsyncTask<Void, Void, Comida>() {
        override fun doInBackground(vararg params: Void?): Comida? {
            return db.comidaDAO().findById(id)
        }
    }

    fun setComidaAt(id:Int){
        comida = listarComidaPorID(db,id).execute().get()
        nome = comida.nomeComida
        descricao = comida.descricao
        criador = comida.criador
        restaurante = comida.restaurante
        regiao = comida.regiao
        avaliacao = comida.avaliacao
    }
}