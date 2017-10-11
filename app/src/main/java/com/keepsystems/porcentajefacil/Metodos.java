package com.keepsystems.porcentajefacil;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Metodos extends AppCompatActivity {

    public static final String CALCULATOR_PACKAGE ="com.android.calculator2";
    public static final String CALCULATOR_CLASS ="com.android.calculator2.Calculator";

    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metodos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Intent mIntent = getIntent();
        int metodo = mIntent.getIntExtra("Metodo", 0);
        EvaluarMetodo(metodo);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

    }
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public void Calculadora(View view){
        Intent intent = new Intent();

        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setComponent(new ComponentName(
                CALCULATOR_PACKAGE,
                CALCULATOR_CLASS));
                startActivity(intent);
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this, "funcionanado", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public  void EvaluarMetodo(Integer metodo){

        switch (metodo){
            case 1:
                fragment = new Ganancia();
                break;
            case 2:
                fragment = new Comision();
                break;
            case 3:
                fragment = new PorcentajeSimple();
                break;
            case 4:
                fragment = new Descuento();
                break;
            case 5:
                fragment = new Propina();
                break;
            case 6:
                fragment = new Fracciones();
                break;
            case 7:
                fragment = new Iva();
                break;
            case 8:
                fragment = new AumentoDePrecio();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragment).commit();
    }

}
