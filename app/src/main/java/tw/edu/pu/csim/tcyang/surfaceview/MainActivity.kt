package tw.edu.pu.csim.tcyang.surfaceview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var count:Long = 0
    lateinit var myHandler: Handler
    lateinit var myRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the handler instance
        myHandler = Handler(Looper.getMainLooper())
        myRunnable = Runnable {
            count++;
            txv.text = count.toString()
            myHandler.postDelayed(myRunnable, 1000)
        }

        // Set a click listener for run button
        btn.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                if (btn.text == "開始計數"){
                    myHandler.postDelayed(myRunnable, 1000)
                    btn.text = "結束計數"
                }
                else{
                    myHandler.removeCallbacks(myRunnable)
                    btn.text = "開始計數"
                }
            }
        })
    }

}