package tads.ufrn.pdm.segundaprova.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import tads.ufrn.pdm.segundaprova.BD.AppDatabase
import tads.ufrn.pdm.segundaprova.model.Comida

class CadastraViewModel(application: Application) : AndroidViewModel(application) {
    var nome = ""
    var descricao = ""
    var criador = ""
    var restaurante = ""
    var regiao = ""
    var avaliacao = 0.0f

    val db: AppDatabase by lazy {
        Room.databaseBuilder(application.applicationContext, AppDatabase::class.java,"database-name.sqlite").allowMainThreadQueries().build()
    }

    fun cadastra(){
        val comida = Comida(0,nome,descricao,criador,restaurante,regiao,avaliacao)
        db.comidaDAO().insert(comida)
    }
}


