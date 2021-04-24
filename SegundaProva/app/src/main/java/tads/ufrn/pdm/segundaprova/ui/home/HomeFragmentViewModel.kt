package tads.ufrn.pdm.segundaprova.ui.home

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.*
import androidx.room.Room
import tads.ufrn.pdm.segundaprova.database.AppDatabase
import tads.ufrn.pdm.segundaprova.database.ComidaRepository
import tads.ufrn.pdm.segundaprova.model.Comida
import java.lang.IllegalArgumentException

@Suppress("DEPRECATION")
class HomeFragmentViewModel private constructor(repositorio: ComidaRepository) : ViewModel(){
    var list: LiveData<List<Comida>> = repositorio.listAll.asLiveData()

    class Factory(val repositorio: ComidaRepository): ViewModelProvider.Factory{
        override fun <T: ViewModel?> create(modelClass: Class<T>):T{
            if(modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)){
                return HomeFragmentViewModel(repositorio) as T
            }
            throw IllegalArgumentException("unknown viewModel class")
        }
    }
}