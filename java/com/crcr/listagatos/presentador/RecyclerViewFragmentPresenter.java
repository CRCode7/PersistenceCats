package com.crcr.listagatos.presentador;

import android.content.Context;

import com.crcr.listagatos.db.ConstructorContactos;
import com.crcr.listagatos.fragments.IRecyclerViewFragmentView;
import com.crcr.listagatos.pojo.Gato;

import java.util.ArrayList;

/**
 * Created by Criro on 29/08/2017.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Gato> gatos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
            constructorContactos = new ConstructorContactos(context);
            gatos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(gatos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
