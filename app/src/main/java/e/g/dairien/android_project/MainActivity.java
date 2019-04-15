package e.g.dairien.android_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button startButton = (Button) findViewById(R.id.create_event);
        startButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callAuthentication = new Intent(getApplicationContext(), authentication.class);

                startActivity(callAuthentication);
            }
        }));
    }


}
