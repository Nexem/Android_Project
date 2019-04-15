package e.g.dairien.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CreateEventFragment extends Fragment {

    public CreateEventFragment() {
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
        View v = inflater.inflate(R.layout.fragment_create_event, container, false);
        Button CreateButton = (Button) v.findViewById(R.id.accueil);
        Button mapsButton = v.findViewById(R.id.maps);

        CreateButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                fragment = new AccueilFragment();
                loadFragment(fragment);
            }
        }));

        mapsButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        }));

        return v;
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        getFragmentManager().beginTransaction()
                .replace(((ViewGroup) getView().getParent()).getId(), fragment)
                .addToBackStack(null)
                .commit();
    }
}
