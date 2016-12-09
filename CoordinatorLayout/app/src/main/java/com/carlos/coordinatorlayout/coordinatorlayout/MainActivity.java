package com.carlos.coordinatorlayout.coordinatorlayout;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int option=6;
        int layout;
        switch (option) {
            case 0:

                layout = R.layout.activity_main;
                break;
            case 1:
                layout = R.layout.enter_always;

                break;
            case 2:
                layout = R.layout.enter_allways_collapsed;

                break;
            case 3:
                layout = R.layout.enter_always_collapsed_several_views;
                break;
            case 4:
                layout = R.layout.toolbar_with_tab_fixed;
                break;
            case 5:
                layout = R.layout.snap;
                break;
            case 6:
                layout = R.layout.flexible_space_and_exit_until_collapse_with_ctb;
                break;
            case 7:
                layout = R.layout.toolbar_with_tab_both_dissapearing;
                break;
            case 8:
                layout = R.layout.flexible_space_enter_always_with_collapsingtoolbar;
                break;
            case 9:
                layout = R.layout.flexible_space_and_exit_until_collapse_with_ctb_fab_plus_enteralways;
                break;
            default:
                layout = R.layout.activity_main;

        }
        super.onCreate(savedInstanceState);
        setContentView(layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 150; i++) {
            list.add(new Person("Carlos " +String.valueOf(i)));

        }

        Adapter  adapter= new Adapter();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.swapData(list);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        if(layout == R.layout.activity_main ) {
            collapsingToolbar.setTitleEnabled(true);
            collapsingToolbar.setTitle("pepito");
//            collapsingToolbar.setTitleEnabled(false);
//            getSupportActionBar().setTitle("titutlo");
        }else if (layout == R.layout.flexible_space_enter_always_with_collapsingtoolbar) {
            //se podria poner en xml
            collapsingToolbar.setTitleEnabled(true);
            collapsingToolbar.setTitle("pepito");
        } else if(layout == R.layout.flexible_space_and_exit_until_collapse_with_ctb) {
            collapsingToolbar.setTitleEnabled(true);
            collapsingToolbar.setTitle("aaaaaaaaaa");

        }

//        collapsingToolbar.setTitle("Title");
//        collapsingToolbar.setTitleEnabled(true);
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
}
