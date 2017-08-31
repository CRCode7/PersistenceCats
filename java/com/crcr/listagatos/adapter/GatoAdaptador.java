package com.crcr.listagatos.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.crcr.listagatos.db.ConstructorContactos;
import com.crcr.listagatos.pojo.Gato;
import com.crcr.listagatos.R;

import java.util.ArrayList;

/**
 * Created by Criro on 27/05/2017.
 */

public class GatoAdaptador extends RecyclerView.Adapter<GatoAdaptador.GatoViewHolder>  {

    ArrayList<Gato> gatos;
    Activity activity;

    public GatoAdaptador(ArrayList<Gato> gatos, Activity activity){
        this.gatos = gatos;
        this.activity = activity;
    }



    @Override
    public GatoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_gato, parent, false);

        return new GatoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GatoViewHolder holder, int position) {
        final Gato gato = gatos.get(position);
        holder.cvfoto.setImageResource(gato.getFoto());
        holder.btnLike.setImageResource(R.drawable.cat_button);
        holder.cvNombre.setText(gato.getNombre());
        holder.puntuacion.setText(gato.getPuntuacion());
        holder.imgLiked.setImageResource(R.drawable.cat_liked);

        GatoViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + gato.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeGato(gato);
                GatoViewHolder.puntuacion.setText(constructorContactos.obtenerLikesGato(gato));
            }
        });
        }


    @Override
    public int getItemCount() {
        return gatos.size();
    }



    public static class GatoViewHolder extends RecyclerView.ViewHolder{

       private ImageView cvfoto;
       private static ImageView btnLike;
       private TextView cvNombre;
       private static TextView puntuacion;
       private ImageView imgLiked;


       public GatoViewHolder(View itemView) {
           super(itemView);

           cvfoto = (ImageView) itemView.findViewById(R.id.cvfoto);
           btnLike = (ImageView) itemView.findViewById(R.id.btnLike);
           cvNombre = (TextView) itemView.findViewById(R.id.cvNombre);
           puntuacion = (TextView) itemView.findViewById(R.id.puntuacion);
           imgLiked = (ImageView) itemView.findViewById(R.id.imgLiked);
       }
   }


}
