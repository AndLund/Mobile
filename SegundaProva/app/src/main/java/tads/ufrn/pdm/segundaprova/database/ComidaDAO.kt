package tads.ufrn.pdm.segundaprova.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import tads.ufrn.pdm.segundaprova.model.Comida

@Dao
interface ComidaDAO {
    @Query("SELECT * FROM tabela_comida")
    fun listAll(): Flow<List<Comida>>
    @Query("SELECT * FROM tabela_comida WHERE id LIKE :comidaId")
    suspend fun findById(comidaId: Int): Comida
    @Insert
    suspend fun insert(comida: Comida)
    @Delete
    suspend fun delete(comida: Comida)
    @Update
    suspend fun update(comida: Comida): Int
}