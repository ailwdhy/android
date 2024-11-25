package com.example.dobletriple;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button botoncito;
EditText editadito;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        botoncito=findViewById(R.id.boton);
        botoncito.setOnClickListener(this);
        editadito=findViewById(R.id.texto);
    }
    @Override
    public void onClick(View v) {
        String cadenita =((Button)v).getText().toString();
        Clasesita objetito = new Clasesita();
        objetito.setDatito(Integer.parseInt(editadito.getText().toString()));
          if (cadenita.equals("doble")) {
              Toast.makeText(this,"res"+objetito.doble(),
              Toast.LENGTH_LONG).show();
     botoncito.setText("triple");
 }
          else
          if (cadenita.equals("triple")) {
              Toast.makeText(this,"res"+objetito.triple(),
                      Toast.LENGTH_LONG).show();
              botoncito.setText("doble");
    }
}
}