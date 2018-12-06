package com.cnpeng.android2.b_work.b04_flow_layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cnpeng.android2.R
import kotlinx.android.synthetic.main.activity_flow_impl.*

/**
 * CnPeng 2018/12/6 5:35 PM
 * 功用：流式布局/标签实现方式的总结
 * 说明：
 * 1、流式布局/标签的实现方式大致有：
 *  -- 自定义FlowLayout。参考链接：https://github.com/hongyangAndroid/FlowLayout
 *  -- ChipGroups。     参考链接：https://www.jianshu.com/p/d64a75ec7c74
 *  -- RecyclerView+StaggerLayoutManager
 *  -- RecyclerView+FlexLayoutManager   参考链接：https://mp.weixin.qq.com/s/Mi3cK7xujmEMI_rc51-r4g
 *  -- RecyclerView+GridLayoutManager+Span  参考链接：https://blog.csdn.net/zhq217217/article/details/80421646
 *
 * 2、该DEMO仅演示StaggerLayoutManager和FlexLayoutManager的实现方式
 */
class FlowImplActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow_impl)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val dataList = initTestData()
        val adapter = FlowAdapter(dataList)
        rv_flowImpl.adapter = adapter

        adapter.mEmsLines = 1
        rv_flowImpl.layoutManager = StaggeredGridLayoutManager(4, RecyclerView.VERTICAL)

    }

    /**
     * CnPeng 2018/12/6 6:17 PM
     * 功用：模拟数据
     * 说明：
     */
    private fun initTestData(): List<String> {
        val dataList = mutableListOf<String>()
        val originStr = "哈哈哈哈哈哈哈哈哈哈"

        for (i in 1..30) {
            val str = originStr.subSequence(0, if (0 == (i % 10)) {
                1
            } else {
                i % 10
            }).toString()

            dataList.add(str)
        }

        return dataList
    }
}