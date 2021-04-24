package tads.ufrn.pdm.segundaprova.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import tads.ufrn.pdm.segundaprova.database.ComidaDAO
import tads.ufrn.pdm.segundaprova.model.Comida

@Database(entities = [Comida::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun comidaDAO(): ComidaDAO

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()
        operator fun invoke(context:Context)=instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java,"database-name.sqlite")
            .fallbackToDestructiveMigration()
            .build()
    }
}
