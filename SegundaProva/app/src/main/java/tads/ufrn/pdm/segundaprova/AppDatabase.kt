package tads.ufrn.pdm.segundaprova

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Comida::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun comidaDAO(): ComidaDAO
}