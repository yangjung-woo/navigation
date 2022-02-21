package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.navigation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

private var mbinding : ActivityMainBinding? = null
private val binding get() =mbinding!!

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mbinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNavi.setOnClickListener{ //네비 버튼 클릭시 동작
            binding.layoutDrawer.openDrawer(GravityCompat.START) // 네비 창 열기 START =right END = left

        }
        binding.naviView.setNavigationItemSelectedListener (this) //네비게이션 메뉴 아이템에 클릭속성 부여
        // 이게 있어야 onNavigationItemSelected 를 동작할수 있다




    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {//네비게이션 메뉴 아이템 클릭시 실행
// 클릭시 item 이 생성됨 형태눈 MenuItem
        when (item.itemId)
        {
            R.id.access -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext, "메시지", Toast.LENGTH_SHORT).show()
        }
        binding.layoutDrawer.closeDrawers() //네비게이션 뷰 닫기
        return false
    }

    override fun onBackPressed() { //백 버튼 클릭시
       if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START)) // laydrawer가 열려있으면
       {
           binding.layoutDrawer.closeDrawers()// 창 닫아라

       }
        else
       {
           super.onBackPressed() //일반 백버튼 실행
       }
    }

    override fun onDestroy() {
        mbinding = null
        super.onDestroy()
    }
}