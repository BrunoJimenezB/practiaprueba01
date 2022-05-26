package fisei.uta.ec.practiaprueba01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class actividad2 extends AppCompatActivity {
private EditText editTextNombre;
private Button buttonSiguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        editTextNombre= findViewById(R.id.editTextNombre);
        buttonSiguiente= findViewById(R.id.buttonSiguiente);


    }

    public void onclickSiguiente(View view){
        String nombre="";
        nombre=editTextNombre.getText().toString();
        Intent intent = new Intent(actividad2.this, MainActivity.class);
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }
}