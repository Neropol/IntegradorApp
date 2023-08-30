package com.curso.android.app.practica.integrador.view
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.integrador.model.ResultaModel


class MainViewModel : ViewModel() {
    val resultaModel : LiveData<ResultaModel> get()= _resultaModel
    private var _resultaModel=MutableLiveData(ResultaModel(""))


    fun checkIgual( data1:String, data2:String) {

        val resulta = (if (data1 == data2) {
            "Son iguales"
        } else {
            "NO Son iguales"
        })
        updateData(resulta)

    }

    private fun updateData(resulta:String) {
        _resultaModel.value=ResultaModel(resulta)

    }
}