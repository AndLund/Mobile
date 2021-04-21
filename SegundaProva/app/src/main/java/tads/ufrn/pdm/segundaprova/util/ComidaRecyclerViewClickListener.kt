package tads.ufrn.pdm.segundaprova.util

import android.content.Context
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ComidaRecyclerViewClickListener(val context: Context, val view:RecyclerView, val listener: OnItemClickListener): RecyclerView.OnItemTouchListener {

    var myGestureDetector: GestureDetector

    init {
        myGestureDetector =
            GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    super.onSingleTapUp(e)
                    val childView = view.findChildViewUnder(e.x, e.y)
                    if (childView != null) {
                        listener.onItemClick(childView, view.getChildAdapterPosition(childView))
                        Log.i("Teste", "onSingleTapUp ")
                    }
                    return true
                }
                override fun onLongPress(e: MotionEvent) {
                    super.onLongPress(e)
                    val childView = view.findChildViewUnder(e.x, e.y)
                    if (childView != null) {
                        listener.onItemLongClick(childView, view.getChildAdapterPosition(childView))
                        Log.i("Teste", "onLongPress")
                    }
                }
            })
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int) //DetalhesFragment
        fun onItemLongClick(view: View, position: Int) //AlteraFragment
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        myGestureDetector.onTouchEvent(e);
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }

}