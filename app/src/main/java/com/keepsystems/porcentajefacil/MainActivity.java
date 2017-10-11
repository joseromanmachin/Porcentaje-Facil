package com.keepsystems.porcentajefacil;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements  View.OnClickListener{

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnGanancia).setOnClickListener(this);
        findViewById(R.id.btnComicion).setOnClickListener(this);
        findViewById(R.id.btnporcentajesimple).setOnClickListener(this);
        findViewById(R.id.btnDescuento).setOnClickListener(this);
        findViewById(R.id.btnPropina).setOnClickListener(this);
        findViewById(R.id.btnFracciones).setOnClickListener(this);
        findViewById(R.id.btnIva).setOnClickListener(this);
        findViewById(R.id.btnAumento).setOnClickListener(this);

        intent = new Intent(getApplicationContext(),Metodos.class);

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;}

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                DialogFragment  acercade = new Acercade();
                acercade.show(getSupportFragmentManager(),"joseroman");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGanancia:
                intent.putExtra("Metodo",1);
                break;
            case R.id.btnComicion:
                intent.putExtra("Metodo",2);
                break;
            case R.id.btnporcentajesimple:
                intent.putExtra("Metodo",3);
                break;
            case R.id.btnDescuento:
                intent.putExtra("Metodo",4);
                break;
            case R.id.btnPropina:
                intent.putExtra("Metodo",5);
                break;
            case R.id.btnFracciones:
                intent.putExtra("Metodo",6);
                break;
            case R.id.btnIva:
                intent.putExtra("Metodo",7);
                break;
            case R.id.btnAumento:
                intent.putExtra("Metodo",8);
                break;

        }
        startActivity(intent);

    }}