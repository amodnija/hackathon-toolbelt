package com.amod.hackathon_toolbelt;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Stopwatch extends AppCompatActivity {
    Button start, pause, reset, lap, check ;
    long MillisecondTime, StartTime, TimeBuff;
    int UpdateTime;
    View clickSource;
    View touchSource;
    Animation anim;
    Handler handler;
    int Seconds, Minutes, MilliSeconds, k ;
    ListView listView ;
    ListView listView2 ;
    TextView textView,textView1;
    String[] ListElements = new String[] {  };
    List<String> ListElementsArrayList ;
    ArrayAdapter<String> adapter ;
    List<String> ListElementsArrayList1 ;
    ArrayAdapter<String> adapter1 ;
    ProgressBar progressBar;
    long max, min;
    @SuppressLint({"ClickableViewAccessibility", "DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        start = findViewById(R.id.button);
        pause = findViewById(R.id.button2);
        reset = findViewById(R.id.button3);
        lap = findViewById(R.id.button4);
        check = findViewById(R.id.button6);
        listView = findViewById(R.id.listview1);
        listView2= findViewById(R.id.listview2);
        textView= findViewById(R.id.textView);
        textView1= findViewById(R.id.textView1);
        handler = new Handler() ;
        k=1;
        progressBar = findViewById(R.id.progressBar);

        anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(625);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        reset.setEnabled(false);
        pause.setEnabled(false);
        start.setEnabled(true);
        lap.setEnabled(false);

        ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));
        adapter = new ArrayAdapter<>(this, R.layout.mytextview, ListElementsArrayList);
        listView.setAdapter(adapter);
        listView.setOnTouchListener((v, event) -> {
            if(touchSource == null)
                touchSource = v;
            if(v == touchSource) {
                listView2.dispatchTouchEvent(event);
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    clickSource = v;
                    touchSource = null;
                }
            }
            return false;
        });
        ListElementsArrayList1 = new ArrayList<>(Arrays.asList(ListElements));
        adapter1 = new ArrayAdapter<>(this, R.layout.mytextview, ListElementsArrayList1);
        listView2.setAdapter(adapter1);
        listView2.setOnTouchListener((v, event) -> {
            if(touchSource == null)
                touchSource = v;
            if(v == touchSource) {
                listView.dispatchTouchEvent(event);
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    clickSource = v;
                    touchSource = null;
                }
            }
            return false;
        });

        ListElementsArrayList1.add("SPLIT TIME");
        ListElementsArrayList.add("  LAP TIME");

        start.setOnClickListener(view -> {
            progressBar.clearAnimation();
            if (start.isEnabled()) {
                StartTime = System.currentTimeMillis();
                handler.postDelayed(runnable, 0);
                pause.setEnabled(true);
                reset.setEnabled(false);
                start.setEnabled(false);
                lap.setEnabled(true);
            }
        });
        pause.setOnClickListener(view -> {
            if(pause.isEnabled()) {
                progressBar.clearAnimation();
                TimeBuff += MillisecondTime;
                handler.removeCallbacks(runnable);
                reset.setEnabled(true);
                pause.setEnabled(false);
                start.setEnabled(true);
                lap.setEnabled(true);
                progressBar.startAnimation(anim);
            }
        });
        check.setOnClickListener(view -> {
            progressBar.clearAnimation();
            if(start.isEnabled()) {
                StartTime = System.currentTimeMillis();
                handler.postDelayed(runnable, 0);
                pause.setEnabled(true);
                reset.setEnabled(false);
                start.setEnabled(false);
                lap.setEnabled(true);
            }
            else {
                TimeBuff += MillisecondTime;
                handler.removeCallbacks(runnable);
                reset.setEnabled(true);
                pause.setEnabled(false);
                start.setEnabled(true);
                lap.setEnabled(true);
                progressBar.startAnimation(anim);
            }
        });
        reset.setOnClickListener(view -> {
            progressBar.clearAnimation();
            MillisecondTime = 0L ;
            k=1;
            StartTime = 0L ;
            TimeBuff = 0L ;
            UpdateTime = 0 ;
            Seconds = 0 ;
            Minutes = 0 ;
            MilliSeconds = 0 ;
            max=0;
            min=0;
            check.setText(R.string.format);
            textView.setText(R.string.min);
            textView1.setText(R.string.max);
            progressBar.setProgress(0);
            ListElementsArrayList.clear();
            ListElementsArrayList1.clear();
            ListElementsArrayList.add("  LAP TIME");
            ListElementsArrayList1.add("SPLIT TIME");
            adapter.notifyDataSetChanged();
            adapter1.notifyDataSetChanged();
            reset.setEnabled(false);
            lap.setEnabled(false);
        });
        lap.setOnClickListener(view -> {
            String s;
            String s1;
            ListElementsArrayList1.add(1,check.getText().toString());
            adapter1.notifyDataSetChanged();
            if(k==1)
                s="0:0:0";
            else
                s=ListElementsArrayList1.get(2);
            s1=ListElementsArrayList1.get(1);
            TimeDiff start = new TimeDiff(s);
            TimeDiff stop = new TimeDiff(s1);
            start=start.difference(start, stop);
            ListElementsArrayList.add(1,(k)+")"+start.s[0]+":"+start.s[1]+":"+start.s[2]);
            adapter.notifyDataSetChanged();
            if(k==1)
            {
                min=start.s[0]*60*1000+start.s[1]*1000+start.s[2];
                max=start.s[0]*60*1000+start.s[1]*1000+start.s[2];
            }
            else
            {
                if(min>start.s[0]*60*1000+start.s[1]*1000+start.s[2])
                    min=start.s[0]*60*1000+start.s[1]*1000+start.s[2];
                else if(max<start.s[0]*60*1000+start.s[1]*1000+start.s[2])
                    max=start.s[0]*60*1000+start.s[1]*1000+start.s[2];
            }
            textView.setText("MIN:"+min / 1000/60+":"+min/ 1000%60+":"+min % 1000);
            textView1.setText("MAX:"+max/1000/60+":"+max/1000%60+":"+max % 1000);
            k++;
        });
    }
    public Runnable runnable = new Runnable() {
        public void run() {
            MillisecondTime = System.currentTimeMillis() - StartTime;
            UpdateTime =(int) (TimeBuff + MillisecondTime);
            progressBar.setProgress(UpdateTime/10%100);
            @SuppressLint("DefaultLocale") String time=(String.format("%02d", UpdateTime / 1000/60)+":"+String.format("%02d", UpdateTime / 1000%60)+":"+String.format("%03d", UpdateTime % 1000));
            check.setText(time);
            handler.postDelayed(this, 0);
        }
    };
}