package tads.ufrn.pdm.segundaprova.ui.cadastra

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import tads.ufrn.pdm.segundaprova.database.ComidaRepository
import tads.ufrn.pdm.segundaprova.model.Comida
import java.lang.IllegalArgumentException

class CadastraViewModel(val comidaRepository: ComidaRepository) : ViewModel() {
    var comida:Comida = Comida()

    private var _eventCadastraComida = MutableLiveData<Boolean>(false)
    val eventCadastraComida:LiveData<Boolean>
        get() = _eventCadastraComida

    fun cadastra(){
        viewModelScope.launch {
            comidaRepository.insert(comida)
        }
        _eventCadastraComida.value = true
    }

    fun onCadastraComidaComplete(){
        _eventCadastraComida.value = false
    }

    class Factory(val repositorio: ComidaRepository): ViewModelProvider.Factory{
        override fun <T: ViewModel?> create(modelClass: Class<T>):T{
            if(modelClass.isAssignableFrom(CadastraViewModel::class.java)){
                return CadastraViewModel(repositorio) as T
            }
            throw IllegalArgumentException("unknown viewModel class")
        }
    }
}


