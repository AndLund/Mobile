package tads.ufrn.pdm.minhaprova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import tads.ufrn.pdm.minhaprova.databinding.ActivityAcao1Binding
import tads.ufrn.pdm.minhaprova.databinding.ActivityAcao2Binding

class ActivityAcao2 : AppCompatActivity() {
    lateinit var binding: ActivityAcao2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_acao2)

        binding.cancelarB.setOnClickListener() {
            setResult(RESULT_CANCELED)
            finish()
        }

        binding.salvarButton.setOnClickListener() {
            var nomeLivro = binding.nomeLivroEditText.text
            var autor = binding.autorEditText.text
            var ano = binding.anoEditText.text
            var nota = binding.notaRatingBar.rating
            if(!(nomeLivro.isEmpty() || autor.isEmpty() || ano.isEmpty())){
                var l = Livro(0, nomeLivro.toString(), autor.toString(), ano.toString().toInt(), nota)

                var db = LivroDBOpener(this)

                db.insert(l)

                var intent = Intent()
                intent.putExtra("resultado", "cadastrado")
                setResult(RESULT_OK, intent)
                finish()
            }else{
                Toast.makeText(this, "Ha campo vazio", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
