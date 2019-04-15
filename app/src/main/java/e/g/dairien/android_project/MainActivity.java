package e.g.dairien.android_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.BottomNavigationView;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("Accueil");

        Button startButton = (Button) findViewById(R.id.create_event);
        startButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callAuthentication = new Intent(getApplicationContext(), authentication.class);

                startActivity(callAuthentication);
            }
        }));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment;
                    switch (item.getItemId()) {
                        case R.id.nav_event:
                            toolbar.setTitle("Créer Event");
                            return true;
                        case R.id.nav_accueil:
                            toolbar.setTitle("Accueil");
                            return true;
                        case R.id.nav_randos:
                            toolbar.setTitle("Vue Randos");
                            return true;
                    }
                    return false;
                }
            };


}
