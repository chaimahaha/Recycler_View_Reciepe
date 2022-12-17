package com.example.recyclerview;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RecipeActivity extends AppCompatActivity {
    public String position;
    public TextView title;
    public ImageView imgageView;
    public TextView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Setup our views
        imgageView = findViewById(R.id.recipeImage);
        scroll = findViewById(R.id.recipeStepsText);

        //Get the data from the intent
        Intent intent = getIntent();
        position = intent.getStringExtra(MainActivity.EXTRA_REPLY);
        loadRecipe(position);
    }

    /**
     * Takes in the position for the recipe in the list, and uses it to bind its data to the view
     * @param position Position in the list for this recipe
     */
    private void loadRecipe(String position){
        int pos = Integer.parseInt(position);
        Recipe recipe = RecipeData.getRecipes().get(pos);
        title.setText(recipe.name);
        scroll.setText(recipe.ingredients + "\n\n" + recipe.directions);
        Picasso.get()
                .load(recipe.image)
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(imgageView);
    }
    }
