package e.g.dairien.android_project;

import java.util.LinkedList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RandoAdapter extends ArrayAdapter<Rando> {
    private final Context _context;
    private LinkedList<Rando> _movies;

    public RandoAdapter(Context context, int resource, LinkedList<Rando> movies) {
        super(context, resource, movies);
        _context = context;
        _movies = movies;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fragment_vue_rando, parent, false);
        } else {
            convertView = (LinearLayout) convertView;
        }

        TextView viewTitle = (TextView) convertView.findViewById(R.id.title);
        viewTitle.setText(_movies.get(position).getTitle());
        viewTitle.setTag(_movies.get(position).getTitle());

        TextView viewLieu = (TextView) convertView.findViewById(R.id.lieu);
        viewLieu.setText(_movies.get(position).getPlace());
        viewLieu.setTag(_movies.get(position).getPlace());

        TextView viewDate = (TextView) convertView.findViewById(R.id.date);
        viewDate.setText(_movies.get(position).getDate());
        viewDate.setTag(_movies.get(position).getDate());

        return convertView;
    }
}