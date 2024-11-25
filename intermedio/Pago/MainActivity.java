package com.example.nuevo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner combito;
    ArrayAdapter<Clasesita> adaptadorcito;
    Arraysito Akekitas;
    ArrayList<Clasesita> Aregreso = new ArrayList<>();
    TextView vistita;
    EditText cantidadEditText;
    Button agregarCarritoButton, botonPagoButton;

    Carrito carrito = new Carrito();
    Paguito paguito = new Paguito();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        vistita = findViewById(R.id.vista);
        cantidadEditText = findViewById(R.id.cantidad);
        agregarCarritoButton = findViewById(R.id.agregar_carrito);
        botonPagoButton = findViewById(R.id.boton_pago);

        Akekitas = new Arraysito();
        Aregreso = Akekitas.regresa();

        combito = findViewById(R.id.combo);
        combito.setOnItemSelectedListener(this);

        adaptadorcito = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Aregreso);
        combito.setAdapter(adaptadorcito);

        agregarCarritoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarAlCarrito();
            }
        });

        botonPagoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paguito.mostrarPago(MainActivity.this, carrito);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position > 0) {
            Clasesita objetito = (Clasesita) combito.getSelectedItem();
            String cadenita = "clave: " + objetito.getClave() + "\n" + "deque: " + objetito.toString() + "\n" + "costo: " + objetito.getCosto();
            vistita.setText(cadenita);
        } else if (position == 0) {
            vistita.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void agregarAlCarrito() {
        Clasesita seleccion = (Clasesita) combito.getSelectedItem();
        String cantidadStr = cantidadEditText.getText().toString();

        int cantidad = Integer.parseInt(cantidadStr);
        carrito.agregarAlCarrito(seleccion, cantidad);
        Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();

    }
}