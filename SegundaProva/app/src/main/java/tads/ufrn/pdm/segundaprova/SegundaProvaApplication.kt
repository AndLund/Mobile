package tads.ufrn.pdm.segundaprova

import android.app.Application
import tads.ufrn.pdm.segundaprova.database.AppDatabase
import tads.ufrn.pdm.segundaprova.database.ComidaRepository

class SegundaProvaApplication : Application(){
    private val db by lazy { AppDatabase.invoke(this) }
    val repository by lazy { ComidaRepository(db.comidaDAO()) }
}