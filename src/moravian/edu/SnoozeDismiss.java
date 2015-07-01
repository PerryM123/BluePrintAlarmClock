package moravian.edu;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SnoozeDismiss extends Activity {
	private Button snooze;
	private Button dismiss;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.snoozedismiss);

		snooze = (Button) findViewById(R.id.snooze);
		dismiss = (Button) findViewById(R.id.dismiss);

		snooze.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(System.currentTimeMillis());
				calendar.add(Calendar.MINUTE, 10);   
				
				Intent intent = new Intent(SnoozeDismiss.this, MathScreen.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
				
				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);	
				intent = new Intent(SnoozeDismiss.this, Main.class);
				startActivity(intent);
				Toast.makeText(getApplicationContext(), "Snoozing for 10 minutes", Toast.LENGTH_LONG).show();
				finish();
			}
		});
		
		dismiss.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(SnoozeDismiss.this, Main.class);
				startActivity(intent);
				Toast.makeText(getApplicationContext(), "Dismissed. Have a nice day.", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}
	
	/*
	 * Gets the time difference from Calendars a, b
	 * Note that Calendar 'a' should set for a time in the future, and Calendar 'b' is a time less than the time of 'a'
	 * Time is gotten in milliseconds from the calendars then the difference is calculated.
	 * We convert the difference's milliseconds to hours, minutes, and seconds,
	 * then return a String containing those values.
	 * @param Calendar a, Calendar b
	 * @return java.lang.String
	 */
	public java.lang.String getTimeDifference(Calendar a, Calendar b) {
		Long difference = a.getTimeInMillis() - b.getTimeInMillis();
		int seconds = (int) (difference / 1000) % 60;
		int minutes = (int) ((difference / (1000*60)) % 60);
		int hours = (int) ((difference / (1000*60*60)) % 24);
		java.lang.String ret = "";
		if (hours != 0 && hours != 1) {
			ret = ret + Integer.toString(hours) + " hours, " + Integer.toString(minutes) + " minutes, " + Integer.toString(seconds) + " seconds.";
		} else if (hours == 1) {
			ret = ret + Integer.toString(hours) + " hour, " + Integer.toString(minutes) + " minutes, " + Integer.toString(seconds) + " seconds.";
		} else {
			ret = ret + Integer.toString(minutes) + " minutes, " + Integer.toString(seconds) + " seconds.";
		}
		return ret;
	}
}
