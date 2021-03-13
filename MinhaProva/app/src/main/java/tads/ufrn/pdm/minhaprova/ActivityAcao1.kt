package tads.ufrn.pdm.minhaprova

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import tads.ufrn.pdm.minhaprova.databinding.ActivityAcao1Binding
import tads.ufrn.pdm.minhaprova.databinding.ActivityMainBinding

class ActivityAcao1 : AppCompatActivity() {

    lateinit var binding: ActivityAcao1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_acao1)

        binding.cancelarButton.setOnClickListener(){
            setResult(RESULT_CANCELED)
            finish()
        }

        binding.okButton.setOnClickListener(){
            val intent = Intent()
            intent.putExtra("resultado",binding.acao1editText.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }


}