package com.emirhan.championsleaguewinners

import android.app.Activity
import android.app.AlertDialog

//Bu nesne kullanıcının uygulamadan çıkmak istediğini belirttiğinde çıkış onayı için bir "AlertDialog" gösterir.
object AllertUtils {

    //Bu kod parçasında AlertDialog'un yapısı.
    //Mesaj ve iki düğme ayarlanır.
    //"Evet" veya "Hayır" düğmesine basıldığında kapanıp kapanmayacağı belirlenir.
    fun dialogGoster(activity: Activity)
    {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle(activity.getString(R.string.app_name))
        builder.setMessage(activity.getString(R.string.cikilsinmi))
        builder.setPositiveButton(activity.getString(R.string.evet), {dialog, i ->

            activity.finishAffinity()
        })

        builder.setNegativeButton(activity.getString(R.string.hayir), {dialog, i ->

            dialog.dismiss()
        })

        builder.show()
    }
}