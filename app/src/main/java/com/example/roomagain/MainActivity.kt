package com.example.roomagain

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomagain.database.userDatabase
import com.example.roomagain.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var userAdapter :useAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var lists:List<user> = ArrayList<user>()
        userAdapter.setData(lists)

        binding.rvList.adapter = userAdapter
        binding.rvList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        binding.btnOK.setOnClickListener{
            var uN = binding.edtUName.text.toString()
            var uA = binding.edtUAdd.text.toString()

            var newUser :user = user(uN,uA)
            userDatabase.getInstance(this).userDao().insertUser(newUser)

           lists =  userDatabase.getInstance(this).userDao().getListUsers()
            userAdapter.setData(lists)
        }
    }
}