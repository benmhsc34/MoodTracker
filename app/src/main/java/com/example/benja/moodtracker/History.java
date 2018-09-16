package com.example.benja.moodtracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class History extends AppCompatActivity {
    public static final String PREF_KEY_COMMENT0 = "PREFERENCE_KEY_COMMENT0";
    public static final String PREF_KEY_COMMENT1 = "PREFERENCE_KEY_COMMENT1";
    public static final String PREF_KEY_COMMENT2 = "PREFERENCE_KEY_COMMENT2";
    public static final String PREF_KEY_COMMENT3 = "PREFERENCE_KEY_COMMENT3";
    public static final String PREF_KEY_COMMENT4 = "PREFERENCE_KEY_COMMENT4";
    public static final String PREF_KEY_COMMENT5 = "PREFERENCE_KEY_COMMENT5";
    public static final String PREF_KEY_COMMENT6 = "PREFERENCE_KEY_COMMENT6";

    public static final String PREF_KEY_COLOR0 = "PREFERENCE_KEY_COLOR0";
    public static final String PREF_KEY_COLOR1 = "PREFERENCE_KEY_COLOR1";
    public static final String PREF_KEY_COLOR2 = "PREFERENCE_KEY_COLOR2";
    public static final String PREF_KEY_COLOR3 = "PREFERENCE_KEY_COLOR3";
    public static final String PREF_KEY_COLOR4 = "PREFERENCE_KEY_COLOR4";
    public static final String PREF_KEY_COLOR5 = "PREFERENCE_KEY_COLOR5";
    public static final int PREF_KEY_COLOR6 = 123;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);


        ListView listMood = findViewById(R.id.listMood);
        ArrayList<Mood> moodsList = new ArrayList<>();
        listMood.setAdapter(new MyCustomAdapter(this, moodsList));

    }


    public class MyCustomAdapter extends BaseAdapter implements ListAdapter {
        private Context context;
        private ArrayList<Mood> moodsList;


        MyCustomAdapter(Context context, ArrayList<Mood> moodsList) {
            this.context = context;
            this.moodsList = moodsList;
        }

        @Override
        public int getCount() {
            return moodsList.size();
        }

        Object variable;

        @Override
        public Object getItem(int pos) {
            variable = getItem(pos);

            return pos;
        }

        @Override
        public long getItemId(int pos) {
            return pos;
            //return 0 if list items do not have an Id variable.
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                if (inflater != null){
                view = inflater.inflate(R.layout.customlayout, null);
            }else{
                    Log.d("bug?","that was the bug");
                }
            }
            Mood mood = moodsList.get(position);
            String moodMessage = mood.getMoodMessage();
            Integer moodColor = moodsList.get(position).getMoodColor();
            assert view != null;
            TextView moodTextView = view.findViewById(R.id.moodTextView);
            ImageButton moodImageButton = view.findViewById(R.id.moodImageButton);

            //Retrieving the comments from SP
            SharedPreferences mPreferences = getSharedPreferences("PREFERENCE_KEY_NAME", MODE_PRIVATE);
            final String comment0 = (mPreferences.getString("PREFERENCE_KEY_COMMENT0", ""));
            final String comment1 = (mPreferences.getString("PREFERENCE_KEY_COMMENT1", ""));
            final String comment2 = (mPreferences.getString("PREFERENCE_KEY_COMMENT2", ""));
            final String comment3 = (mPreferences.getString("PREFERENCE_KEY_COMMENT3", ""));
            final String comment4 = (mPreferences.getString("PREFERENCE_KEY_COMMENT4", ""));
            final String comment5 = (mPreferences.getString("PREFERENCE_KEY_COMMENT5", ""));
            final String comment6 = (mPreferences.getString("PREFERENCE_KEY_COMMENT6", ""));

            //Retrieving the colors from SP
            int color0 = (mPreferences.getInt("PREFERENCE_KEY_COLOR0", 0));
            int color1 = (mPreferences.getInt("PREFERENCE_KEY_COLOR1", 0));
            int color2 = (mPreferences.getInt("PREFERENCE_KEY_COLOR2", 0));
            int color3 = (mPreferences.getInt("PREFERENCE_KEY_COLOR3", 0));
            int color4 = (mPreferences.getInt("PREFERENCE_KEY_COLOR4", 0));
            int color5 = (mPreferences.getInt("PREFERENCE_KEY_COLOR5", 0));
            int color6 = (mPreferences.getInt("PREFERENCE_KEY_COLOR6", 0));

            //Checking if I retrieved it properly yall
            Toast.makeText(History.this, comment0, Toast.LENGTH_LONG).show();
            Toast.makeText(History.this, comment1, Toast.LENGTH_LONG).show();
            Toast.makeText(History.this, comment2, Toast.LENGTH_LONG).show();
            Toast.makeText(History.this, comment3, Toast.LENGTH_LONG).show();
            Toast.makeText(History.this, comment4, Toast.LENGTH_LONG).show();
            Toast.makeText(History.this, comment5, Toast.LENGTH_LONG).show();
            Toast.makeText(History.this, comment6, Toast.LENGTH_LONG).show();
            Toast.makeText(History.this, color0, Toast.LENGTH_LONG).show();

            //Adding all that in an array
            moodsList.add(new Mood(comment0, color0));
            moodsList.add(new Mood(comment2, color2));
            moodsList.add(new Mood(comment3, color3));
            moodsList.add(new Mood(comment4, color4));
            moodsList.add(new Mood(comment5, color5));
            moodsList.add(new Mood(comment6, color6));




        //Onclick listener + toast
            moodImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(History.this, comment0, Toast.LENGTH_LONG).show();                }
            });




            //assign text to the textViews

            moodTextView.setBackgroundColor(moodColor);

            return null;
        }
    }
}

