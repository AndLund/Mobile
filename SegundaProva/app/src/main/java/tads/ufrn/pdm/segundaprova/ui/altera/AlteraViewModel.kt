package tads.ufrn.pdm.segundaprova.ui.altera

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import tads.ufrn.pdm.segundaprova.database.AppDatabase
import tads.ufrn.pdm.segundaprova.model.Comida

@Suppress("DEPRECATION")
class AlteraViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var comida: Comida

    private var _eventAlteraComida = MutableLiveData<Boolean>(false)
    val eventAlteraComida:LiveData<Boolean>
        get() = _eventAlteraComida

    val db: AppDatabase by lazy {
        Room.databaseBuilder(application.applicationContext, AppDatabase::class.java,"database-name.sqlite").build()
    }

    fun atualizaCadastro(){
        atualizaBD(db, comida).execute().get()
        _eventAlteraComida.value = true
    }

    fun onAlteraComidaComplete(){
        _eventAlteraComida.value = false
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
    }
}