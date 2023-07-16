package com.emirhan.championsleaguewinners

import java.util.*

//Bu kod parçası küçülttüğümüz harflerin "türkçe" karakterlerde de sıkıntısız bir şekilde çalışması için.
fun String.toLowerTR() : String{
    return this.toLowerCase(Locale("tr", "TR"))

}