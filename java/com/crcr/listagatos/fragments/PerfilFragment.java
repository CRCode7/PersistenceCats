package com.crcr.listagatos.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crcr.listagatos.R;
import com.crcr.listagatos.adapter.PerfilAdaptador;
import com.crcr.listagatos.pojo.GatoPerfil;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {


   ArrayList<GatoPerfil> gatoperfiles;
    private RecyclerView rvPerfil_Gatos;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvPerfil_Gatos = (RecyclerView) v.findViewById(R.id.rvPerfil_Gatos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //GridLayoutManager glm = new GridLayoutManager(getActivity(),4);
        //glm.setOrientation(GridLayoutManager.VERTICAL);

        rvPerfil_Gatos.setLayoutManager(llm);

        inicializarPerfilGatos();
        inicializaAdaptador2();

        return v;
    }

    public void inicializarPerfilGatos(){
        gatoperfiles = new ArrayList<GatoPerfil>();

        gatoperfiles.add(new GatoPerfil(R.drawable.onegatosomali,"Gato Somali",R.drawable.onegatosomali,"3",R.drawable.gatosomali2,"4",R.drawable.gatosomali3,"4"));
        gatoperfiles.add(new GatoPerfil(R.drawable.twogatohimalayo,"Gato Himalayo",R.drawable.twogatohimalayo,"4",R.drawable.gatohimalayo2,"5",R.drawable.gatohimalayo3,"4"));
        gatoperfiles.add(new GatoPerfil(R.drawable.threecymric,"Gato Cymric",R.drawable.threecymric,"2",R.drawable.cymric2,"3",R.drawable.cymric3,"4"));
        gatoperfiles.add(new GatoPerfil(R.drawable.foursnowshoe,"Gato Snowshoe",R.drawable.foursnowshoe,"5",R.drawable.snowshoe2,"5",R.drawable.snowshoe3,"4"));
        gatoperfiles.add(new GatoPerfil(R.drawable.fivegatopersa,"Gato Persa",R.drawable.fivegatopersa,"4",R.drawable.gatopersa2,"5",R.drawable.gatopersa3,"4"));
    }

    public void inicializaAdaptador2(){
        PerfilAdaptador adaptador = new PerfilAdaptador(gatoperfiles, getActivity());
        rvPerfil_Gatos.setAdapter(adaptador);
    }

}
