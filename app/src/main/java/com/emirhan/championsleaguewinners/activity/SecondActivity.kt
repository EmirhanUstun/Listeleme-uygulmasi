package com.emirhan.championsleaguewinners.activity

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.emirhan.championsleaguewinners.databinding.ActivitySecondBinding
import com.emirhan.championsleaguewinners.toLowerCaseAll
import com.emirhan.championsleaguewinners.toLowerTR
import com.emirhan.championsleaguewinners.AllertUtils
//import com.emirhan.championsleaguewinners.R
import com.emirhan.championsleaguewinners.toLowerCaseAll
import com.emirhan.championsleaguewinners.toLowerTR
import java.util.*
import kotlin.collections.ArrayList

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    //Bu kod parçası geri tuşuna basıldığında bir uyarı mesajı gösterir.
    override fun onBackPressed() {
        AllertUtils.dialogGoster(this@SecondActivity)

    }

    var isimListesi =  arrayListOf<String>(
        "",
        "Real Madrid",
        "Milan",
        "Bayern Munich",
        "Liverpool",
        "Barcelona",
        "Ajax",
        "Manchester United",
        "Inter Milan",
        "Juventus",
        "Benfica",
        "Chelsea",
        "Nottingham Forest",
        "Porto",
        "Celtic",
        "Hamburger SV",
        "Steaua București",
        "Marseille",
        "Borussia Dortmund",
        "Feyenoord",
        "Aston Villa",
        "PSV Eindhoven",
        "Red Star Belgrade"
    )


    var adapter: ArrayAdapter<String>? = null

    //Bu kod parçası kodun tekrarını önlemek için.
    private fun init() {
        initBinding()
        initListView()
        initSerachView()

    }

    //Bu kod parçası XML'deki ögelerli koda bağlamak için.
    private fun initBinding() {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }



    //Bu kod parçasu "isimListesi"'ndeki verileri "ArrayAdapter" nesnesiyle ListView'da gösterir.
    private fun initListView() {
        //Listedeki tüm isimleri küçük harfe dönüştürür.
        isimListesi = isimListesi.toLowerCaseAll()

        //ListView'a bir dizi yerleştirmek için.
        adapter = ArrayAdapter(this@SecondActivity, R.layout.simple_list_item_1, isimListesi)


        binding.apply {
            //Bütün harfleri küçülttüm.

            //Bu kod parçasında ise ListView'daki herhangi bir ögeye tıklandığında bir tepki belirtir.
            listView.setAdapter(adapter)
            listView.setOnItemClickListener { parent, view, position, id ->
                Toast.makeText(
                    applicationContext,
                    "Tıklanan " + isimListesi.get(position),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    //Bu kod parçası arama kutusu için bir "onQueryTextListener" oluşturur ve ListView'in içeriğini filtreler.
    private fun initSerachView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                adapter?.filter?.filter(newText?.toLowerTR())

                return false
            }
        })
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()


    }
}