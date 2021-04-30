package tads.ufrn.pdm.segundaprova.ui.home

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import tads.ufrn.pdm.segundaprova.database.ComidaRepository
import tads.ufrn.pdm.segundaprova.model.Comida
import tads.ufrn.pdm.segundaprova.model.Comida2
import java.lang.IllegalArgumentException

class HomeFragmentViewModel private constructor(val repositorio: ComidaRepository) : ViewModel(){
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