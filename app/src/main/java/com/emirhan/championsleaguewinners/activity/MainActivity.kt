package com.emirhan.championsleaguewinners.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.emirhan.championsleaguewinners.databinding.ActivityMainBinding
import com.emirhan.championsleaguewinners.ekranAc


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()

    }
    //Bu kod parçası diğer yöntemleri çağırır ve kod tekrarını önler.
    fun init()
    {
        initBinding()
        initCounterDown()
    }

    //Bu kod parçası XML'deki ögelerli koda bağlamak için.
    fun initBinding()
    {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //Bu kod parçası geri sayım işlemini başlatmak için.
    fun initCounterDown()
    {
        //Bu kod parçası 5 saniyelik bir geri sayım işlemi yapar.
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            //Bu kod parçası geri sayım tamamlandığında geçekleşecek işlemleri içerir.
            override fun onFinish() {
                binding.progressBar2.visibility = View.GONE
                //İşlem bittikten sonra ekranda bir Toast bilgi kutucuğu çıkartır.
                Toast.makeText(applicationContext,"Yükleme Tamamlandı.",Toast.LENGTH_LONG).show()
                //Geri sayım bittiğinde ikinci ekrana geçmek için.
                ekranAc(SecondActivity :: class.java)
            }
        }.start()
    }


}