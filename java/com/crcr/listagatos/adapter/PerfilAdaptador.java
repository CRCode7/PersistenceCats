package com.crcr.listagatos.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.crcr.listagatos.R;
import com.crcr.listagatos.pojo.GatoPerfil;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

/**
 * Created by Criro on 06/06/2017.
 */

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList<GatoPerfil> gatoperfiles;
    Activity activity;

    public PerfilAdaptador(ArrayList<GatoPerfil> gatoPerfiles, Activity activity){
        this.gatoperfiles = gatoPerfiles;
        this.activity = activity;
    }


    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_gatos_profile, parent, false);

        return new PerfilViewHolder(v);

    }

    @Override
    public void onBindViewHolder(PerfilViewHolder holder, int position) {

        final GatoPerfil gatoperfil = gatoperfiles.get(position);

        holder.foto_perfil.setImageResource(gatoperfil.getFoto_perfil());
        holder.Nombregato.setText(gatoperfil.getNombre());

        holder.img1Gato.setImageResource(gatoperfil.getImg1gato());
        holder.nLikes1.setText(gatoperfil.getNlikes1());
        holder.imgLiked1.setImageResource(R.drawable.cat_liked);

        holder.img2Gato.setImageResource(gatoperfil.getImg2gato());
        holder.nLikes2.setText(gatoperfil.getNlikes2());
        holder.imgLiked2.setImageResource(R.drawable.cat_liked);

        holder.img3Gato.setImageResource(gatoperfil.getImg3gato());
        holder.nLikes3.setText(gatoperfil.getNlikes3());
        holder.imgLiked3.setImageResource(R.drawable.cat_liked);
    }

    @Override
    public int getItemCount() {
        return gatoperfiles.size();
    }





    public class PerfilViewHolder extends RecyclerView.ViewHolder {

        private CircularImageView foto_perfil;
        private TextView Nombregato;

        private ImageView img1Gato;
        private TextView nLikes1;
        private ImageView imgLiked1;

        private ImageView img2Gato;
        private TextView nLikes2;
        private ImageView imgLiked2;

        private ImageView img3Gato;
        private TextView nLikes3;
        private ImageView imgLiked3;

        public PerfilViewHolder(View itemView) {
            super(itemView);

            foto_perfil = (CircularImageView) itemView.findViewById(R.id.foto_perfil);
            Nombregato = (TextView) itemView.findViewById(R.id.Nombregato);

            img1Gato = (ImageView) itemView.findViewById(R.id.img1Gato);
            nLikes1 = (TextView) itemView.findViewById(R.id.nLikes1);
            imgLiked1 = (ImageView) itemView.findViewById(R.id.imgLiked1);

            img2Gato = (ImageView) itemView.findViewById(R.id.img2Gato);
            nLikes2 = (TextView) itemView.findViewById(R.id.nLikes2);
            imgLiked2 = (ImageView) itemView.findViewById(R.id.imgLiked2);

            img3Gato = (ImageView) itemView.findViewById(R.id.img3Gato);
            nLikes3 = (TextView) itemView.findViewById(R.id.nLikes3);
            imgLiked3 = (ImageView) itemView.findViewById(R.id.imgLiked3);

        }
    }
}
