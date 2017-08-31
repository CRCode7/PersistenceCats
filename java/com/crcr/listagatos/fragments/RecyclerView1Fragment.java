package com.crcr.listagatos.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crcr.listagatos.R;
import com.crcr.listagatos.adapter.GatoAdaptador;
import com.crcr.listagatos.pojo.Gato;
import com.crcr.listagatos.presentador.IRecyclerViewFragmentPresenter;
import com.crcr.listagatos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by Criro on 05/06/2017.
 */

public class RecyclerView1Fragment extends Fragment implements IRecyclerViewFragmentView{

    ArrayList<Gato> gatos;
    private RecyclerView listaGatos;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview1, container, false);


        listaGatos = (RecyclerView) v.findViewById(R.id.rvGatos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

    /*
    public void inicializarListaGatos(){

    }
    */


    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaGatos.setLayoutManager(llm);

    }

    @Override
    public GatoAdaptador crearAdaptador(ArrayList<Gato> gatos) {
        GatoAdaptador adaptador = new GatoAdaptador(gatos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(GatoAdaptador adaptador) {
        listaGatos.setAdapter(adaptador);
    }
}
