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
        val monto = binding.textMonto.text.toString().toInt()
        if( monto <= saldo){
            saldo -= monto
            limpiarMonto()
          crearMensaje(" El retiro ha sido realizado correctamente")
        }
        else {
            crearMensaje("El monto supera el saldo inicial, intenta nuevamente")
        }
    }

    fun ingresarSaldo(){
    saldo += binding.textMonto.text.toString().toInt()
    limpiarMonto()
    crearMensaje("Su saldo ha sido actualizado correctamente")
    }
    fun limpiarMonto(){
        binding.textMonto.text.clear()
    }
    fun crearMensaje(s: String) {
        Toast.makeText(applicationContext,s,Toast.LENGTH_LONG).show()
    }
}