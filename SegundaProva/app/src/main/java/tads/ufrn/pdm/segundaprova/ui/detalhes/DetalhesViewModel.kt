package tads.ufrn.pdm.segundaprova.ui.detalhes

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import tads.ufrn.pdm.segundaprova.database.AppDatabase
import tads.ufrn.pdm.segundaprova.model.Comida

@Suppress("DEPRECATION")
class DetalhesViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var comida: Comida

    val db: AppDatabase by lazy {
//        Room.databaseBuilder(application.applicationContext,AppDatabase::class.java,"database-name.sqlite").allowMainThreadQueries().build()
        Room.databaseBuilder(application.applicationContext, AppDatabase::class.java,"database-name.sqlite").build()
    }


    @Suppress("DEPRECATION")
    private inner class listarComidaPorID(var db: AppDatabase, var id: Int) : AsyncTask<Void, Void, Comida>() {
        override fun doInBackground(vararg params: Void?): Comida? {
            return db.comidaDAO().findById(id)
        }
    }

    fun setComida(id:Int){
        comida = listarComidaPorID(db,id).execute().get()
    }


}