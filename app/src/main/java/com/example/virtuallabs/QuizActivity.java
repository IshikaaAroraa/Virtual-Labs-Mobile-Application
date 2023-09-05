package com.example.virtuallabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizModalArrayList=new ArrayList<>();
        random=new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos=random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(QuizActivity.this);
        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV=bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn=bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your score is \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos=random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionAttempted=1;
                currentScore=0;
                bottomSheetDialog.dismiss();

            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
    private void setDataToViews(int currentPos) {
        questionNumberTV.setText("Questions Attempted:" + questionAttempted + "/10");
        if (questionAttempted == 10) {
            showBottomSheet();
        } else {
            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());
        }
    }
    private void getQuizQuestion(ArrayList<QuizModal>quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("If conductor is moved in a stationary magnetic field, then emf induced in it. Such an emf is known as:","Self-induced emf","Back emf","Static-induced emf","Dynamically-induced emf","Dynamically-induced emf"));
        quizModalArrayList.add(new QuizModal("If the conductor is stationary and the field is changing, then emf induced in it. Such an emf is known as:","Self-induced emf","Back emf","Static-induced emf","Dynamically-induced emf","Static-induced emf"));
        quizModalArrayList.add(new QuizModal("Which of the following bridges can be used to measure inductance?","Maxwell Bridge","Anderson Bridge","Both 1 & 2","None of the above","Both 1 & 2"));
        quizModalArrayList.add(new QuizModal("Which of the following law states that whenever the magnetic flux linked with a conductor or coil changes, an emf is induced in it?:","Lenz Law","Faraday's Law","Fleming's Right Hand rule","None of the above","Faraday's Law"));
        quizModalArrayList.add(new QuizModal("Which of the following bridges can be used to measure inductance?","Maxwell Bridge","Anderson Bridge","Both 1 & 2","None of the above","Both 1 & 2"));
        quizModalArrayList.add(new QuizModal("A 4mm thick metal sheet is to be bend at an angle of four radian with bend radius 100mm, if stretch factor is 0.4, the bend allowance is:","406.44mm","176.0mm","405.6mm","100.4mm","406.4mm"));
        quizModalArrayList.add(new QuizModal("What shall be width to thickness ratio for single angle action of class 1 to prevent local buckling?:","15.7","9.4","10.9","11.0","9.4"));
        quizModalArrayList.add(new QuizModal("The energy level which any electron possesses at 0K is:","Fermi level","Valence Energy","Exergy","None of the above","Fermi level"));
        quizModalArrayList.add(new QuizModal("For elements having energy gap more than 5 ev, act as:","Insulators","Semiconductors","Superconductors","Conductors","Insulators"));
        quizModalArrayList.add(new QuizModal("In terms of energy bands, insulators have:","Full Conduction Band","Full Valence Band","Very Small Energy gap","None of the above","Full Valence Band"));
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

