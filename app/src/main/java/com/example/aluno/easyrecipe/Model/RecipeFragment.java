package com.example.aluno.easyrecipe.Model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aluno.easyrecipe.R;

import java.util.ArrayList;
import java.util.List;

public class RecipeFragment extends Fragment {

    TextView tvTitle;
    TextView tvTime;
    TextView tvYield;
    TextView tvIngredients;
    TextView tvSteps;
    Recipe recipe;


    public static RecipeFragment newInstance(Bundle bundle) {
        RecipeFragment fragment = new RecipeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void setTextViews(View myInflateView) {
        tvTitle = myInflateView.findViewById(R.id.recipe_title);
        tvTime = myInflateView.findViewById(R.id.recipe_time);
        tvYield = myInflateView.findViewById(R.id.recipe_yield);
        tvIngredients = myInflateView.findViewById(R.id.recipe_ingredients);
        tvSteps = myInflateView.findViewById(R.id.recipe_steps);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myInflateView = inflater.inflate(R.layout.content_main, container, false);
        
        if (savedInstanceState != null) {
            recipe = savedInstanceState.getParcelable("recipe");
            String title = recipe.getTitle();
            String yield = recipe.getYield();
            String time = recipe.getTime();
            ArrayList<String> ingredients = recipe.getIngredients();
            ArrayList<String> steps = recipe.getSteps();



            tvTitle.setText(title);
            tvTime.setText(time);
            tvYield.setText(yield);

            StringBuilder ingredientText = new StringBuilder();
            for (String s : ingredients) {
                ingredientText.append(s);
                ingredientText.append("/n");
            }
            tvIngredients.setText(ingredientText.toString());

            StringBuilder stepBuilder = new StringBuilder();
            for (String s : steps) {
                stepBuilder.append(s);
                stepBuilder.append("/n");
            }
            tvSteps.setText(stepBuilder.toString());

        }

        
        

        return myInflateView;
    }
}
