package com.wzz.firstlinecode.chapter10

import android.app.ProgressDialog
import android.os.AsyncTask
import com.wzz.firstlinecode.chapter04.ToastUtils

/**
 * @ClassName DownloadTask
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/7/4 17:13
 * @Version 1.0
 */
class DownloadTask(private val progressDialog: ProgressDialog) : AsyncTask<Unit,Int,Boolean>() {

    var process:Int = 0

    override fun onPreExecute() {
        progressDialog.show()
    }

    override fun onPostExecute(result: Boolean) {
       progressDialog.dismiss()
        if (result){
            ToastUtils.showToast("成功")
        }else{
            ToastUtils.showToast("失败!")
        }
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressDialog.setMessage("下载进度${values[0]}")
    }


    override fun doInBackground(vararg params: Unit?) = try {
        while (true){
            val downloadPercent = doDownload()
            publishProgress(downloadPercent)
            if (downloadPercent>=100){
                break
            }
        }
        true
    }catch (e:Exception){
        false
    }

    private fun doDownload(): Int {
        process++
        Thread.sleep(500)
        return process
    }

}