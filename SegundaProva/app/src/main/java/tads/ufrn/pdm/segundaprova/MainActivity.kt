package tads.ufrn.pdm.segundaprova

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Room
import tads.ufrn.pdm.segundaprova.databinding.ActivityMainBinding
import tads.ufrn.pdm.segundaprova.databinding.FragmentHomeBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

//    val db:AppDatabase by lazy {
//        Room.databaseBuilder(
//        this,
//        AppDatabase::class.java,
//        "database-name.sqlite")
//        .allowMainThreadQueries()
//        .build()
//    }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = Navigation.findNavController(this,R.id.MyNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController,binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

        //db.comidaDAO().insert(Comida("nomecomida1", "descricao1", "criador1","camaroes","regiao1",0.5f))
        //db.comidaDAO().insert(Comida("nomecomida2", "descricao2", "criador2","tabua de carne","regiao2",0.4f))

        //db.comidaDAO().listAll().forEach { Log.i("AAAA", it.toString()) }
        //var tarefa = listarComidas()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.MyNavHostFragment)
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
    }
}
