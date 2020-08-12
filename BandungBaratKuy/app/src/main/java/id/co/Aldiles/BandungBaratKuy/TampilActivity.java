package id.co.Aldiles.BandungBaratKuy;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;


public class TampilActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Home_Fragment home_fragment;
    private TampilFragment wisata_fragment;

    private TampilFragment cikole, dagodreampark, curugcimahi, curugmaribaya, floatingmarket, wonderland, parkzoo, rancaupas,
            tangkubanperahu, derhans,sungai;


    private Button bDirection;
    private LatLng dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Fragment
        wisata_fragment = new TampilFragment(R.layout.fragment_wisata);


        //Wisata
        cikole = new TampilFragment(R.layout.cikole);
        dagodreampark = new TampilFragment(R.layout.dagodreampark);
        curugcimahi = new TampilFragment(R.layout.curugcimahi);
        curugmaribaya = new TampilFragment(R.layout.curugmaribaya);
        floatingmarket = new TampilFragment(R.layout.floatingmarket);
        wonderland= new TampilFragment(R.layout.wonderland);
        parkzoo = new TampilFragment(R.layout.parkzoo);
        rancaupas = new TampilFragment(R.layout.rancaupas);
        tangkubanperahu = new TampilFragment(R.layout.tangkubanperahu);
        derhans = new TampilFragment(R.layout.derhans);
        sungai = new TampilFragment(R.layout.sungai);



        home_fragment = new Home_Fragment(this);
        pushFragment(home_fragment);

        bDirection = findViewById(R.id.direction);
        bDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dir != null){
                    Intent i = new Intent("android.intent.action.MAPS");
                    i.putExtra("Lat", dir.latitude);
                    i.putExtra("Lon", dir.longitude);
                    startActivity(i);
                }else{
                    Toast.makeText(TampilActivity.this, "Coming soon!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        bDirection.setVisibility(View.GONE);

        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case R.id.nav_home:
                pushFragment(home_fragment);
                break;
            case R.id.nav_wisata:
                pushFragment(wisata_fragment);
                break;


            //Tentang
            case R.id.nav_tentang_aplikasi:
                final Dialog dialog = new Dialog(this, R.style.dialog_notitle);
                dialog.setContentView(R.layout.tentang_aplikasi);
                dialog.show();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    //Wisata Fragment
    public void wisata(View v) {
        switch (v.getId()) {
            case R.id.wisata1:

                pushFragment(cikole);
                dir = new LatLng(-6.782434, 107.650268);
                break;
            case R.id.wisata2:
                pushFragment(dagodreampark);
                dir = new LatLng(-6.847448, 107.625543);
                break;
            case R.id.wisata3:
                pushFragment(curugcimahi);
                dir = new LatLng(-6.799315, 107.577510);
                break;
            case R.id.wisata4:
                pushFragment(curugmaribaya);
                dir = new LatLng(-6.831833, 107.655869);
                break;
            case R.id.wisata5:
                pushFragment(floatingmarket);
                dir = new LatLng(-6.818605, 107.617978);
                break;
            case R.id.wisata6:
                pushFragment(wonderland);
                dir = new LatLng(-6.816875, 107.612491);
                break;
            case R.id.wisata7:
                pushFragment(parkzoo);
                dir = new LatLng(-6.805969, 107.592058);
                break;
            case R.id.wisata8:
                pushFragment(rancaupas);
                dir = new LatLng(-7.138204, 107.392227);
                break;
            case R.id.wisata9:
                pushFragment(tangkubanperahu);
                dir = new LatLng(-6.759748, 107.616169);
                break;
            case R.id.wisata10:
                pushFragment(derhans);
                dir = new LatLng(-6.815171, 107.626620);
                break;
            case R.id.wisata11:
                pushFragment(sungai);
                dir = new LatLng(-6.904985, 107.354939);
                break;

        }
        bDirection.setVisibility(View.VISIBLE);
    }




    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.rootLayout, fragment);
                ft.commit();
            }
        }
    }
}
