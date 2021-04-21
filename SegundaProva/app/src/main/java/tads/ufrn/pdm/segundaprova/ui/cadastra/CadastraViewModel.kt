package tads.ufrn.pdm.segundaprova.ui.cadastra

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import tads.ufrn.pdm.segundaprova.database.AppDatabase
import tads.ufrn.pdm.segundaprova.model.Comida

class CadastraViewModel(application: Application) : AndroidViewModel(application) {
    var comida:Comida = Comida()

    private var _eventCadastraComida = MutableLiveData<Boolean>(false)
    val eventCadastraComida:LiveData<Boolean>
        get() = _eventCadastraComida

    val db: AppDatabase by lazy {
        Room.databaseBuilder(application.applicationContext, AppDatabase::class.java,"database-name.sqlite").allowMainThreadQueries().build()
    }

    fun cadastra(){
        db.comidaDAO().insert(comida)
        _eventCadastraComida.value = true
    }

    fun onCadastraComidaComplete(){
        _eventCadastraComida.value = false
    }
}


