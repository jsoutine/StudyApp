package com.example.android.studyapp.Tools.StudyTips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.studyapp.R;

import java.util.Random;

public class StudyTips extends AppCompatActivity {

    private TextView tipTxt;
    private Button tipBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study_tips);

        tipBtn = findViewById(R.id.btnTip);
        tipTxt = findViewById(R.id.txtViewStudyTips);

        tipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipTxt.setText(tipRandomGenerator());
            }
        });
    }

    public String tipRandomGenerator () {
        Random random = new Random();
        String [] tipsList = new String[10];

        int randomTip = random.nextInt(tipsList.length);

        tipsList[0] = "Keep energy levels high.\n\n- Sleep 7-9 hours so you can be more awake and energized.";
        tipsList[1] = "50-10 rule.\n\n- Study 50 minutes of every hour. Spend 10 minutes cleaning your mind.";
        tipsList[2] = "Organize your calender\n\n- Designate time for studying, free time, and exam times.";
        tipsList[3] = "Make study guides.\n\n- Begin preparing and making study guides one week before the exam.";
        tipsList[4] = "Study in groups.\n\n- But only if it helps you, don't let it be a distraction.";
        tipsList[5] = "Take your time.\n\n- Plan ahead and take your time studying.";
        tipsList[6] = "Exercise daily.\n\n- Let off steam and clear your mind, an active mind is more productive.";
        tipsList[7] = "Relax.\n\n- Keep your stress levels low and worry less.";
        tipsList[8] = "Do a practice quiz.\n\n- Ask friends to quiz you on subjects that are difficult.";
        tipsList[9] = "Eat healthy.\n\n- Your body will feel better and you will be more alert.";

        return tipsList [randomTip];

    }
}
