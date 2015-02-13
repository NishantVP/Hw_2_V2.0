package com.coen268.nishant.hw2v20;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * This is the upadte for GitHub testing.
 * This comment should reflect in GitHub
 */

/*
* This is Third commit
* */

public class ListActivity extends ActionBarActivity {

    private String[] animalNames;
    private int[] animalImages;
    private ListView zooList;
    private animalListAdapter zooListAdapter;

    public void initializeList()
    {
        animalImages = new int[] {R.drawable.elephant,
                R.drawable.panda,R.drawable.monkey,R.drawable.deer,R.drawable.tiger};
        animalNames = new String[] { "Elephant", "Panda","Monkey", "Deer","Tiger"};

        zooList = (ListView) findViewById(R.id.animalListView);
        zooListAdapter = new animalListAdapter(this, animalNames, animalImages);

        zooList.setAdapter(zooListAdapter);
    }

    public void selectListItem()
    {

        zooList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                switch(position){
                    case 0:
                        Intent intentTiger = new Intent(ListActivity.this, DescriptionActivity.class);
                        intentTiger.putExtra("position",0);
                        startActivity(intentTiger);
                        break;
                    case 1:
                        Intent intentElephant = new Intent(ListActivity.this, DescriptionActivity.class);
                        intentElephant.putExtra("position",1);
                        startActivity(intentElephant);
                        break;
                    case 2:
                        Intent intentPanda = new Intent(ListActivity.this, DescriptionActivity.class);
                        intentPanda.putExtra("position",2);
                        startActivity(intentPanda);
                        break;
                    case 3:
                        Intent intentMonkey = new Intent(ListActivity.this, DescriptionActivity.class);
                        intentMonkey.putExtra("position",3);
                        startActivity(intentMonkey);
                        break;
                    case 4:
                        final AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                        builder.setTitle("Caution").setMessage("The animal is dangerous!! Do you want to continue?");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent4 = new Intent(ListActivity.this, DescriptionActivity.class);
                                intent4.putExtra("position",4);
                                startActivity(intent4);

                            }
                        });
                        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();

                            }
                        });
                        builder.create();
                        builder.show();

                }
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
/*
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
*/
        initializeList();
        selectListItem();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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
