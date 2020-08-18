package vantutrieu97.xyz.googleandroidcertification

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import vantutrieu97.xyz.googleandroidcertification.R.layout.activity_main

class MainActivity : AppCompatActivity() {
    lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        mContext = this

        val inflater = layoutInflater
        val container: ViewGroup? = findViewById(R.id.custom_toast_container)
        val layout: ViewGroup = inflater.inflate(R.layout.custom_toast, container) as ViewGroup
        val text: TextView = layout.findViewById(R.id.text)
        text.text = "This is a custom toast"
        with(Toast(applicationContext)) {
            setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }
        val snackbar = Snackbar.make(
            ct_wrap_view, "This is simple snackbar", Snackbar.LENGTH_INDEFINITE
        ).setAction("Action", View.OnClickListener {
            Toast.makeText(mContext, "click to snackbar", Toast.LENGTH_SHORT).show()
        })

        snackbar.setActionTextColor(Color.WHITE)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(Color.BLACK)
        val textView =
            snackbarView.findViewById(R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        textView.textSize = 12f
        snackbar.show()
    }
}
