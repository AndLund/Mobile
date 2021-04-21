package tads.ufrn.pdm.segundaprova.ui.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import tads.ufrn.pdm.segundaprova.R


class DetalhesDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let{
            var builder = AlertDialog.Builder(it)
                .setView(it.layoutInflater.inflate(R.layout.fragment_detalhes_dialog, null))
                .setPositiveButton("Ok"){dialogInterface, i ->
                }
            builder.create()
        }?: throw IllegalStateException("Activity not found")
    }
}