package com.cnpeng.android2.a02_maxLinesTv

import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import com.cnpeng.android2.R
import kotlinx.android.synthetic.main.activity_max_lines_tv.*

/**
 * 作者：CnPeng
 * 时间：2018/9/4
 * 功用：解决TextView 设置 maxLines 后 elipsed=end 不生效的问题
 * 其他：
 */
class MaxLinesTvActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_max_lines_tv)

        tv_maxLines.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                val lineCount = tv_maxLines.lineCount
                val lineLimit = tv_maxLines.maxLines

                if (lineCount > lineLimit) {
                    //获取限定行数末尾的字符索引
                    val limitLastStrIndex = tv_maxLines.layout.getLineEnd(lineLimit);
                    val subsStr = tv_maxLines.editableText.subSequence(0, limitLastStrIndex - 3).toString()
                    val strToShow = subsStr.plus("...")
                    tv_maxLines.text = strToShow

                }

                //使用完毕记得移除
                tv_maxLines.viewTreeObserver.removeOnPreDrawListener(this)
                return true
            }
        })

        bt.setOnClickListener {
            tv_maxLines.text = et.editableText.toString()
            tv_maxLines.text = "  android:text=//获取限定行数末尾的字符索引 val limitLastStrIndex = tv_maxLines.layout.getLineEnd(lineLimit); val subsStr = tv_maxLines.editableText.subSequence(0, limitLastStrIndex - 3).toString() val strToShow = subsStr.plus(tv_maxLines.text = strToShow "
        }
    }
}