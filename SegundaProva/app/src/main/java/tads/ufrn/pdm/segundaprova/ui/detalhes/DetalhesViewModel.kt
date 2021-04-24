package tads.ufrn.pdm.segundaprova.ui.detalhes

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.*
import androidx.room.Room
import kotlinx.coroutines.launch
import tads.ufrn.pdm.segundaprova.database.AppDatabase
import tads.ufrn.pdm.segundaprova.database.ComidaRepository
import tads.ufrn.pdm.segundaprova.model.Comida
import tads.ufrn.pdm.segundaprova.ui.altera.AlteraViewModel
import java.lang.IllegalArgumentException

@Suppress("DEPRECATION")
class DetalhesViewModel private constructor(val repositorio: ComidaRepository) : ViewModel() {

    private val _comida = MutableLiveData<Comida>()
    val comida:LiveData<Comida>
        get() = _comida

    fun getComida(id:Int){
        viewModelScope.launch {
            _comida.value = repositorio.findById(id)
        }
    }

    class Factory(val repositorio: ComidaRepository): ViewModelProvider.Factory{
        override fun <T: ViewModel?> create(modelClass: Class<T>):T{
            if(modelClass.isAssignableFrom(DetalhesViewModel::class.java)){
                return DetalhesViewModel(repositorio) as T
            }
            throw IllegalArgumentException("unknown viewModel class")
        }
    }
}