package com.crcr.listagatos;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.crcr.listagatos.Menu_Opciones.AcercaDeActivity;
import com.crcr.listagatos.Menu_Opciones.ContactoActivity;
import com.crcr.listagatos.adapter.GatoAdaptador;
import com.crcr.listagatos.adapter.PageAdapter;
import com.crcr.listagatos.fragments.PerfilFragment;
import com.crcr.listagatos.fragments.RecyclerView1Fragment;
import com.crcr.listagatos.pojo.Gato;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.filename,menu);
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_favorite:
                Intent intent = new Intent(this,UltimosFavoritos.class);
                startActivity(intent);
                return true;
            case R.id.mContacto:
                Intent intent1 = new Intent(this, ContactoActivity.class);
                startActivity(intent1);
                return true;
            case R.id.mAbout:
                Intent intent2 = new Intent(this, AcercaDeActivity.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        /*

        */
        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

        private ArrayList<Fragment> agregarFragments(){
            ArrayList<Fragment> fragments = new ArrayList<>();

            fragments.add(new RecyclerView1Fragment());
            fragments.add(new PerfilFragment());

            return fragments;
        }

            private void setUpViewPager(){
                viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
                tabLayout.setupWithViewPager(viewPager);

                tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
                tabLayout.getTabAt(1).setIcon(R.drawable.cat_footprint);
            }




}
