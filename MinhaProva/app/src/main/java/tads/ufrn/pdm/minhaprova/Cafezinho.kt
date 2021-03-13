package tads.ufrn.pdm.minhaprova

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class Cafezinho: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity!!)
        builder.setTitle("PERGUNTA IMPORTANTE")
        builder.setMessage("Gostaria de uma xícara de café?")
            .setPositiveButton("Sim", DialogInterface.OnClickListener { dialog, id ->
                Toast.makeText(activity, "Otimo", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("Não", DialogInterface.OnClickListener { dialog, id ->
                Toast.makeText(activity, "Fica para a proxima!", Toast.LENGTH_SHORT).show()
            })
        return builder.create()
    }
}