package com.wzz.firstlinecode.chapter08

import android.net.Uri

/**
 * @ClassName ContentProviderDetails
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/6/28 16:19
 * @Version 1.0
 * authority 这个一般以包名命名
 * path 这个表
 */

//content://com.wzz.firstlinecode.provider/table1
val uri =Uri.parse("content://com.wzz.firstlinecode.provider/table1")