package com.coen268.nishant.hw2v20;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class DescriptionActivity extends ActionBarActivity {

    TextView name,description;
    ImageView img;

    String[] animals;
    int[] pics;
    String[] description_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        pics = new int[] {R.drawable.tiger, R.drawable.elephant,R.drawable.panda,
                R.drawable.monkey,R.drawable.deer};

        animals = new String[] { "Tiger", "Elephant", "Panda","Monkey", "Deer",};

        String mouse=new String("Mouse is a wierd animal");
        String cat=new String("Cats are similar in anatomy to the other felids, with strong, flexible bodies, quick reflexes, sharp retractable claws, and teeth adapted to killing small prey");
        String monkey=new String("A monkey is a non-human primate of the Haplorrhini suborder and simian infraorder, either an Old World monkey or a New World monkey, but sometimesexcluding non-human hominoids");
        String rabbit=new String("Rabbit loves to eat carrots");
        String tiger=new String("The national animal of India");

        description_value= new String[] {cat,cat,mouse, rabbit, tiger};
        int position;
        if(getIntent().getExtras().get("position") != null){
            position = Integer.valueOf(getIntent().getExtras().get("position").toString());
        }

        else{
            position = 0;
        }

        name=(TextView) findViewById(R.id.animalNameView);
        img=(ImageView) findViewById(R.id.descriptionImageView);
        description=(TextView) findViewById(R.id.descriptionTextView);

        name.setText(animals[position]);
        img.setImageResource(pics[position]);
        description.setText(description_value[position]);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_description, menu);
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
