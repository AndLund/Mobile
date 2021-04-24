package tads.ufrn.pdm.segundaprova.database

import kotlinx.coroutines.flow.Flow
import tads.ufrn.pdm.segundaprova.model.Comida

class ComidaRepository(val comidaDAO: ComidaDAO) {
    val listAll: Flow<List<Comida>> = comidaDAO.listAll()

    suspend fun insert(c:Comida){
        comidaDAO.insert(c)
    }

    suspend fun update(c:Comida){
        comidaDAO.update(c)
    }

    suspend fun findById(id:Int):Comida{
        return comidaDAO.findById(id)
    }
}