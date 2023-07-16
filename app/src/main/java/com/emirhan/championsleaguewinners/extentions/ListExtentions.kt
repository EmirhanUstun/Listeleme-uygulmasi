package com.emirhan.championsleaguewinners

//Bu kod parçası ArrayList'teki ögelerin her birinin harflerini küçük harfe dönüştürür.
//(ArrayList'i değiştirmez küçültülmüş yeni ArrayList döndürür. Döndürdüğü ArrayList'i "gecici"'ye aktarır.)
fun ArrayList<String>.toLowerCaseAll(): ArrayList<String> {
    val gecici = arrayListOf<String>()

    forEach{
        gecici.add(it.toLowerCase())
    }
    return gecici
}