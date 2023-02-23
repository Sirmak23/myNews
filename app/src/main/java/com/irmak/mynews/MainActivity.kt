package com.irmak.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var newsCardDetail: NewsDetailFragment? = null
    private val list : ArrayList<Pair<Fragment, Int>>  = arrayListOf()
    private var selectedFrameLayoutId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val newsCard1 = NewsCard5.newInstance("par1", "par2")
        val newsCard2 = NewsCard2.newInstance("par1", "par2")
        val newsCard3 = NewsCard3.newInstance("par1", "par2")
        val newsCard4 = NewsCard1.newInstance("par1", "par2")
        val newsCard5 = NewsCard5.newInstance("par1", "par2")
        val newsCard6 = NewsCard1.newInstance("par1", "par2")
        val newsCard7 = NewsCard2.newInstance("par1", "par2")
        val newsCard8 = NewsCard5.newInstance("par1", "par2")
        val newsCard9 = NewsCard2.newInstance("par1", "par2")
        val newsCard10 = NewsCard2.newInstance("par1", "par2")
        val newsCard11 = NewsCard1.newInstance("par1", "par2")
        val newsCard12 = NewsCard2.newInstance("par1", "par2")
        val newsCard13 = NewsCard5.newInstance("par1", "par2")
        val newsCard14 = NewsCard4.newInstance("par1", "par2")
        val newsCard15 = NewsCard3.newInstance("par1", "par2")

         newsCardDetail = NewsDetailFragment.newInstance("par1", "par2")

        addFragment(newsCard1, R.id.newsCard1)
        addFragment(newsCard2, R.id.newsCard2)
        addFragment(newsCard3, R.id.newsCard3)
        addFragment(newsCard4, R.id.newsCard4)
        addFragment(newsCard5, R.id.newsCard5)
        addFragment(newsCard6, R.id.newsCard6)
        addFragment(newsCard7, R.id.newsCard7)
        addFragment(newsCard8, R.id.newsCard8)
        addFragment(newsCard9, R.id.newsCard9)
        addFragment(newsCard10, R.id.newsCard10)
        addFragment(newsCard11, R.id.newsCard11)
        addFragment(newsCard12, R.id.newsCard12)
        addFragment(newsCard13, R.id.newsCard13)
        addFragment(newsCard14, R.id.newsCard14)
        addFragment(newsCard15, R.id.newsCard15)

        findViewById<FrameLayout>(R.id.newsCard1).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard2).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard3).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard4).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard5).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard6).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard7).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard8).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard9).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard10).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard11).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard12).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard13).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard14).setOnClickListener(this)
        findViewById<FrameLayout>(R.id.newsCard15).setOnClickListener(this)

        list.add(Pair(newsCard1, R.id.newsCard1))
        list.add(Pair(newsCard2, R.id.newsCard2))
        list.add(Pair(newsCard3, R.id.newsCard3))
        list.add(Pair(newsCard4, R.id.newsCard4))
        list.add(Pair(newsCard5, R.id.newsCard5))
        list.add(Pair(newsCard6, R.id.newsCard6))
        list.add(Pair(newsCard7, R.id.newsCard7))
        list.add(Pair(newsCard8, R.id.newsCard8))
        list.add(Pair(newsCard9, R.id.newsCard9))
        list.add(Pair(newsCard10, R.id.newsCard10))
        list.add(Pair(newsCard11, R.id.newsCard11))
        list.add(Pair(newsCard12, R.id.newsCard12))
        list.add(Pair(newsCard13, R.id.newsCard13))
        list.add(Pair(newsCard14, R.id.newsCard14))
        list.add(Pair(newsCard15, R.id.newsCard15))





    }
    override fun onClick(frameLayoutId: View?) {
        for (pair in list) {
            if (pair.second == frameLayoutId?.id){
                selectedFrameLayoutId = frameLayoutId.id
                openDetailFragment(newsCardDetail, frameLayoutId.id)
            }else {
                removeFragment(pair.first)
            }
        }
    }
    private fun removeFragment (fragment: Fragment){
        supportFragmentManager.beginTransaction().remove(fragment).commit()
    }
    private fun openDetailFragment(fragment: Fragment?, @IdRes id: Int?) {
        if (fragment == null && id == null){
            return
        }
        supportFragmentManager.beginTransaction().replace(id!!, fragment!!).commit()
    }
    private fun addFragment(fragment:Fragment, @IdRes id: Int) {
        supportFragmentManager.beginTransaction().add(id, fragment).commit()
    }

    override fun onBackPressed() {

        for (pair in list) {
            if (pair.second == selectedFrameLayoutId) {
                openDetailFragment(pair.first, pair.second)
            }else{
                addFragment(pair.first, pair.second)
            }
        }
    }

}