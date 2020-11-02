package com.example.bancobpm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Home_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_o_m_e__a_c_t);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for(int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }

    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view);
        vf.setFlipInterval(2500);
        vf.setAutoStart(true);
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void Seguridad (View v)
    {
        Intent i = new Intent(this, Seguridad_act.class);
        startActivity(i);
    }

    public void Info(View v)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
    public void prestamos (View v)
    {
        ArrayList<String> listaClientes = new ArrayList<String>();
        ArrayList<String> listaCreditos = new ArrayList<String>();

        listaClientes.add("Axel");
        listaClientes.add("Roxana");

        listaClientes.add("Betzabe");
        listaClientes.add("Matias");

        listaCreditos.add("Credito Hipotecario");
        listaCreditos.add("Credito Automotriz");

        Intent i = new Intent(this, Prestamo_act.class);
        i.putExtra("listaClientes", listaClientes);
        i.putExtra("listaCreditos", listaCreditos);
        startActivity(i);
    }

    public void Clientes(View v)
    {
        Intent i = new Intent(this, Clientes_act.class);
        startActivity(i);
    }


}