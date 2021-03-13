package tads.ufrn.pdm.minhaprova

import android.app.Activity
import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import tads.ufrn.pdm.minhaprova.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel:VModel

    val CODIGO_BOTAO1 = 51
    val CODIGO_BOTAO3 = 53

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(VModel::class.java)

        binding.text1.text =viewModel._text1
        binding.text2.text =viewModel._text2

        val settings = getSharedPreferences("prefs", MODE_PRIVATE)

        var sinalizador = settings.getBoolean("flag",true )

        if(sinalizador){
            Toast.makeText(this, getString(R.string.welcome), Toast.LENGTH_SHORT).show()
            var editSettings = settings.edit()
            editSettings.putBoolean("flag", false)
            editSettings.apply()
        }

        //val livro01 = Livro(0,"aaa", "bbb", 2021, 2.5f )

        //val db = LivroDBOpener(this)

        //db.insert(livro01)

        binding.button1.setOnClickListener{
            val intent = Intent(this, ActivityAcao1::class.java)
            startActivityForResult(intent, CODIGO_BOTAO1)
        }

        binding.button2.setOnClickListener{
            var dialogo = Cafezinho()
            dialogo.show(supportFragmentManager, "Dialog")
        }

        binding.button3.setOnClickListener{
            val intent = Intent(this, ActivityAcao2::class.java)
            startActivityForResult(intent, CODIGO_BOTAO3)
        }
        binding.button4.setOnClickListener{
            val intent = Intent(this, ActivityAcao3::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (resultCode) {
            RESULT_OK -> {
                val resultado = data!!.getStringExtra("resultado")
                when (requestCode) {
                    CODIGO_BOTAO1 -> {
                        binding.text1.text = resultado
                        viewModel._text1 = resultado.toString()
                    }

                    CODIGO_BOTAO3 -> {
                        binding.text2.text = resultado
                        viewModel._text2 = resultado.toString()
                    }
                }
            }
            RESULT_CANCELED -> {
                when (requestCode) {
                    CODIGO_BOTAO1 -> {
                        Snackbar.make(binding.mainlayout, "Cancelado", Snackbar.LENGTH_LONG)
                            .setAction("OK"){}.show()
                    }

                    CODIGO_BOTAO3 -> {
                        //nothing happens
                    }
                }

            }
        }
    }
}