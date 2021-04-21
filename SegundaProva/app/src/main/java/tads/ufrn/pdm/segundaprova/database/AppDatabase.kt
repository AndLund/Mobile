package tads.ufrn.pdm.segundaprova.database

import androidx.room.Database
import androidx.room.RoomDatabase
import tads.ufrn.pdm.segundaprova.database.ComidaDAO
import tads.ufrn.pdm.segundaprova.model.Comida

@Database(entities = [Comida::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun comidaDAO(): ComidaDAO
}