package tads.ufrn.pdm.segundaprova.viewModel

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import tads.ufrn.pdm.segundaprova.BD.AppDatabase
import tads.ufrn.pdm.segundaprova.model.Comida

@Suppress("DEPRECATION")
class HomeFragmentViewModel(application: Application) : AndroidViewModel(application){
    var list: LiveData<List<Comida>>

    init{
        val db: AppDatabase by lazy {
            //Room.databaseBuilder(application.applicationContext,AppDatabase::class.java,"database-name.sqlite").allowMainThreadQueries().build()
            Room.databaseBuilder(application.applicationContext, AppDatabase::class.java,"database-name.sqlite").build()
        }
        list = listarComidas(db).execute().get()
    }

    @Suppress("DEPRECATION")
    private inner class listarComidas(var bd: AppDatabase) : AsyncTask<Void, Void, LiveData<List<Comida>>>() {
        override fun doInBackground(vararg params: Void?): LiveData<List<Comida>>? {
            return bd.comidaDAO().listAll()
        }
    }

}