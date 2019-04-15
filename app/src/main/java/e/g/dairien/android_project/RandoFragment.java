package e.g.dairien.android_project;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RandoFragment extends Fragment {

    public RandoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_rando, container, false);
        ListView listView = (ListView)v.findViewById(R.id.listView);

        Bundle bundle = this.getArguments();
        if(bundle != null) {
            String title = bundle.getString("titre");
            String place = bundle.getString("lieu");

            Rando randos1 = new Rando(title, place, "19/05/2019");

            Rando[] users = new Rando[]{randos1};

            //Ajoute la rando dans la liste
            ArrayAdapter<Rando> arrayAdapter
                    = new ArrayAdapter<Rando>(getActivity(), android.R.layout.simple_list_item_1, users);
            listView.setAdapter(arrayAdapter);
        }


        return v;
    }
}
