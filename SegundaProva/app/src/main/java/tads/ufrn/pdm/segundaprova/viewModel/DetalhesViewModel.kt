package tads.ufrn.pdm.segundaprova.viewModel

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import tads.ufrn.pdm.segundaprova.BD.AppDatabase
import tads.ufrn.pdm.segundaprova.model.Comida

@Suppress("DEPRECATION")
class DetalhesViewModel(application: Application) : AndroidViewModel(application) {
    var nome = ""
    var descricao = ""
    var criador = ""
    var restaurante = ""
    var regiao = ""
    var avaliacao = 0.0F

    val db: AppDatabase by lazy {
//        Room.databaseBuilder(application.applicationContext,AppDatabase::class.java,"database-name.sqlite").allowMainThreadQueries().build()
        Room.databaseBuilder(application.applicationContext, AppDatabase::class.java,"database-name.sqlite").build()
    }

//    init{
//        comida = listarComidaPorID(db,1).execute().get()
//        nome = comida.nomeComida
//        descricao = comida.descricao
//        criador = comida.criador
//        restaurante = comida.restaurante
//        regiao = comida.regiao
//        avaliacao = comida.avaliacao
//    }

    @Suppress("DEPRECATION")
    private inner class listarComidaPorID(var db: AppDatabase, var id: Int) : AsyncTask<Void, Void, Comida>() {
        override fun doInBackground(vararg params: Void?): Comida? {
            return db.comidaDAO().findById(id)
        }
    }

    fun setComida(id:Int){
        //var comida = db.comidaDAO().findById(id)
        var comida = listarComidaPorID(db,id).execute().get()
        nome = comida.nomeComida
        descricao = comida.descricao
        criador = comida.criador
        restaurante = comida.restaurante
        regiao = comida.regiao
        avaliacao = comida.avaliacao
    }


}