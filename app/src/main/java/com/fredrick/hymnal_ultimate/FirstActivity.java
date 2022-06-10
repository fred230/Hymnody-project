package com.fredrick.hymnal_ultimate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;

public class FirstActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout nDrawer;
    private ActionBarDrawerToggle nToggle;
    NavigationView navigationView;
    ListView listView;
    ArrayAdapter arrayAdapter;
    ImageButton Bookmark;
    AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //toolbar

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        //Drawer layout

        nDrawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        nToggle = new ActionBarDrawerToggle(this, nDrawer,R.string.open,R.string.close);

        nDrawer.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //navigation view
        navigationView = findViewById(R.id.Nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.bookmark_id, R.id.share_id).setOpenableLayout(nDrawer).build();



         listView = findViewById(R.id.listview);
        String[] hymns = getResources().getStringArray(R.array.hymn);
        final String[] lyrics = getResources().getStringArray(R.array.hymn_lyrics);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,hymns);
        listView.setAdapter(arrayAdapter);

        //drawer buttons




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                //initializing intent
                Intent intent = new Intent(FirstActivity.this,LyricsActivity.class);

                //getting hymn title of a selection
                String title =   listView.getAdapter().getItem(i).toString();


                //retrieving selected number of hymn
                String stateName = listView.getAdapter().getItem(i).toString();
                stateName =   stateName .substring(0, stateName .indexOf(" ") ).trim();



                //short service for our media player- midi selection number
                int x = Integer.parseInt(stateName);
                x= x-1;

                //hymn lyrics  selection number

                int z = Integer.parseInt(stateName);
                String strLyric = lyrics[z-1];


                intent.putExtra("title", title);
                intent.putExtra("lyric",strLyric);

                //short service for sending the number of selected midi to our midi player
                intent.putExtra("midi",x);

                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(nToggle.onOptionsItemSelected(item)){
            return true;


        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search an hymn");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);



    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.bookmark_id:
                Toast.makeText(getApplicationContext(), "bookmark", Toast.LENGTH_SHORT).show();
                break;

            case R.id.share_id:
                Toast.makeText(getApplicationContext(), "share", Toast.LENGTH_SHORT).show();
                break;



        }





        nDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}