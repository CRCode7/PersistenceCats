package com.crcr.listagatos.fragments;

import com.crcr.listagatos.pojo.Gato;
import com.crcr.listagatos.adapter.GatoAdaptador;

import java.util.ArrayList;

/**
 * Created by Criro on 26/08/2017.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public GatoAdaptador crearAdaptador(ArrayList<Gato> gatos);

    public void inicializarAdaptadorRV(GatoAdaptador adaptador);

}
