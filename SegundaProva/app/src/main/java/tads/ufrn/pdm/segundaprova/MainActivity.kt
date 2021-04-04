package tads.ufrn.pdm.segundaprova

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    val db:AppDatabase by lazy {
        Room.databaseBuilder(
        this,
        AppDatabase::class.java,
        "database-name")
        .allowMainThreadQueries()
        .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //db.comidaDAO().insert(Comida(0, "nomecomida2", "descricao2", "criador2", "regiao2", 0.7f))
        //db.comidaDAO().listAll().forEach { Log.i("AAAA", it.toString()) }
        var tarefa = listarComidas()
        tarefa.execute(0) //retorna list
        //tarefa.execute(1) //id especifico
    }

    private inner class listarComidas : AsyncTask<Int,Void,Void>() {

        override fun doInBackground(vararg p: Int?): Void? {
            if (p[0] != 0) {
                var id = p[0]
                val comidaId = db.comidaDAO().findById(id.toString())
                Log.i("logando", comidaId.toString())
            } else {
                var comidaAll = db.comidaDAO().listAll()
                Log.i("logando", comidaAll.toString())
            }
            return null
        }
    }
}
