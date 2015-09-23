package com.camilobetancur.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    String aux_oper= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final EditText etNum1 = (EditText) findViewById(R.id.id_etNum1);
        final EditText etNum2 = (EditText) findViewById(R.id.id_etNum2);
        final TextView tvResul = (TextView) findViewById(R.id.id_tvResulAqui);
//        RadioGroup rgOperaciones = (RadioGroup) findViewById(R.id.id_rgOperaciones);
        final Button Calcular = (Button) findViewById(R.id.id_btnCalcular);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aux_resul, aux_num1, aux_num2;
                try {
                    aux_num1 = Double.parseDouble(etNum1.getText().toString());
                    aux_num2 = Double.parseDouble(etNum2.getText().toString());
                    switch (aux_oper) {
                        case "1":
                            aux_resul = aux_num1 + aux_num2;
                            tvResul.setText(String.valueOf(aux_resul));
                            break;
                        case "2":
                            aux_resul = aux_num1 - aux_num2;
                            tvResul.setText(String.valueOf(aux_resul));
                            break;
                        case "3":
                            aux_resul = aux_num1 * aux_num2;
                            tvResul.setText(String.valueOf(aux_resul));
                            break;
                        case "4":
                            if (aux_num2==0){
                                tvResul.setText(" Math Error...");
                                break;
                            }else{
                            aux_resul = aux_num1 / aux_num2;
                            tvResul.setText(String.valueOf(aux_resul));
                            break;
                            }
                    }
                }catch(Exception e) {
                    Toast.makeText(MainActivity2.this,"¡Advertencia!\nLlenar los campos restantes y/o seleccionar la operación a realizar.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
         switch (view.getId()) {
                case R.id.id_rbtnSuma:
                    if (checked)
                        aux_oper = "1";
                    break;
                case R.id.id_rbtnResta:
                    if (checked)
                        aux_oper = "2";
                    break;
                case R.id.id_rbtnMulti:
                    if (checked)
                        aux_oper = "3";
                    break;
                case R.id.id_rbtnDivi:
                    if (checked)
                        aux_oper = "4";
                    break;
                default:    Toast.makeText(MainActivity2.this,"Seleccione la operación a realizar.", Toast.LENGTH_SHORT).show();
                    break;
         }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
