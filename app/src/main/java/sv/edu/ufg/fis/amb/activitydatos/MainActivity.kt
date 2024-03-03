package sv.edu.ufg.fis.amb.activitydatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent

import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    private  lateinit var  txtNombres: EditText
    private  lateinit var  txtApellios: EditText
    private  lateinit var  txtEmail: EditText
    private  lateinit var  botonguardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNombres =findViewById(R.id.txt_nombres)
        txtApellios =findViewById(R.id.txt_apellidos)
        txtEmail =findViewById(R.id.txt_email)
        botonguardar =findViewById(R.id.btn_guardar)

        botonguardar.setOnClickListener {

            if (txtNombres.getText().toString().isNullOrEmpty() || txtApellios.getText().toString()
                    .isNullOrEmpty() || txtApellios.getText().toString().isNullOrEmpty()
            )
                mensaje("campos vacio", "SE HA DETECTADO QUE HAY UN CAMPO VACIO")
            else {
                val intent = Intent(this,ActivityRecepcionDatos::class.java)
                intent.putExtra("nombres",txtNombres.getText().toString())
                intent.putExtra("apellidos",txtApellios.getText().toString())
                intent.putExtra("email",txtEmail.getText().toString())
                startActivity(intent)


            }
        }
    }


    fun mensaje(titulo:String,mensaje:String){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage(mensaje)
            .setTitle(titulo)
            .setPositiveButton("Aceptar") { _, _ ->
                // Do something.
            }
        /*.setNegativeButton("Cancelar") { _, _ ->
            // Do something else.
        }*/

        val dialog: AlertDialog = builder.create()
        dialog.show()
}}
