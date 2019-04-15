package e.g.dairien.android_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateEventFragment extends Fragment {

    public CreateEventFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_create_event, container, false);

        //Instanciation des boutons de l'interface
        Button CreateButton = (Button) v.findViewById(R.id.vueRando);
        Button mapsButton = v.findViewById(R.id.maps);
        Button catalogueButton = v.findViewById(R.id.catalog);

        final EditText title = v.findViewById(R.id.titleEvent);
        final EditText place = v.findViewById(R.id.lieuEvent);

        //Renvoie sur la vue des randos
        CreateButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Informations sur la rando
                String lieu = place.getText().toString();
                String titre = title.getText().toString();

                //Check fields are not empty
                if(lieu.equals("")|| titre.equals("")){
                    Toast.makeText(getActivity(), "Merci de remplir tout les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                Bundle bundle = new Bundle();
                bundle.putString("titre",titre);
                bundle.putString("lieu", lieu);
                RandoFragment fragment;
                fragment = new RandoFragment();
                fragment.setArguments(bundle);
                loadFragment(fragment);

            }
        }));

        //lance l'activité maps
        mapsButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        }));


        //lance l'activité catalogue
        catalogueButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CatalogueActivity.class);
                startActivity(intent);
            }
        }));
        return v;
    }

    //Load un fragment
    private void loadFragment(Fragment fragment) {
        // load fragment
        getFragmentManager().beginTransaction()
                .replace(((ViewGroup) getView().getParent()).getId(), fragment)
                .addToBackStack(null)
                .commit();
    }
}
