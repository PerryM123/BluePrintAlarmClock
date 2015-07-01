package moravian.edu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NormalAlarmReceiver extends Activity {
	private Button snoozeDismiss;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarmreceiver);

		Intent intent = new Intent(NormalAlarmReceiver.this, SoundService.class);
		startService(intent);

		snoozeDismiss = (Button) findViewById(R.id.snoozedismiss);

		snoozeDismiss.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(NormalAlarmReceiver.this, SoundService.class);
				stopService(intent);
				
				intent = new Intent(NormalAlarmReceiver.this, SnoozeDismiss.class);
    			startActivity(intent);
			}
		});
	}
}
