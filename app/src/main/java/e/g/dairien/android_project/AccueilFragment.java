package e.g.dairien.android_project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AccueilFragment extends Fragment{

    public AccueilFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_accueil, container, false);
        Button CreateButton = (Button) v.findViewById(R.id.create_event);
        CreateButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callAuthentication = new Intent(getActivity(), authentication.class);
                startActivity(callAuthentication);
            }
        }));

        return v;
    }


}
