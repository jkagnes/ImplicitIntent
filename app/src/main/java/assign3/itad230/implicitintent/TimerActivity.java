package assign3.itad230.implicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class TimerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeractivity_layout);
    }

    public void onSetTimerClick(View view) {
        EditText durationText = (EditText)findViewById(R.id.set_duration);
        int duration = Integer.parseInt(durationText.getText().toString());

        EditText messageOnScr = (EditText)findViewById(R.id.set_message);
        String message = messageOnScr.getText().toString();

        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_LENGTH, duration);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int x = 0;
    }
}
