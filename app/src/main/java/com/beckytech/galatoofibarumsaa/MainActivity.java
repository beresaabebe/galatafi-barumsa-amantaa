package com.beckytech.galatoofibarumsaa;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.beckytech.galatoofibarumsaa.contactinfo.ContactInfoActivity;
import com.beckytech.galatoofibarumsaa.dirsaane.DirsaaneActivity;
import com.beckytech.galatoofibarumsaa.ergamoota.ErgamootaActivity;
import com.beckytech.galatoofibarumsaa.galatagooftaa.GalataGooftaaActivity;
import com.beckytech.galatoofibarumsaa.galatamaariyaam.GalataMaariyaam;
import com.beckytech.galatoofibarumsaa.hibuat.HibuatActivity;
import com.beckytech.galatoofibarumsaa.kadhannaabarbaachiso.FaaruuDaawitActivity;
import com.beckytech.galatoofibarumsaa.kadhannaabarbaachiso.KadhannaaBarbaachisoActivity;
import com.beckytech.galatoofibarumsaa.lixoonii.LixoonniiActivity;
import com.beckytech.galatoofibarumsaa.malkaa.MalkaaActivity;
import com.beckytech.galatoofibarumsaa.raajotagurguddoo.RaajotaGurgudooActivity;
import com.beckytech.galatoofibarumsaa.raajotaxixiqqoo.RaajotaXixiqqooActivity;
import com.beckytech.galatoofibarumsaa.seeralaphee.SeeraLapheeActivity;
import com.beckytech.galatoofibarumsaa.seeraooritii.SeeraaOoritiiActivity;
import com.beckytech.galatoofibarumsaa.waadaa.WaadaaActivity;
import com.google.android.material.navigation.NavigationView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imageMenu).setOnClickListener(view -> drawerLayout.openDrawer(GravityCompat.START));

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.menuHome, R.id.menuGalataMariam, R.id.menuGalataGooftaa,
                R.id.menuGalataLixonni, R.id.menuGalataMalkaa
        ).setOpenableLayout(drawerLayout).build();

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView,navController);

        final TextView textTitle = findViewById(R.id.textTitle);

        navController.addOnDestinationChangedListener((navController1, navDestination, bundle) -> textTitle.setText(navDestination.getLabel()));

        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(item -> {

            if (item.getItemId() == R.id.menuGalataMariam) {
                startActivity(new Intent(this, GalataMaariyaam.class));
            }
            if (item.getItemId() == R.id.menuGalataGooftaa) {
                startActivity(new Intent(this, GalataGooftaaActivity.class));
            }
            if (item.getItemId() == R.id.menuGalataLixonni) {
                startActivity(new Intent(this, LixoonniiActivity.class));
            }
            if (item.getItemId() == R.id.menuDirsaane) {
                startActivity(new Intent(this, DirsaaneActivity.class));
            }
            if (item.getItemId() == R.id.menuGalataMalkaa) {
                startActivity(new Intent(this, MalkaaActivity.class));
            }
            if (item.getItemId() == R.id.menuKadhannaaWaadaa) {
                startActivity(new Intent(this, WaadaaActivity.class));
            }
            if (item.getItemId() == R.id.menuKadhannaaBarbaachisaa) {
                startActivity(new Intent(this, KadhannaaBarbaachisoActivity.class));
            }
            if (item.getItemId() == R.id.menuFaaruuDaawit) {
                startActivity(new Intent(this, FaaruuDaawitActivity.class));
            }
            if (item.getItemId() == R.id.menuErgamoota) {
                startActivity(new Intent(this, ErgamootaActivity.class));
            }
            if (item.getItemId() == R.id.menuHibuat) {
                startActivity(new Intent(this, HibuatActivity.class));
            }
            if (item.getItemId() == R.id.menuSeeraaLaphee) {
                startActivity(new Intent(this, SeeraLapheeActivity.class));
            }
            if (item.getItemId() == R.id.menuSeeraaOoritii) {
                startActivity(new Intent(this, SeeraaOoritiiActivity.class));
            }
            if (item.getItemId() == R.id.menuRaajotaGurguddoo) {
                startActivity(new Intent(this, RaajotaGurgudooActivity.class));
            }
            if (item.getItemId() == R.id.menuRaajotaXixiqqoo) {
                startActivity(new Intent(this, RaajotaXixiqqooActivity.class));
            }

            if (item.getItemId() == R.id.menuOtherSite) {
                startActivity(new Intent(this, ContactInfoActivity.class));
            }

            if (item.getItemId() == R.id.menuAboutUs) {
                startActivity(new Intent(this, AboutActivity.class));
            }

            if (item.getItemId() == R.id.menuExitApp) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Cufu barbada?");
                builder.setTitle("Cufi");
                builder.setIcon(R.drawable.ic_close_app);
                builder.setPositiveButton("Eyyeen",(dialogInterface, i) -> {
                    finishAffinity();
                    finish();
                });
                builder.setNegativeButton("Lakki",(dialogInterface, i) -> dialogInterface.dismiss());
                builder.show();
            }

            return true;
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuExitApp) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.ic_close_app);
            builder.setTitle("Cufi");
            builder.setCancelable(true);
            builder.setPositiveButton("Eyyeen", (dialogInterface, i) -> {
                finishAffinity();
                finish();
            });
            builder.setNegativeButton("Lakki", (dialogInterface, i) -> dialogInterface.dismiss());
            builder.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

   public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
        }
        else {
            getSupportFragmentManager().popBackStack();
        }
    }
}