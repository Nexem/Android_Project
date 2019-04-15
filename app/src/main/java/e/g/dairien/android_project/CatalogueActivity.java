package e.g.dairien.android_project;

import android.support.design.theme.MaterialComponentsViewInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CatalogueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogue);

        ListView listView = (ListView)findViewById(R.id.listView);

        //

        Materiel chaussure1 = new Materiel("Adidas");
        Materiel chaussure2 = new Materiel("Scarpa");
        Materiel chaussure3 = new Materiel("Millet");
        Materiel chaussure4 = new Materiel("Decathlon");

        Materiel[] materiels = new Materiel[]{chaussure1,chaussure2, chaussure3,chaussure4};


        // android.R.layout.simple_list_item_1 is a constant predefined layout of Android.
        // used to create a ListView with simple ListItem (Only one TextView).

        ArrayAdapter<Materiel> arrayAdapter
                = new ArrayAdapter<Materiel>(this, android.R.layout.simple_list_item_1 , materiels);


        listView.setAdapter(arrayAdapter);
    }
}
