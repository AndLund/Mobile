package tads.ufrn.pdm.segundaprova.ui.altera

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import tads.ufrn.pdm.segundaprova.database.ComidaRepository
import tads.ufrn.pdm.segundaprova.model.Comida
import java.lang.IllegalArgumentException

@Suppress("DEPRECATION")
class AlteraViewModel private constructor(val repositorio: ComidaRepository) : ViewModel() {
    private val _comida = MutableLiveData<Comida>()
    val comida:LiveData<Comida>
        get() = _comida

    private var _eventAlteraComida = MutableLiveData<Boolean>(false)
    val eventAlteraComida:LiveData<Boolean>
        get() = _eventAlteraComida

    fun atualizaCadastro(){
        viewModelScope.launch {
            comida.value?.let {
                repositorio.update(it)
            }
        }
        _eventAlteraComida.value = true
    }

    fun onAlteraComidaComplete(){
        _eventAlteraComida.value = false
    }

    fun getComidaAt(id:Int){
        viewModelScope.launch {
            _comida.value = repositorio.findById(id)
        }
    }

    class Factory(val repositorio: ComidaRepository):ViewModelProvider.Factory{
        override fun <T: ViewModel?> create(modelClass: Class<T>):T{
            if(modelClass.isAssignableFrom(AlteraViewModel::class.java)){
                return AlteraViewModel(repositorio) as T
            }
            throw IllegalArgumentException("unknown viewModel class")
        }
    }
}