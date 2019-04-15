package e.g.dairien.android_project;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

public class VueRandoFragment extends Fragment {

    public VueRandoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_vue_rando, container, false);
        LinkedList<Rando> randos = new LinkedList<Rando>();

        randos.add(new Rando("Sortie weekend","Vosges","19/05/2019"));
        randos.add(new Rando("Vacances été","Alpes","24/07/2019"));
        RandoAdapter adapter = new RandoAdapter(getActivity(), R.layout.fragment_vue_rando, randos);
        ListView list_movies = (ListView) v.findViewById(R.id.list_movies);
        list_movies.setAdapter(adapter);
        list_movies.setOnItemClickListener(listview_listerner);




        return v;
    }

    AdapterView.OnItemClickListener listview_listerner = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
            View titleView = view.findViewById(R.id.title);
            String title = (String) titleView.getTag();
            Toast.makeText(getActivity(), title, Toast.LENGTH_SHORT).show();
        }
    };
}
