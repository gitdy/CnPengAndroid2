package com.cnpeng.android2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cnpeng.android2.a_book1.BookOneActivity
import com.cnpeng.android2.b_work.WorkDemoActivity
import com.cnpeng.android2.d_mine.MyDemoActivity
import com.cnpeng.android2.utils.TripleLibInitUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

/**
 * CnPeng 2018/8/16 10:01 AM
 * 功用：主页
 * 说明：
 * - 1、a系列包名为读书笔记
 * - 2、b系列为工作用DEMO
 * - 3、c系列为零散的博客阅读笔记
 * - 4、d系列为自主学习的代码内容
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * CnPeng 2018/8/29 下午8:33 参考 https://juejin.im/post/5b50b017f265da0f7b2f649c 启动页优化，防止白屏
         *
         * 其思路是，在 Manifest 中为该activity配置一个设置了 windowBackground 的 theme, 这样在启动后完成绘制前的
         * 这一段时间就会展示这个 windowBackground.当 进入activity后，再重置theme
         */
        setTheme(R.style.AppTheme)

        setContentView(R.layout.activity_main)
        mActivity = this

        //CnPeng 2019/1/8 3:54 PM 统一管理三方库的初始化
        TripleLibInitUtils(this).initTripleLib()

        initClickListener()
    }

    private fun initClickListener() {
        tv_mineDemo.setOnClickListener(this)
        tv_workDemo.setOnClickListener(this)
        tv_bookDemo1.setOnClickListener(this)
        tv_blogDemo.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val viewID = v?.id

        when (viewID) {
            R.id.tv_mineDemo -> startActivity<MyDemoActivity>()
            R.id.tv_workDemo -> startActivity<WorkDemoActivity>()
            R.id.tv_bookDemo1 -> startActivity<BookOneActivity>()
            else -> Toast.makeText(mActivity, "暂无内容", Toast.LENGTH_SHORT).show()
        }
    }
}
