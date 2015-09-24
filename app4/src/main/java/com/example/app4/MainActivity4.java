package com.example.app4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    String aux_fig;
    private EditText etBase, etAltura, etRadio, etLado;
    private TextView tvBase, tvAltura, tvRadio, tvLado, tvArea;
    private RadioButton rbtnCirc, rbtnCuad, rbtnTriang, rbtnRect;
    private Button btnAreaCirc;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

         etBase = (EditText) findViewById(R.id.id_etBase);
         etAltura = (EditText) findViewById(R.id.id_etAltura);
         etRadio = (EditText) findViewById(R.id.id_etRadio);
         etLado = (EditText) findViewById(R.id.id_etLado);

         tvBase = (TextView) findViewById(R.id.id_tvBase);
         tvAltura = (TextView) findViewById(R.id.id_tvAltura);
         tvRadio = (TextView) findViewById(R.id.id_tvRadio);
         tvLado = (TextView) findViewById(R.id.id_tvLado);
         tvArea = (TextView) findViewById(R.id.id_AreaResul);

         rbtnCirc = (RadioButton) findViewById(R.id.id_rbtnCirc);
         rbtnCuad = (RadioButton) findViewById(R.id.id_rbtnCuad);
         rbtnTriang = (RadioButton) findViewById(R.id.id_rbtnTriang);
         rbtnRect = (RadioButton) findViewById(R.id.id_rbtnRect);

        //final TextView tvAreaResul = (TextView) findViewById(R.id.id_AreaResul);
        btnAreaCirc = (Button) findViewById(R.id.id_btnAreaCirc);

         btnAreaCirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aux_base, aux_altura, aux_radio, aux_lado, area;

                try {
                    //aux_base = Double.parseDouble(etBase.getText().toString());
                    //aux_altura = Double.parseDouble(etAltura.getText().toString());

                    //aux_lado = Double.parseDouble(etLado.getText().toString());
                    switch (aux_fig){
                        case "1":   aux_radio = Double.parseDouble(etRadio.getText().toString());
                            aux_altura = aux_base = aux_lado = 0;
                            area = (Math.PI)*(Math.pow(aux_radio,2));
                            tvArea.setText(String.format("%.2f",area));
                            break;
                        case "2":   aux_lado = Double.parseDouble(etLado.getText().toString());
                            aux_altura = aux_base = aux_radio = 0;
                            area = Math.pow(aux_lado,2);
                            tvArea.setText(String.format("%.2f",area));
                            break;
                        case "3":   aux_base = Double.parseDouble(etBase.getText().toString());
                                    aux_altura = Double.parseDouble(etAltura.getText().toString());
                            aux_lado = aux_radio = 0;
                            area = (aux_base*aux_altura)/2;
                            tvArea.setText(String.format("%.2f",area));
                            break;
                        case "4":   aux_base = Double.parseDouble(etBase.getText().toString());
                            aux_altura = Double.parseDouble(etAltura.getText().toString());
                            aux_lado = aux_radio = 0;
                            area = aux_base*aux_altura;
                            tvArea.setText(String.format("%.2f",area));
                            break;

                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivity4.this, "¡Advertencia!\n" +
                            "Llenar los campos restantes y/o seleccionar una figura geométrica.", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        tvArea.setText("____");
        if(rbtnCirc.isChecked()){
             etBase.setVisibility(View.INVISIBLE); tvBase.setVisibility(View.INVISIBLE);
             etAltura.setVisibility(View.INVISIBLE); tvAltura.setVisibility(View.INVISIBLE);
             etRadio.setVisibility(View.VISIBLE); tvRadio.setVisibility(View.VISIBLE);
             etLado.setVisibility(View.INVISIBLE); tvLado.setVisibility(View.INVISIBLE);
             aux_fig ="1";
        }
        if(rbtnCuad.isChecked()){
            etBase.setVisibility(View.INVISIBLE); tvBase.setVisibility(View.INVISIBLE);
            etAltura.setVisibility(View.INVISIBLE); tvAltura.setVisibility(View.INVISIBLE);
            etRadio.setVisibility(View.INVISIBLE); tvRadio.setVisibility(View.INVISIBLE);
            etLado.setVisibility(View.VISIBLE); tvLado.setVisibility(View.VISIBLE);
            aux_fig ="2";
        }
        if(rbtnTriang.isChecked()){
            etBase.setVisibility(View.VISIBLE); tvBase.setVisibility(View.VISIBLE);
            etAltura.setVisibility(View.VISIBLE); tvAltura.setVisibility(View.VISIBLE);
            etRadio.setVisibility(View.INVISIBLE); tvRadio.setVisibility(View.INVISIBLE);
            etLado.setVisibility(View.INVISIBLE); tvLado.setVisibility(View.INVISIBLE);
            aux_fig ="3";
        }
        if(rbtnRect.isChecked()){
            etBase.setVisibility(View.VISIBLE); tvBase.setVisibility(View.VISIBLE);
            etAltura.setVisibility(View.VISIBLE); tvAltura.setVisibility(View.VISIBLE);
            etRadio.setVisibility(View.INVISIBLE); tvRadio.setVisibility(View.INVISIBLE);
            etLado.setVisibility(View.INVISIBLE); tvLado.setVisibility(View.INVISIBLE);
            aux_fig ="4";
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity4, menu);
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
