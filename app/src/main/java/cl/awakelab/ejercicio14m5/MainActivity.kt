package cl.awakelab.ejercicio14m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cl.awakelab.ejercicio14m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonOk.setOnClickListener{
            when (binding.radioGroup.checkedRadioButtonId){
               R.id.radioButtonSaldo ->
                   binding.textMonto.setText(saldo.toString())
                R.id.radioButtonIngresar -> ingresarSaldo()
                R.id.radioButtonRetirar -> retirarSaldo()
                R.id.radioButtonSalir -> finish()

            }
        }
    }

    private fun retirarSaldo() {
        saldo -= binding.textMonto.text.toString().toInt()
        Toast.makeText(applicationContext,"El retiro ha sido realizado correctamente",Toast.LENGTH_LONG).show()
    }

    fun ingresarSaldo(){
    saldo += binding.textMonto.text.toString().toInt()
    Toast.makeText(applicationContext,"Su saldo ha sido actualizado correctamente",Toast.LENGTH_LONG).show()
    }

}