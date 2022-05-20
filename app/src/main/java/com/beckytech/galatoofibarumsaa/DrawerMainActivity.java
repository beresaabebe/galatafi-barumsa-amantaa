package com.beckytech.galatoofibarumsaa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.beckytech.galatoofibarumsaa.contactinfo.ContactInfoActivity;
import com.beckytech.galatoofibarumsaa.dirsaane.DirsaaneActivity;
import com.beckytech.galatoofibarumsaa.ergamoota.ErgamootaActivity;
import com.beckytech.galatoofibarumsaa.faarsaa.FaarfannaaActivity;
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
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.navigation.NavigationView;

public class DrawerMainActivity extends AppCompatActivity {

    public InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_main);

        MobileAds.initialize(this, initializationStatus -> {});

        setAds();

        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navigationView = findViewById(R.id.navigationView);

       setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer
        );

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menuGalataMariam) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(DrawerMainActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            startActivity(new Intent(DrawerMainActivity.this, GalataMaariyaam.class));
                            mInterstitialAd = null;
                            setAds();
                        }
                    });
                } else {
                    startActivity(new Intent(this, GalataMaariyaam.class));
                }
            }
            if (item.getItemId() == R.id.menuGalataGooftaa) {
                startActivity(new Intent(this, GalataGooftaaActivity.class));
            }
            if (item.getItemId() == R.id.menuGalataLixonni) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(DrawerMainActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            startActivity(new Intent(DrawerMainActivity.this, LixoonniiActivity.class));
                            mInterstitialAd = null;
                            setAds();
                        }
                    });
                } else {
                    startActivity(new Intent(this, LixoonniiActivity.class));
                }
            }
            if (item.getItemId() == R.id.menuDirsaane) {
                startActivity(new Intent(this, DirsaaneActivity.class));
            }
            if (item.getItemId() == R.id.menuGalataMalkaa) {
                startActivity(new Intent(this, MalkaaActivity.class));
            }
            if (item.getItemId() == R.id.menuKadhannaaWaadaa) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(DrawerMainActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            startActivity(new Intent(DrawerMainActivity.this, WaadaaActivity.class));
                            mInterstitialAd = null;
                            setAds();
                        }
                    });
                } else {
                    startActivity(new Intent(this, WaadaaActivity.class));
                }
            }
            if (item.getItemId() == R.id.menuKadhannaaBarbaachisaa) {
                startActivity(new Intent(this, KadhannaaBarbaachisoActivity.class));
            }
            if (item.getItemId() == R.id.menuFaaruuDaawit) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(DrawerMainActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            startActivity(new Intent(DrawerMainActivity.this, FaaruuDaawitActivity.class));
                            mInterstitialAd = null;
                            setAds();
                        }
                    });
                } else {
                    startActivity(new Intent(this, FaaruuDaawitActivity.class));
                }
            }
            if (item.getItemId() == R.id.menuErgamoota) {
                startActivity(new Intent(this, ErgamootaActivity.class));
            }
            if (item.getItemId() == R.id.menuHibuat) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(DrawerMainActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            startActivity(new Intent(DrawerMainActivity.this, HibuatActivity.class));
                            mInterstitialAd = null;
                            setAds();
                        }
                    });
                } else {
                    startActivity(new Intent(this, HibuatActivity.class));
                }
            }
            if (item.getItemId() == R.id.menuSeeraaLaphee) {
                startActivity(new Intent(this, SeeraLapheeActivity.class));
            }
            if (item.getItemId() == R.id.menuSeeraaOoritii) {
                startActivity(new Intent(this, SeeraaOoritiiActivity.class));
            }
            if (item.getItemId() == R.id.menuRaajotaGurguddoo) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(DrawerMainActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            startActivity(new Intent(DrawerMainActivity.this, RaajotaGurgudooActivity.class));
                            mInterstitialAd = null;
                            setAds();
                        }
                    });
                } else {
                    startActivity(new Intent(this, RaajotaGurgudooActivity.class));
                }
            }
            if (item.getItemId() == R.id.menuRaajotaXixiqqoo) {
                startActivity(new Intent(this, RaajotaXixiqqooActivity.class));
            }

            if (item.getItemId() == R.id.menuOtherSite) {
                startActivity(new Intent(this, ContactInfoActivity.class));
            }

            if (item.getItemId() == R.id.menuFaarfannaa) {
                startActivity(new Intent(this, FaarfannaaActivity.class));
            }

            if (item.getItemId() == R.id.menuAboutUs) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(DrawerMainActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            startActivity(new Intent(DrawerMainActivity.this, AboutActivity.class));
                            mInterstitialAd = null;
                            setAds();
                        }
                    });
                } else {
                    startActivity(new Intent(this, AboutActivity.class));
                }
            }

            if(item.getItemId() == R.id.menuShareApp) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT," Galatoofi Barumsaa Amantaa");
                String message = "\n Yeroon app kana sif erguu baay'een gammada, Waaqayyonis nan galateeffaadha. Appn kun sinis akkumaa koo si gargaraa jedhe waanan yaadeef sif erguuf filaadherraa.\n" +
                        "Atillee nama biroo qoodi!";
                message = message + "https://play.google.com/store/apps/details?id=com.beckytech.galatoofibarumsaa";
                intent.putExtra(Intent.EXTRA_TEXT, message);
                startActivity(intent);
            }

            if (item.getItemId() == R.id.rating_app) {
                String url = "https://play.google.com/store/apps/details?id=com.beckytech.galatoofibarumsaa";
                Intent  intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }

            if (item.getItemId() == R.id.menuExitApp) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Cufu barbada?");
                builder.setTitle("Cufi");
//                builder.setIcon(R.drawable.ic_close_app);
                builder.setPositiveButton("Eyyeen", (dialogInterface, i) -> {
                    finishAffinity();
                    finish();
                });
                builder.setNegativeButton("Lakki", (dialogInterface, i) -> dialogInterface.dismiss());
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
            builder.setPositiveButton("Eeyyen", (dialogInterface, i) -> {
                finishAffinity();
                finish();
            });
            builder.setNegativeButton("Lakki", (dialogInterface, i) -> dialogInterface.dismiss());
            builder.show();
        }

        if(item.getItemId() == R.id.menuShareApp) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT," Galatoofi Barumsaa Amantaa");
            String message = "\n Yeroon app kana sif erguu baay'een gammada, Waaqayyonis nan galateeffaadha. Appn kun sinis akkumaa koo si gargaraa jedhe waanan yaadeef sif erguuf filaadherraa.\n" +
                    "Atillee nama biroo qoodi!";
            message = message + "https://play.google.com/store/apps/details?id=com.beckytech.galatoofibarumsaa";
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
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

    public void setAds() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,getString(R.string.interstitial_ad_unit_id), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                    }
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
    }
}