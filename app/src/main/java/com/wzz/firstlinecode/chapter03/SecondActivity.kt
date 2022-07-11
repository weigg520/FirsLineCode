package com.wzz.firstlinecode.chapter03
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.wzz.firstlinecode.R
import kotlinx.android.synthetic.main.second.*

/**
 * @ClassName SecondActivity
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/13 15:34
 * @Version 1.0
 */
class SecondActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        val path: String? = intent.data?.toString()
        Log.e("TAG", "onCreate: " + path)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            web_view.webViewClient = WebC()
        }
        web_view.loadUrl(path)
    }

    private class WebC : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return false
        }
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode== KeyEvent.KEYCODE_BACK&&web_view.canGoBack()){
            web_view.goBack()
            true
        }else{
            super.onKeyDown(keyCode, event)
        }
    }

    companion object{
        fun actionStart(context: Context,data:String){
            val intent = Intent(context,SecondActivity::class.java)
            intent.data = Uri.parse(data)
            context.startActivity(intent)
        }
    }
}
