package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mstory_TextView;
    Button mred_Button;
    Button mblue_Button;
    int mIndex = 0;

    private Story[] stories_Answers_LeadsTo = new Story[]{
            new Story(R.string.T1_Story,R.string.T1_Ans1, R.string.T1_Ans2, 2, 1),
            new Story(R.string.T2_Story,R.string.T2_Ans1, R.string.T2_Ans2, 2, 3),
            new Story(R.string.T3_Story,R.string.T3_Ans1, R.string.T3_Ans2, 5, 4),
            new Story(R.string.T4_End, 0, 0, 0, 0),
            new Story(R.string.T5_End, 0, 0, 0, 0),
            new Story(R.string.T6_End, 0, 0, 0, 0)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mstory_TextView = (TextView)findViewById(R.id.storyTextView);
        mred_Button = (Button)findViewById(R.id.buttonTop);
        mblue_Button = (Button)findViewById(R.id.buttonBottom);

        //UpdateTextAndButton(mIndex);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mred_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = stories_Answers_LeadsTo[mIndex].getAnswer1_LeadsTo();
                if(stories_Answers_LeadsTo[mIndex].getAnswer1_LeadsTo() == 0){
                    mstory_TextView.setText(stories_Answers_LeadsTo[mIndex].getStory_ID());
                    mred_Button.setVisibility(View.GONE);
                    mblue_Button.setVisibility(View.GONE);
                   // mstory_TextView.setText("End");
                }else {

                    Toast.makeText(getApplicationContext(), String.valueOf(mIndex), Toast.LENGTH_SHORT).show();
                    UpdateTextAndButton(mIndex);
                }
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mblue_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex = stories_Answers_LeadsTo[mIndex].getAnswer2_LeadsTo();
                if(stories_Answers_LeadsTo[mIndex].getAnswer1_LeadsTo() == 0){
                    mstory_TextView.setText(stories_Answers_LeadsTo[mIndex].getStory_ID());
                    mred_Button.setVisibility(View.GONE);
                    mblue_Button.setVisibility(View.GONE);
                }else{
                    Toast.makeText(getApplicationContext(), String.valueOf(mIndex), Toast.LENGTH_SHORT).show();
                    UpdateTextAndButton(mIndex);
                }
            }
        });

    }

    public void UpdateTextAndButton(int mIndex){
        mstory_TextView.setText(stories_Answers_LeadsTo[mIndex].getStory_ID());
        mred_Button.setText(stories_Answers_LeadsTo[mIndex].getAnswer1_ID());
        mblue_Button.setText(stories_Answers_LeadsTo[mIndex].getAnswer2_ID());
    }
}
