package com.crcr.listagatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.crcr.listagatos.adapter.GatoAdaptador;
import com.crcr.listagatos.pojo.Gato;

import java.util.ArrayList;

public class UltimosFavoritos extends AppCompatActivity {

    ArrayList<Gato> gatos;
    private RecyclerView listaGatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ultimos_favoritos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaGatos = (RecyclerView) findViewById(R.id.rvGatos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaGatos.setLayoutManager(llm);

        inicializarListaGatos();
        inicializaAdaptador();
    }

    public void inicializarListaGatos(){
        gatos = new ArrayList<Gato>();

        gatos.add(new Gato(R.drawable.onegatosomali,"Gato Somali","3"));
        gatos.add(new Gato(R.drawable.twogatohimalayo,"Gato Himalayo","4"));
        gatos.add(new Gato(R.drawable.threecymric,"Cymric","2"));
        gatos.add(new Gato(R.drawable.foursnowshoe,"Snowshoe","5"));
        gatos.add(new Gato(R.drawable.fivegatopersa,"Gato Persa","4"));
    }

    public void inicializaAdaptador(){
        GatoAdaptador adaptador = new GatoAdaptador(gatos, this);
        listaGatos.setAdapter(adaptador);
    }
}
