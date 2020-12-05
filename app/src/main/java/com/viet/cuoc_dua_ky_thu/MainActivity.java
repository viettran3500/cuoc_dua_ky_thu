package com.viet.cuoc_dua_ky_thu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    ImageView ibtnPlay;
    CheckBox cbOne, cbTwo, cbThree;
    SeekBar skOne, skTwo, skThree;
    int soDiem = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        skOne.setEnabled(false);
        skTwo.setEnabled(false);
        skThree.setEnabled(false);

        txtDiem.setText(soDiem + "");
        final CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);
                if(skOne.getProgress() >= skOne.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"One Win",Toast.LENGTH_LONG).show();
                    if(cbOne.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this,"Bạn đoán chính",Toast.LENGTH_LONG).show();
                    }else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this,"Bạn đoán sai rồi",Toast.LENGTH_LONG).show();
                    }
                    txtDiem.setText(soDiem + "");
                    setCheckBox(true);
                }
                if(skTwo.getProgress() >= skTwo.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Two Win",Toast.LENGTH_LONG).show();
                    if(cbTwo.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this,"Bạn đoán chính",Toast.LENGTH_LONG).show();
                    }else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this,"Bạn đoán sai rồi",Toast.LENGTH_LONG).show();
                    }
                    txtDiem.setText(soDiem + "");
                    setCheckBox(true);
                }
                if(skThree.getProgress() >= skThree.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this,"Three Win",Toast.LENGTH_LONG).show();
                    if(cbThree.isChecked()){
                        soDiem += 10;
                        Toast.makeText(MainActivity.this,"Bạn đoán chính",Toast.LENGTH_LONG).show();
                    }else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this,"Bạn đoán sai rồi",Toast.LENGTH_LONG).show();
                    }
                    txtDiem.setText(soDiem + "");
                    setCheckBox(true);
                }
                skOne.setProgress(skOne.getProgress() + one);
                skTwo.setProgress(skTwo.getProgress() + two);
                skThree.setProgress(skThree.getProgress() + three);
            }

            @Override
            public void onFinish() {

            }
        };
        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbOne.isChecked() ||cbTwo.isChecked() || cbThree.isChecked()){
                    ibtnPlay.setVisibility(View.INVISIBLE);
                    skOne.setProgress(0);
                    skTwo.setProgress(0);
                    skThree.setProgress(0);
                    countDownTimer.start();

                    setCheckBox(false);
                }else {
                    Toast.makeText(MainActivity.this,"Vui lòng đặt cược trước khi chơi",Toast.LENGTH_LONG).show();
                }

            }
        });
        cbTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbOne.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
        cbThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbTwo.setChecked(false);
                    cbOne.setChecked(false);
                }
            }
        });
        cbOne.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cbTwo.setChecked(false);
                    cbThree.setChecked(false);
                }
            }
        });
    }
    private void setCheckBox(Boolean aBoolean){
        cbOne.setEnabled(aBoolean);
        cbOne.setEnabled(aBoolean);
        cbOne.setEnabled(aBoolean);
    }
    private void AnhXa(){
        txtDiem     = (TextView)findViewById(R.id.textviewDiemSo);
        ibtnPlay    = (ImageView)findViewById(R.id.bottomPlay);
        cbOne       = (CheckBox)findViewById(R.id.checkboxOne);
        cbTwo       = (CheckBox)findViewById(R.id.checkboxTwo);
        cbThree     = (CheckBox)findViewById(R.id.checkboxThree);
        skOne       = (SeekBar)findViewById(R.id.seekbarOne);
        skTwo       = (SeekBar)findViewById(R.id.seekbarTwo);
        skThree     = (SeekBar)findViewById(R.id.seekbarThree);
    }
}
