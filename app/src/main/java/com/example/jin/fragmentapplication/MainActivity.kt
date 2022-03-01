package com.example.jin.fragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jin.fragmentapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var listFragment: ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment()

        binding.btnSend.setOnClickListener {
            listFragment.setValue("오케이")
        }
    }

    private fun setFragment() {
        listFragment = ListFragment()

        val bundle = Bundle()
        bundle.putString("key1", "List Fragment")
        bundle.putInt("key2", 20210101)
        listFragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, listFragment)
        transaction.commit()
    }

    fun goDetail(){
        val detailFragment = DetailFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun goBack(){
        onBackPressed()
    }
}