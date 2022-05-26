package fisei.uta.ec.practiaprueba01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private EditText editTextnombre1;
private Button buttonSiguiente;
private ListView listViewdatos1;
private EditText valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextnombre1= findViewById(R.id.editTextNombreRegresado);
        buttonSiguiente= findViewById(R.id.buttonSiguiente1);
        valor= findViewById(R.id.editTextValor);
        registerForContextMenu(editTextnombre1);
        Bundle parametros = this.getIntent().getExtras();

        if(parametros !=null){
            String datos = parametros.getString("nombre");
            editTextnombre1.setText(datos);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, cargarDatosList());
        listViewdatos1= findViewById(R.id.listViewDatos);
        listViewdatos1.setAdapter(adapter);
        listViewdatos1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                valor.setText(listViewdatos1.getAdapter().getItem(i).toString());
            }
        });
    }

    public void onclickCargar(View view){
        Intent intent = new Intent(MainActivity.this, actividad2.class);
        startActivity(intent);

    }
    private List<String> cargarDatosList(){
        List<String> datos = new ArrayList<>();
        for (int i = 0 ; i<=10; i++){
            String valor = "Numero "+ i;
            datos.add(valor);
        }
        return datos;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_Imprimir:
               Toast.makeText(this, "Ingreso a imprimir", Toast.LENGTH_SHORT).show();

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_Imprimir:
                Intent intent = new Intent(MainActivity.this, actividad2.class);
                startActivity(intent);
                break;
        }
        return super.onContextItemSelected(item);
    }
}