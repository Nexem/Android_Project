package e.g.dairien.android_project;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class authentication extends AppCompatActivity {

    AlphaAnimation inAnimation;
    AlphaAnimation outAnimation;

    FrameLayout progressBarHolder;
    Button auth;

    protected TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        auth = findViewById(R.id.auth);
        progressBarHolder = (FrameLayout) findViewById(R.id.progressBarHolder);

        Bundle extras = getIntent().getExtras();
        //final String loginUser = new String(extras.getString("login"));
        //String timeUser = new String(extras.getString("time"));

        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText pwdUser = (EditText)findViewById(R.id.pwdUser);
                final String pwd = pwdUser.getText().toString();
                String result = null;
                switch (v.getId()) {
                    case R.id.auth:
                        Credentials mycreds = new Credentials("oks",pwd);
                        try {
                            result = new MyTask().execute(mycreds,null,null).get();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                }
                System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + result);
                if(result.equals("ok")){
                    Intent callMain = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(callMain);
                }
            }
        });


    }

    private class MyTask extends AsyncTask<Credentials , String , String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            auth.setEnabled(false);
            inAnimation = new AlphaAnimation(0f, 1f);
            inAnimation.setDuration(200);
            progressBarHolder.setAnimation(inAnimation);
            progressBarHolder.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            outAnimation = new AlphaAnimation(1f, 0f);
            outAnimation.setDuration(200);
            progressBarHolder.setAnimation(outAnimation);
            progressBarHolder.setVisibility(View.GONE);
            resultView.setText(result);
            auth.setEnabled(true);
        }

        @Override
        protected String doInBackground(Credentials... mycreds) {

            Credentials creds = mycreds[0];
            URL url;
            HttpURLConnection urlConnection = null;
            String res = "";

            try {
                url = new URL("http://www.univ-orleans.fr/lifo/Members/Jean-Francois.Lalande/dev/service.php?login="+ creds.getId() +"&password="+creds.getPwd());
                urlConnection = (HttpURLConnection)url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                res = readStream(in);
                resultView.setText(res);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return res;
        }

        private String readStream(InputStream is) throws IOException{
            BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
            String line = r.readLine();
            is.close();
            return line;
        }
    }
}
