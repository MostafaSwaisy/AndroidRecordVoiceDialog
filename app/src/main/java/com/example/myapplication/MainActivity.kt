package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.recordvoicedialog.OnRecordListener
import com.example.recordvoicedialog.RecordVoiceBottomSheetFragmentDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_showDailog.setOnClickListener {
            val r = RecordVoiceBottomSheetFragmentDialog()
            r.show(supportFragmentManager, "tag!")
            r.recordListener= (object :OnRecordListener{
                override fun onCancel() {
                    Log.d(TAG, "onCancel")
                }

                override fun onFinish(recordTime: Long) {
                    Log.d(TAG, "onFinish : " + recordTime)

                }

                override fun onLessThanSecond() {
                    Log.d(TAG, "onLessThanSecond")
                }

                override fun onSend() {
                    Log.d(TAG, "onSend")
                }

                override fun onStartRecording() {
                    Log.d(TAG, "onStartRecording")
                }

            })
        }

    }


}
