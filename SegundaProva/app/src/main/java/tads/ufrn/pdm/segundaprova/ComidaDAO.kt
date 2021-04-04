package tads.ufrn.pdm.segundaprova

import androidx.room.*

@Dao
interface ComidaDAO {
    @Query("SELECT * FROM tabela_comida")
    fun listAll(): List<Comida>
    @Query("SELECT * FROM tabela_comida WHERE id LIKE :comidaId")
    fun findById(comidaId: String): Comida
    @Insert
    fun insert(comida: Comida)
    @Delete
    fun delete(comida: Comida)
    @Update
    fun update(comida: Comida): Int
}