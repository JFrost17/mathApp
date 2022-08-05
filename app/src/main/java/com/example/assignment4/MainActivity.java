package com.example.assignment4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView countDown;
    private TextView score;
    private TextView equation;
    private TextView correct;
    private TextView usernameText;

    public EditText usernameET;

    private Button GO;
    private Button ans1;
    private Button ans2;
    private Button ans3;
    private Button ans4;
    private Button PA;

    private CountDownTimer Timer;
    private boolean timerOn;
    private long resetTime=25000;
    private long timeLeft = 25000;

    int scoreTotal = 0;
    int numQuestions = 0;
    int num1=0;
    int num2=0;
    int a1;
    int a2;
    int a3;
    int a4;
    int randomNum;
    Random rand = new Random(); //instance of random class
    int upperbound = 101;
    int randNumUB = 4;

    String b1="";
    String b2="";
    String b3="";
    String b4="";
    String enteredText="";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.exm,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.tenSeconds:
                resetTime=10000;
                timeLeft=10000;
                break;
            case R.id.fifteenSeconds:
                resetTime=15000;
                timeLeft=15000;
                break;
            case R.id.twentySeconds:
                resetTime=20000;
                timeLeft=20000;
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countDown=findViewById(R.id.countdownText);
        score=findViewById(R.id.scoreText);
        equation=findViewById(R.id.equationText);
        GO=findViewById(R.id.btnGO);
        ans1=findViewById(R.id.btnAns1);
        ans2=findViewById(R.id.btnAns2);
        ans3=findViewById(R.id.btnAns3);
        ans4=findViewById(R.id.btnAns4);
        PA=findViewById(R.id.btnPA);
        correct=findViewById(R.id.correctText);
        usernameET = findViewById(R.id.usernameET);
        usernameText = findViewById(R.id.usernameText);


        GO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score.setVisibility(View.VISIBLE);
                countDown.setVisibility(View.VISIBLE);
                equation.setVisibility(View.VISIBLE);
                ans1.setVisibility(View.VISIBLE);
                ans2.setVisibility(View.VISIBLE);
                ans3.setVisibility(View.VISIBLE);
                ans4.setVisibility(View.VISIBLE);
                startTimer();
                GO.setVisibility(View.INVISIBLE);
                num1 = rand.nextInt(upperbound);
                num2 = rand.nextInt(upperbound);
                equation.setText(num1+" + "+num2);
                randomNum = rand.nextInt(randNumUB);
                a1 = rand.nextInt(2*upperbound);
                a2 = rand.nextInt(2*upperbound);
                a3 = rand.nextInt(2*upperbound);
                a4 = rand.nextInt(2*upperbound);

                if(usernameET.getText().toString().isEmpty())
                {
                    usernameET.setVisibility(View.INVISIBLE);
                }
                else
                {
                    String enteredText = usernameET.getText().toString().trim();
                    usernameText.setText(enteredText);
                    usernameET.setVisibility(View.INVISIBLE);
                }

                if(randomNum == 0)
                {
                    a1 = num1+num2;
                }
                else if(randomNum == 1)
                {
                    a2 = num1+num2;
                }
                else if(randomNum == 2)
                {
                    a3 = num1+num2;
                }
                else
                {
                    a4 = num1 + num2;
                }
                ans1.setText(Integer.toString(a1));
                ans2.setText(Integer.toString(a2));
                ans3.setText(Integer.toString(a3));
                ans4.setText(Integer.toString(a4));
                correct.setText("");
            }
        });

        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if(timerOn) {

                      if (a1 == num1 + num2) {
                          scoreTotal++;
                          correct.setText("Correct!");
                      }
                      else{
                          correct.setText("Incorrect!");
                      }
                      numQuestions++;
                      score.setText(scoreTotal + " / " + numQuestions);
                      num1 = rand.nextInt(upperbound);
                      num2 = rand.nextInt(upperbound);
                      equation.setText(num1 + " + " + num2);
                      randomNum = rand.nextInt(randNumUB);
                      a1 = rand.nextInt(2 * upperbound);
                      a2 = rand.nextInt(2 * upperbound);
                      a3 = rand.nextInt(2 * upperbound);
                      a4 = rand.nextInt(2 * upperbound);
                      if (randomNum == 0) {
                          a1 = num1 + num2;
                      } else if (randomNum == 1) {
                          a2 = num1 + num2;
                      } else if (randomNum == 2) {
                          a3 = num1 + num2;
                      } else {
                          a4 = num1 + num2;
                      }
                      ans1.setText(Integer.toString(a1));
                      ans2.setText(Integer.toString(a2));
                      ans3.setText(Integer.toString(a3));
                      ans4.setText(Integer.toString(a4));
                  }
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timerOn) {
                    if (a2 == num1 + num2) {
                        scoreTotal++;
                        correct.setText("Correct!");
                    }
                    else{
                        correct.setText("Incorrect!");
                    }

                    numQuestions++;
                    score.setText(scoreTotal + " / " + numQuestions);
                    num1 = rand.nextInt(upperbound);
                    num2 = rand.nextInt(upperbound);
                    equation.setText(num1 + " + " + num2);
                    randomNum = rand.nextInt(randNumUB);
                    a1 = rand.nextInt(2 * upperbound);
                    a2 = rand.nextInt(2 * upperbound);
                    a3 = rand.nextInt(2 * upperbound);
                    a4 = rand.nextInt(2 * upperbound);

                    if (randomNum == 0) {
                        a1 = num1 + num2;
                    } else if (randomNum == 1) {
                        a2 = num1 + num2;
                    } else if (randomNum == 2) {
                        a3 = num1 + num2;
                    } else {
                        a4 = num1 + num2;
                    }
                    ans1.setText(Integer.toString(a1));
                    ans2.setText(Integer.toString(a2));
                    ans3.setText(Integer.toString(a3));
                    ans4.setText(Integer.toString(a4));
                }
            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timerOn) {
                    if (a3 == num1 + num2) {
                        scoreTotal++;
                        correct.setText("Correct!");
                    }
                    else{
                        correct.setText("Incorrect!");
                    }
                    numQuestions++;
                    score.setText(scoreTotal + " / " + numQuestions);
                    num1 = rand.nextInt(upperbound);
                    num2 = rand.nextInt(upperbound);
                    equation.setText(num1 + " + " + num2);
                    randomNum = rand.nextInt(randNumUB);
                    a1 = rand.nextInt(2 * upperbound);
                    a2 = rand.nextInt(2 * upperbound);
                    a3 = rand.nextInt(2 * upperbound);
                    a4 = rand.nextInt(2 * upperbound);

                    if (randomNum == 0) {
                        a1 = num1 + num2;
                    } else if (randomNum == 1) {
                        a2 = num1 + num2;
                    } else if (randomNum == 2) {
                        a3 = num1 + num2;
                    } else {
                        a4 = num1 + num2;
                    }
                    ans1.setText(Integer.toString(a1));
                    ans2.setText(Integer.toString(a2));
                    ans3.setText(Integer.toString(a3));
                    ans4.setText(Integer.toString(a4));
                }
            }
        });

        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timerOn) {
                    if (a4 == num1 + num2) {
                        scoreTotal++;
                        correct.setText("Correct!");
                    }
                    else{
                        correct.setText("Incorrect!");
                    }
                    numQuestions++;
                    score.setText(scoreTotal + " / " + numQuestions);
                    num1 = rand.nextInt(upperbound);
                    num2 = rand.nextInt(upperbound);
                    equation.setText(num1 + " + " + num2);
                    randomNum = rand.nextInt(randNumUB);
                    a1 = rand.nextInt(2 * upperbound);
                    a2 = rand.nextInt(2 * upperbound);
                    a3 = rand.nextInt(2 * upperbound);
                    a4 = rand.nextInt(2 * upperbound);

                    if (randomNum == 0) {
                        a1 = num1 + num2;
                    } else if (randomNum == 1) {
                        a2 = num1 + num2;
                    } else if (randomNum == 2) {
                        a3 = num1 + num2;
                    } else {
                        a4 = num1 + num2;
                    }
                    ans1.setText(Integer.toString(a1));
                    ans2.setText(Integer.toString(a2));
                    ans3.setText(Integer.toString(a3));
                    ans4.setText(Integer.toString(a4));
                }
            }
        });

        PA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!timerOn)
                {
                    resetTimer();
                    startTimer();
                    score.setText("0/0");
                    scoreTotal=0;
                    numQuestions=0;
                    num1 = rand.nextInt(upperbound);
                    num2 = rand.nextInt(upperbound);
                    equation.setText(num1+" + "+num2);
                    randomNum = rand.nextInt(randNumUB);
                    a1 = rand.nextInt(2*upperbound);
                    a2 = rand.nextInt(2*upperbound);
                    a3 = rand.nextInt(2*upperbound);
                    a4 = rand.nextInt(2*upperbound);

                    if(randomNum == 0)
                    {
                        a1 = num1+num2;
                    }
                    else if(randomNum == 1)
                    {
                        a2 = num1+num2;
                    }
                    else if(randomNum == 2)
                    {
                        a3 = num1+num2;
                    }
                    else
                    {
                        a4 = num1 + num2;
                    }
                    ans1.setText(Integer.toString(a1));
                    ans2.setText(Integer.toString(a2));
                    ans3.setText(Integer.toString(a3));
                    ans4.setText(Integer.toString(a4));
                    correct.setText("");
                }
            }
        });



    }

    private void startTimer()
    {
        Timer = new CountDownTimer(timeLeft,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft= millisUntilFinished;
                updateCountDown();
            }

            @Override
            public void onFinish() {
                timerOn = false;
            }
        }.start();
        timerOn=true;
    }
    private void stopTimer()
    {
        Timer.cancel();
        timerOn=false;
    }
    private void resetTimer()
    {
        timeLeft = resetTime;
        updateCountDown();

    }

    private void updateCountDown()
    {
        int seconds = (int) timeLeft/1000;
        String timeLeftText = String.format(Locale.getDefault(),":%02d",seconds);
        countDown.setText(timeLeftText);
        if(seconds==0)
        {
            timerOn=false;
            PA.setVisibility(View.VISIBLE);
            correct.setText("Score: "+scoreTotal+" / "+numQuestions);
        }
    }
}