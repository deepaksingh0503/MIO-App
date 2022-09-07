package com.example.multiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tic_tac_toe_second_activity extends AppCompatActivity {

    public static final String  EXTRA_WINNER = "com.example.multiscreenapp.extra.WINNER";
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9 ,player1,player2;
    int flag=0;
    int count=0;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    Intent intent;
    String name1;
    String name2;
    Boolean emojimode;
    int games=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_second);


        init();
        Bundle bundle = getIntent().getExtras();
        emojimode = bundle.getBoolean(tic_tac_toe.EXTRA_EMOJIMODE);
        intent = getIntent();
        name1= intent.getStringExtra(tic_tac_toe.EXTRA_NAME1);
        name2= intent.getStringExtra(tic_tac_toe.EXTRA_NAME2);

        if(name1.equals("")){
            name1="Player1";
        }
        if(name2.equals("")){
            name2= "Player2";
        }
        String p1;
        String p2;
        if(emojimode){
            p1=name1+ " -> \uD83D\uDE0D";
            p2=name2+ " -> \uD83D\uDE0E";
        }else{
            p1=name1+ " -> X";
            p2=name2+ " -> O";
        }


        player1.setText(p1);
        player1.setTextColor(Color.GREEN);
        player2.setTextColor(Color.RED);
        player2.setText(p2);

    }

    void init(){
        btn1=findViewById(R.id.button1);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        btn4=findViewById(R.id.button4);
        btn5=findViewById(R.id.button5);
        btn6=findViewById(R.id.button6);
        btn7=findViewById(R.id.button7);
        btn8=findViewById(R.id.button8);
        btn9=findViewById(R.id.button9);
        player1=findViewById(R.id.player1);
        player2=findViewById(R.id.player2);
    }

    public void check(View view) {

        Button btnCurrent = (Button) view;
        if (btnCurrent.getText().toString().equals("")) {
            count++;
            if(emojimode){
                if (flag == 0) {
                    btnCurrent.setText("\uD83D\uDE0D");
                    player1.setTextColor(Color.RED);
                    player2.setTextColor(Color.GREEN);
                    flag = 1;
                } else {
                    btnCurrent.setText("\uD83D\uDE0E");
                    player2.setTextColor(Color.RED);
                    player1.setTextColor(Color.GREEN);
                    flag = 0;
                }
            }else{
                if (flag == 0) {
                    btnCurrent.setText("X");
                    player1.setTextColor(Color.RED);
                    player2.setTextColor(Color.GREEN);
                    flag = 1;
                } else {
                    btnCurrent.setText("O");
                    player2.setTextColor(Color.RED);
                    player1.setTextColor(Color.GREEN);
                    flag = 0;
                }
            }



            if (count >= 5) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();
                String winner;
                Intent intent1=new Intent(this,tic_tac_toe_winner.class);
                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
                    if(b1.equals("X") || b1.equals("\uD83D\uDE0D")){
                        winner=name1;
                    }else{
                        winner=name2;
                    }
                    intent1.putExtra(EXTRA_WINNER,winner);
                    resetGame();
                    startActivity(intent1);
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    Toast.makeText(this, "Winner is " + b4, Toast.LENGTH_SHORT).show();
                    if(b4.equals("X")||b4.equals("\uD83D\uDE0D")){
                        winner=name1;
                    }else{
                        winner=name2;
                    }
                    intent1.putExtra(EXTRA_WINNER,winner);
                    resetGame();
                    startActivity(intent1);
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    Toast.makeText(this, "Winner is " + b7, Toast.LENGTH_SHORT).show();
                    if(b7.equals("X") ||b7.equals("\uD83D\uDE0D")){
                        winner=name1;
                    }else{
                        winner=name2;
                    }
                    intent1.putExtra(EXTRA_WINNER,winner);
                    resetGame();
                    startActivity(intent1);
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    Toast.makeText(this, "Winner is " + b2, Toast.LENGTH_SHORT).show();
                    if(b2.equals("X") ||b2.equals("\uD83D\uDE0D")){
                        winner=name1;
                    }else{
                        winner=name2;
                    }
                    intent1.putExtra(EXTRA_WINNER,winner);
                    resetGame();
                    startActivity(intent1);
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    Toast.makeText(this, "Winner is " + b6, Toast.LENGTH_SHORT).show();
                    if(b3.equals("X")||b3.equals("\uD83D\uDE0D")){
                        winner=name1;
                    }else{
                        winner=name2;
                    }
                    intent1.putExtra(EXTRA_WINNER,winner);
                    resetGame();
                    startActivity(intent1);
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
                    if(b1.equals("X")||b1.equals("\uD83D\uDE0D")){
                        winner=name1;
                    }else{
                        winner=name2;
                    }
                    intent1.putExtra(EXTRA_WINNER,winner);
                    resetGame();
                    startActivity(intent1);
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    Toast.makeText(this, "Winner is " + b1, Toast.LENGTH_SHORT).show();
                    if(b1.equals("X")||b1.equals("\uD83D\uDE0D")){
                        winner=name1;
                    }else{
                        winner=name2;
                    }
                    intent1.putExtra(EXTRA_WINNER,winner);
                    resetGame();
                    startActivity(intent1);
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    Toast.makeText(this, "Winner is " + b3, Toast.LENGTH_SHORT).show();
                    if(b3.equals("X")||b3.equals("\uD83D\uDE0D")){
                        winner=name1;
                    }else{
                        winner=name2;
                    }
                    intent1.putExtra(EXTRA_WINNER,winner);
                    resetGame();
                    startActivity(intent1);
                }else if(count==9){
                    Toast.makeText(this, "Game is Drawn ", Toast.LENGTH_SHORT).show();
                    winner="";
                    intent1.putExtra(EXTRA_WINNER,winner);
                    resetGame();
                    startActivity(intent1);
                }

            }
        }
    }

    public void resetGame(){
//         flag=1;
        count=0;
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        if(games%2==0){
            player1.setTextColor(Color.RED);
            player2.setTextColor(Color.GREEN);
            flag=1;
        }else{
            player1.setTextColor(Color.GREEN);
            player2.setTextColor(Color.RED);
            flag=0;
        }
        games++;


    }

}
