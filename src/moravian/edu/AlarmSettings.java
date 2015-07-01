package moravian.edu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlarmSettings extends Activity {
	Button Save;
	Button Cancel;
	public static AlarmManager alarmmanager;
	public static TimePicker timepicker;
	public static TextView alarmSettingsText;
	private boolean resumed;
	String dropBox;
	String dropBox2;
	Spinner spinner1;
	Spinner spinner2;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.editalarm);
	    
	    spinner1 = (Spinner) findViewById(R.id.spinner1); //Spinner 1 and 2 refer to drop down menus for Alarm Type and Alarm Sound
	    spinner2 = (Spinner) findViewById(R.id.spinner2);
	    List<String> list = new ArrayList<String>();
		list.add("Normal");
		list.add("Math Problem");
		list.add("Word Problem");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("Alarm Sound 1");
		list2.add("Alarm Sound 2");
		list2.add("Alarm Sound 3");
		list2.add("Alarm Sound 4");
		list2.add("Alarm Sound 5 (Special)");
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, list);
		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, list2);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner1.setAdapter(dataAdapter);
		spinner2.setAdapter(dataAdapter2);
		
		timepicker = (TimePicker) findViewById(R.id.timePicker1);	
		Save = (Button) findViewById(R.id.Save);
		Cancel = (Button) findViewById(R.id.Cancel);
	    
		alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		
	    Save.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				dropBox = String.valueOf(spinner1.getSelectedItem());
				if (((GlobalVariables)getApplication()).getCurrentAlarmBeingEdited() == 1) {
					if (dropBox.equals("Normal")) {
						((GlobalVariables)getApplication()).Alarm1Type = "Normal";
					} else if (dropBox.equals("Math Problem")) {
						((GlobalVariables)getApplication()).Alarm1Type = "Math";
					} else if (dropBox.equals("Word Problem")) {
						((GlobalVariables)getApplication()).Alarm1Type = "Word";
					}
				} else if (((GlobalVariables)getApplication()).getCurrentAlarmBeingEdited() == 2) {
					if (dropBox.equals("Normal")) {
						((GlobalVariables)getApplication()).Alarm2Type = "Normal";
					} else if (dropBox.equals("Math Problem")) {
						((GlobalVariables)getApplication()).Alarm2Type = "Math";
					} else if (dropBox.equals("Word Problem")) {
						((GlobalVariables)getApplication()).Alarm2Type = "Word";
					}
				} else if (((GlobalVariables)getApplication()).getCurrentAlarmBeingEdited() == 3) {
					if (dropBox.equals("Normal")) {
						((GlobalVariables)getApplication()).Alarm3Type = "Normal";
					} else if (dropBox.equals("Math Problem")) {
						((GlobalVariables)getApplication()).Alarm3Type = "Math";
					} else if (dropBox.equals("Word Problem")) {
						((GlobalVariables)getApplication()).Alarm3Type = "Word";
					}
				}
				
				setAlarm();
			}
		});
	    
		Cancel.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "Canceled.", Toast.LENGTH_LONG).show();
				finish();
			}
		});
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (!resumed) {
			resumed = true;
		}
		spinner2.setSelection(((GlobalVariables)getApplication()).AlarmSound - 1);
		if (((GlobalVariables)getApplication()).getCurrentAlarmBeingEdited() == 1) {
			timepicker.setCurrentHour(((GlobalVariables)getApplication()).getAlarm1Cal().get(Calendar.HOUR_OF_DAY));
			timepicker.setCurrentMinute(((GlobalVariables)getApplication()).getAlarm1Cal().get(Calendar.MINUTE));
			int typenumber;
			if (((GlobalVariables)getApplication()).Alarm1Type.compareToIgnoreCase("normal") == 0) {
				typenumber = 0;
				spinner1.setSelection(typenumber);
			} else if (((GlobalVariables)getApplication()).Alarm1Type.compareToIgnoreCase("math") == 0) {
				typenumber = 1;
				spinner1.setSelection(typenumber);
			} else if (((GlobalVariables)getApplication()).Alarm1Type.compareToIgnoreCase("word") == 0) {
				typenumber = 2;
				spinner1.setSelection(typenumber);
			}
		} else if (((GlobalVariables)getApplication()).getCurrentAlarmBeingEdited() == 2) {
			timepicker.setCurrentHour(((GlobalVariables)getApplication()).getAlarm2Cal().get(Calendar.HOUR_OF_DAY));
			timepicker.setCurrentMinute(((GlobalVariables)getApplication()).getAlarm2Cal().get(Calendar.MINUTE));
			int typenumber2;
			if (((GlobalVariables)getApplication()).Alarm2Type.compareToIgnoreCase("normal") == 0) {
				typenumber2 = 0;
				spinner1.setSelection(typenumber2);
			} else if (((GlobalVariables)getApplication()).Alarm2Type.compareToIgnoreCase("math") == 0) {
				typenumber2 = 1;
				spinner1.setSelection(typenumber2);
			} else if (((GlobalVariables)getApplication()).Alarm2Type.compareToIgnoreCase("word") == 0) {
				typenumber2 = 2;		
				spinner1.setSelection(typenumber2);
			}
		} else if (((GlobalVariables) getApplication())
				.getCurrentAlarmBeingEdited() == 3) {
			timepicker.setCurrentHour(((GlobalVariables) getApplication())
					.getAlarm3Cal().get(Calendar.HOUR_OF_DAY));
			timepicker
					.setCurrentMinute(((GlobalVariables) getApplication())
							.getAlarm3Cal().get(Calendar.MINUTE));
			int typenumber3;
			if (((GlobalVariables) getApplication()).Alarm3Type
					.compareToIgnoreCase("normal") == 0) {
				typenumber3 = 0;
				spinner1.setSelection(typenumber3);
			} else if (((GlobalVariables) getApplication()).Alarm3Type
					.compareToIgnoreCase("math") == 0) {
				typenumber3 = 1;
				spinner1.setSelection(typenumber3);
			} else if (((GlobalVariables) getApplication()).Alarm3Type
					.compareToIgnoreCase("word") == 0) {
				typenumber3 = 2;
				spinner1.setSelection(typenumber3);
			}
		}
	}



	public void setAlarm() {
		Calendar syscal = Calendar.getInstance(); 
		syscal.setTimeInMillis(System.currentTimeMillis());
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.set(Calendar.HOUR_OF_DAY, timepicker.getCurrentHour());
		calendar.set(Calendar.MINUTE, timepicker.getCurrentMinute());
		calendar.set(Calendar.SECOND, 0);
		
		if (calendar.getTimeInMillis() < syscal.getTimeInMillis()) { //if the alarm hour is less than the current hour
			calendar.add(Calendar.DATE, 1);                                 	//then add 24 hours (1 DATE or Day)					
		}		

		if (((GlobalVariables)getApplication()).getCurrentAlarmBeingEdited() == 1) {
			((GlobalVariables)getApplication()).setAlarm1Cal(calendar);
			if (dropBox.equals("Normal")) {
				((GlobalVariables)getApplication()).Alarm1Type = "Normal";
				Intent intent = new Intent(AlarmSettings.this, NormalAlarmReceiver.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
			} else if (dropBox.equals("Math Problem")) {
				((GlobalVariables)getApplication()).Alarm1Type = "Math";
				Intent intent = new Intent(AlarmSettings.this, MathScreen.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
			} else if (dropBox.equals("Word Problem")) {
				((GlobalVariables)getApplication()).Alarm1Type = "Word";
				Intent intent = new Intent(AlarmSettings.this, WordProblem.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
			}	
			Main.alarmTime1.setText(getAlarmTimeText(calendar));
			Main.checkBox1.setChecked(true);
			((GlobalVariables)getApplication()).Alarm1set(true);
			Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(calendar,syscal), Toast.LENGTH_LONG).show();
		} else if (((GlobalVariables)getApplication()).getCurrentAlarmBeingEdited() == 2) {
			((GlobalVariables)getApplication()).setAlarm2Cal(calendar);
			if (dropBox.equals("Normal")) {
				((GlobalVariables)getApplication()).Alarm2Type = "Normal";
				Intent intent = new Intent(AlarmSettings.this, NormalAlarmReceiver.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT); 
				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
			} else if (dropBox.equals("Math Problem")) {
				((GlobalVariables)getApplication()).Alarm2Type = "Math";
				Intent intent = new Intent(AlarmSettings.this, MathScreen.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
			} else if (dropBox.equals("Word Problem")) {
				((GlobalVariables)getApplication()).Alarm2Type = "Word";
				Intent intent = new Intent(AlarmSettings.this, WordProblem.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
			}	
			Main.alarmTime2.setText(getAlarmTimeText(calendar));
			Main.checkBox2.setChecked(true);
			((GlobalVariables)getApplication()).Alarm2set(true);
			Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(calendar,syscal), Toast.LENGTH_LONG).show();
		} else if (((GlobalVariables)getApplication()).getCurrentAlarmBeingEdited() == 3) {
			((GlobalVariables)getApplication()).setAlarm3Cal(calendar);
			if (dropBox.equals("Normal")) {
				((GlobalVariables)getApplication()).Alarm3Type = "Normal";
				Intent intent = new Intent(AlarmSettings.this, NormalAlarmReceiver.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 2, intent, PendingIntent.FLAG_ONE_SHOT); 
				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
			} else if (dropBox.equals("Math Problem")) {
				((GlobalVariables)getApplication()).Alarm3Type = "Math";
				Intent intent = new Intent(AlarmSettings.this, MathScreen.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 2, intent, PendingIntent.FLAG_ONE_SHOT);
				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
			} else if (dropBox.equals("Word Problem")) {
				((GlobalVariables)getApplication()).Alarm3Type = "Word";
				Intent intent = new Intent(AlarmSettings.this, WordProblem.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 2, intent, PendingIntent.FLAG_ONE_SHOT);
				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
			}	
			Main.alarmTime3.setText(getAlarmTimeText(calendar));
			Main.checkBox3.setChecked(true);
			((GlobalVariables)getApplication()).Alarm3set(true);
			Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(calendar,syscal), Toast.LENGTH_LONG).show();
		}
		dropBox2 = String.valueOf(spinner2.getSelectedItem());
		if (dropBox2.equals("Alarm Sound 1")) {
			((GlobalVariables)getApplication()).AlarmSound = 1;
		} else if (dropBox2.equals("Alarm Sound 2")) {
			((GlobalVariables)getApplication()).AlarmSound = 2;
		} else if (dropBox2.equals("Alarm Sound 3")) {
			((GlobalVariables)getApplication()).AlarmSound = 3;
		} else if (dropBox2.equals("Alarm Sound 4")) {
			((GlobalVariables)getApplication()).AlarmSound = 4;
		} else if (dropBox2.equals("Alarm Sound 5 (Special)")) {
			((GlobalVariables)getApplication()).AlarmSound = 5;
		}
		finish();		
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
			ret = ret + Integer.toString(hours) + " hours, " + Integer.toString(minutes) + " minutes, " + Integer.toString(seconds) + " seconds";
		} else if (hours == 1) {
			ret = ret + Integer.toString(hours) + " hour, " + Integer.toString(minutes) + " minutes, " + Integer.toString(seconds) + " seconds";
		} else if (hours == 0 && minutes == 0 ){
			ret = ret + Integer.toString(seconds) + " seconds.";
		} else {
			ret = ret + "      " + Integer.toString(minutes) + " minutes, " + Integer.toString(seconds) + " seconds";
		}
		return ret;
	}
	
	public CharSequence getAlarmTimeText(Calendar calendar) {
		StringBuilder sb = new StringBuilder();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute =calendar.get(Calendar.MINUTE);
		
		if (hour > 12 && hour - 12 > 9) {
			sb.append(hour - 12);
		} else if (hour > 12 && hour - 12 < 10) {
			sb.append("0");
			sb.append(hour - 12);
		} else if (hour > 9 && hour < 13) {
			sb.append(hour);
		} else if (hour == 0) {
			sb.append("12");
		} else {
			sb.append("0");
			sb.append(hour);
		}
		sb.append(":");
		if (minute < 10) {
			sb.append("0");
			sb.append(minute);
		} else {
			sb.append(minute);
		}   
        if (hour > 12) {
			sb.append("pm");
		} else {
			sb.append("am");
		}
        return sb;
	}
}