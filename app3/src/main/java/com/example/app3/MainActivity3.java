package com.example.app3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final EditText etQuiz = (EditText) findViewById(R.id.id_quiz);
        final EditText etExpo = (EditText) findViewById(R.id.id_expo);
        final EditText etLab = (EditText) findViewById(R.id.id_lab);
        final EditText etP_final = (EditText) findViewById(R.id.id_final);
        final Button btnCalc = (Button) findViewById(R.id.id_btnCalc);
        final TextView tvNota = (TextView) findViewById(R.id.id_Nota_final);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aux_quiz, aux_expo, aux_lab, aux_p_final, nota;
                try {
                    aux_quiz = Double.parseDouble(etQuiz.getText().toString());
                    aux_expo = Double.parseDouble(etExpo.getText().toString());
                    aux_lab = Double.parseDouble(etLab.getText().toString());
                    aux_p_final = Double.parseDouble(etP_final.getText().toString());
                    nota = aux_quiz * 0.15 + aux_expo * 0.1 + aux_lab * 0.4 + aux_p_final * 0.35;
                    tvNota.setText(String.valueOf(nota));
                }catch(Exception e) {
                    //aux_quiz = 0; aux_expo = 0; aux_lab = 0; aux_p_final = 0;
                    Toast.makeText(MainActivity3.this,"¡Operación inválida!\nEs necesario completar los campos vacíos.", Toast.LENGTH_SHORT).show();
                }
                //nota = aux_quiz * 0.15 + aux_expo * 0.1 + aux_lab * 0.4 + aux_p_final * 0.35;
                //tvNota.setText(String.valueOf(nota));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
