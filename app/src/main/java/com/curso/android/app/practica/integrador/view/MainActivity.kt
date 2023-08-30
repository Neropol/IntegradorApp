package com.curso.android.app.practica.integrador.view
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.curso.android.app.practica.integrador.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    //declara  variable
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //vincula el activity con binding
        //variable binding   referencia a la activity y sus objetos
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.resultaModel.observe(this){
            println("valor nuevo $it")
            binding.viewResulta.text="${it.resulta}"
        }

//bindig on click

        binding.btnComp.setOnClickListener {
            mainViewModel.checkIgual(binding.data1.text.toString(), binding.data2.text.toString())}


    }
}
