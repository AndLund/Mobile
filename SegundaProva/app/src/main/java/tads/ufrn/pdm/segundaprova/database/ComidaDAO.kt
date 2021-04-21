package tads.ufrn.pdm.segundaprova.database

import androidx.lifecycle.LiveData
import androidx.room.*
import tads.ufrn.pdm.segundaprova.model.Comida

@Dao
interface ComidaDAO {
    @Query("SELECT * FROM tabela_comida")
    fun listAll(): LiveData<List<Comida>>
    @Query("SELECT * FROM tabela_comida WHERE id LIKE :comidaId")
    fun findById(comidaId: Int): Comida
    @Insert
    fun insert(comida: Comida)
    @Delete
    fun delete(comida: Comida)
    @Update
    fun update(comida: Comida): Int
}