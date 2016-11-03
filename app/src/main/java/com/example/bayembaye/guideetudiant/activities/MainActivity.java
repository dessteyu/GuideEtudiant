package com.example.bayembaye.guideetudiant.activities;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bayembaye.guideetudiant.Drivers.Drivers;
import com.example.bayembaye.guideetudiant.R;
import com.example.bayembaye.guideetudiant.adaptateurs.AdaptateurAide;
import com.example.bayembaye.guideetudiant.objectes.Aide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AdaptateurAide adaptateuraide;
    private ListView listViewAide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        adaptateuraide = new AdaptateurAide(this, Drivers.LISTAIDE);
        listViewAide = (ListView)findViewById(R.id.listViewAide);
        listViewAide.setAdapter(adaptateuraide);
        listViewAide.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = Drivers.LISTAIDE[i];
                Toast.makeText(getApplicationContext(),selectedItem+" is selected ",Toast.LENGTH_SHORT).show();
                if(i!=2) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);
                    // Create and show the dialog.
                    DialogFragment newFragment = DepartmentChoice.newInstance(i);
                    newFragment.show(ft, "dialog");
                }else{
                Intent intent  = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    // the class for the dialog fragment
    public static class DepartmentChoice extends DialogFragment {

        /**
         * Create a new instance of MyDialogFragment, providing "num"
         * as an argument.
         */
        private static int numList;
        private ArrayAdapter<String> adapter;
        static DepartmentChoice newInstance(int i) {
            numList = i;
            DepartmentChoice f = new DepartmentChoice();
            return f;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Pick a style based on the num.
            int style = DialogFragment.STYLE_NORMAL, theme = 0;
            setStyle(style, theme);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.list_content_for_frag, container, false);
            ListView listView =(ListView) v.findViewById(R.id.listViewForFrag);
            //make the data specificly for view
            switch (numList){
                case 0:
                    adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Drivers.ListAideLDM);
                    break;
                case 1:
                    adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Drivers.ListAdieInscrip);
                    break;
                case 2:
//                    adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Drivers.ListAdieInscrip);
                    break;
                case 3:
                    adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Drivers.ListAideSocial);
                    break;
                case 4:
//                    adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Drivers.Lis);
                    break;
                case 5:
                    adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Drivers.ListAideBiblio);
                    break;
                case 6:
                    adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Drivers.ListAideAmical);
                    break;
                default:
                    Toast.makeText(getActivity(),"erreur lors de la selection de lla liste",Toast.LENGTH_SHORT).show();
                    break;
            }

            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    onResume();
                    onStop();
                }
            });
            return v;
        }
    }

}
