package moravian.edu;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends Activity {
    Button Close;
    private boolean resumed;
    public static TextView alarmTime1;
    public static TextView alarmTime2;
    public static TextView alarmTime3;
    public static CheckBox checkBox1;
    public static CheckBox checkBox2;
    public static CheckBox checkBox3;
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    Button test;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      
        if (!resumed) {
        	
        	test = (Button) findViewById(R.id.btn_test);
        	Close = (Button) findViewById(R.id.Close);
	        
	    	alarmTime1 = (TextView) findViewById(R.id.AlarmTime1);
	    	alarmTime2 = (TextView) findViewById(R.id.AlarmTime2);
	    	alarmTime3 = (TextView) findViewById(R.id.AlarmTime3);
	    	
	    	checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
	    	checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
	    	checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
	    	
	    	alarmTime1.setOnClickListener(new View.OnClickListener() {
	    		@Override
				public void onClick(View v) {
	    			Intent intent = new Intent(Main.this, AlarmSettings.class);
	    			((GlobalVariables)getApplication()).setCurrentAlarmBeingEdited(1);
	    			startActivity(intent);
	    		}
	    	});
	    	
	    	checkBox1.setOnClickListener(new View.OnClickListener() {
	    		@Override
	    		public void onClick(View v) {
	    			if (((CheckBox) v).isChecked()) {
	    				if (((GlobalVariables)getApplication()).Alarm1Type.compareToIgnoreCase("Normal") == 0) {
	    					if (((GlobalVariables)getApplication()).Alarm1Cal.getTimeInMillis() < System.currentTimeMillis()) { //if the alarm hour is less than the current hour
	    						((GlobalVariables)getApplication()).Alarm1Cal.add(Calendar.DATE, 1);                                 	//then add 24 hours (1 DATE or Day)					
	    					}
	    					Intent intent = new Intent(Main.this, NormalAlarmReceiver.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, ((GlobalVariables)getApplication()).getAlarm1Cal().getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);	    				
		    				((GlobalVariables)getApplication()).Alarm1set(true);
		    				Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(((GlobalVariables)getApplication()).getAlarm1Cal(),Calendar.getInstance()), Toast.LENGTH_LONG).show();
	    				} else if (((GlobalVariables)getApplication()).Alarm1Type.compareToIgnoreCase("Math") == 0) {
	    					if (((GlobalVariables)getApplication()).Alarm1Cal.getTimeInMillis() < System.currentTimeMillis()) { //if the alarm hour is less than the current hour
	    						((GlobalVariables)getApplication()).Alarm1Cal.add(Calendar.DATE, 1);                                 	//then add 24 hours (1 DATE or Day)					
	    					}
	    					Intent intent = new Intent(Main.this, MathScreen.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, ((GlobalVariables)getApplication()).getAlarm1Cal().getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);	    				
		    				((GlobalVariables)getApplication()).Alarm1set(true);
		    				Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(((GlobalVariables)getApplication()).getAlarm1Cal(),Calendar.getInstance()), Toast.LENGTH_LONG).show();
	    				} else if (((GlobalVariables)getApplication()).Alarm1Type.compareToIgnoreCase("Word") == 0) {
	    					if (((GlobalVariables)getApplication()).Alarm1Cal.getTimeInMillis() < System.currentTimeMillis()) { //if the alarm hour is less than the current hour
	    						((GlobalVariables)getApplication()).Alarm1Cal.add(Calendar.DATE, 1);                                 	//then add 24 hours (1 DATE or Day)					
	    					}
	    					Intent intent = new Intent(Main.this, WordProblem.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, ((GlobalVariables)getApplication()).getAlarm1Cal().getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);	    				
		    				((GlobalVariables)getApplication()).Alarm1set(true);
		    				Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(((GlobalVariables)getApplication()).getAlarm1Cal(),Calendar.getInstance()), Toast.LENGTH_LONG).show();
	    				}
	    				
	    			} else {	
	    				if (((GlobalVariables)getApplication()).Alarm1Type.compareToIgnoreCase("Normal") == 0) {
	    					Intent intent = new Intent(Main.this, NormalAlarmReceiver.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.cancel(pendingIntent);
		    				((GlobalVariables)getApplication()).Alarm1set(false);
		    				Toast.makeText(getApplicationContext(),"Alarm deactivated.", Toast.LENGTH_SHORT).show();	    
	    				} else if (((GlobalVariables)getApplication()).Alarm1Type.compareToIgnoreCase("Math") == 0) {
	    					Intent intent = new Intent(Main.this, MathScreen.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.cancel(pendingIntent);
		    				((GlobalVariables)getApplication()).Alarm1set(false);
		    				Toast.makeText(getApplicationContext(),"Alarm deactivated.", Toast.LENGTH_SHORT).show();	    
	    				} else if (((GlobalVariables)getApplication()).Alarm1Type.compareToIgnoreCase("Word") == 0) {
	    					Intent intent = new Intent(Main.this, WordProblem.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.cancel(pendingIntent);
		    				((GlobalVariables)getApplication()).Alarm1set(false);
		    				Toast.makeText(getApplicationContext(),"Alarm deactivated.", Toast.LENGTH_SHORT).show();	    
	    				}				
	    			}
	    		}
	    	});
	    	
	    	alarmTime2.setOnClickListener(new View.OnClickListener() {
	    		@Override
				public void onClick(View v) {
	    			Intent intent = new Intent(Main.this, AlarmSettings.class);
	    			((GlobalVariables)getApplication()).setCurrentAlarmBeingEdited(2);
	    			startActivity(intent);
	    		}
	    	});
	    	
	    	checkBox2.setOnClickListener(new View.OnClickListener() {
	    		@Override
	    		public void onClick(View v) {
	    			if (((CheckBox) v).isChecked()) {
	    				if (((GlobalVariables)getApplication()).Alarm2Type.compareToIgnoreCase("Normal") == 0) {
	    					if (((GlobalVariables)getApplication()).Alarm2Cal.getTimeInMillis() < System.currentTimeMillis()) { //if the alarm hour is less than the current hour
	    						((GlobalVariables)getApplication()).Alarm2Cal.add(Calendar.DATE, 1);                                 	//then add 24 hours (1 DATE or Day)					
	    					}
	    					Intent intent = new Intent(Main.this, NormalAlarmReceiver.class);
	    					((GlobalVariables)getApplication()).Alarm2set(true);
		    				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, ((GlobalVariables)getApplication()).getAlarm2Cal().getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
		    				Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(((GlobalVariables)getApplication()).getAlarm2Cal(),Calendar.getInstance()), Toast.LENGTH_LONG).show();	
	    				} else if (((GlobalVariables)getApplication()).Alarm2Type.compareToIgnoreCase("Math") == 0) {
	    					if (((GlobalVariables)getApplication()).Alarm2Cal.getTimeInMillis() < System.currentTimeMillis()) { //if the alarm hour is less than the current hour
	    						((GlobalVariables)getApplication()).Alarm2Cal.add(Calendar.DATE, 1);                                 	//then add 24 hours (1 DATE or Day)					
	    					}
	    					Intent intent = new Intent(Main.this, MathScreen.class);
	    					((GlobalVariables)getApplication()).Alarm2set(true);
		    				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, ((GlobalVariables)getApplication()).getAlarm2Cal().getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
		    				Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(((GlobalVariables)getApplication()).getAlarm2Cal(),Calendar.getInstance()), Toast.LENGTH_LONG).show();	
	    				} else if (((GlobalVariables)getApplication()).Alarm2Type.compareToIgnoreCase("Word") == 0) {
	    					if (((GlobalVariables)getApplication()).Alarm2Cal.getTimeInMillis() < System.currentTimeMillis()) { //if the alarm hour is less than the current hour
	    						((GlobalVariables)getApplication()).Alarm2Cal.add(Calendar.DATE, 1);                                 	//then add 24 hours (1 DATE or Day)					
	    					}
	    					Intent intent = new Intent(Main.this, WordProblem.class);
	    					((GlobalVariables)getApplication()).Alarm2set(true);
		    				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, ((GlobalVariables)getApplication()).getAlarm2Cal().getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
		    				Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(((GlobalVariables)getApplication()).getAlarm2Cal(),Calendar.getInstance()), Toast.LENGTH_LONG).show();	
	    				}
	    				
	    			} else {
	    				if (((GlobalVariables)getApplication()).Alarm2Type.compareToIgnoreCase("Normal") == 0) {
	    					Intent intent = new Intent(Main.this, NormalAlarmReceiver.class);
	    					((GlobalVariables)getApplication()).Alarm2set(false);
		    				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.cancel(pendingIntent);
		    				Toast.makeText(getApplicationContext(),"Alarm deactivated.", Toast.LENGTH_SHORT).show();	    
	    				} else if (((GlobalVariables)getApplication()).Alarm2Type.compareToIgnoreCase("Math") == 0) {
	    					Intent intent = new Intent(Main.this, MathScreen.class);
	    					((GlobalVariables)getApplication()).Alarm2set(false);
		    				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.cancel(pendingIntent);
		    				Toast.makeText(getApplicationContext(),"Alarm deactivated.", Toast.LENGTH_SHORT).show();	    
	    				} else if (((GlobalVariables)getApplication()).Alarm2Type.compareToIgnoreCase("Word") == 0) {
	    					Intent intent = new Intent(Main.this, WordProblem.class);
	    					((GlobalVariables)getApplication()).Alarm2set(false);
		    				PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.cancel(pendingIntent);
		    				Toast.makeText(getApplicationContext(),"Alarm deactivated.", Toast.LENGTH_SHORT).show();	    
	    				}   				
	    			}
	    		}
	    	});
	    	
	    	alarmTime3.setOnClickListener(new View.OnClickListener() {
	    		@Override
				public void onClick(View v) {
	    			Intent intent = new Intent(Main.this, AlarmSettings.class);
	    			((GlobalVariables)getApplication()).setCurrentAlarmBeingEdited(3);
	    			startActivity(intent);
	    		}
	    	});
	    	
	    	checkBox3.setOnClickListener(new View.OnClickListener() {
	    		@Override
	    		public void onClick(View v) {
	    			if (((CheckBox) v).isChecked()) {
	    				if (((GlobalVariables)getApplication()).Alarm3Type.compareToIgnoreCase("Normal") == 0) {
	    					if (((GlobalVariables)getApplication()).Alarm3Cal.getTimeInMillis() < System.currentTimeMillis()) { //if the alarm hour is less than the current hour
	    						((GlobalVariables)getApplication()).Alarm3Cal.add(Calendar.DATE, 1);                                 	//then add 24 hours (1 DATE or Day)					
	    					}
	    					Intent intent = new Intent(Main.this, NormalAlarmReceiver.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 2, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, ((GlobalVariables)getApplication()).getAlarm3Cal().getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
		    				Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(((GlobalVariables)getApplication()).getAlarm3Cal(),Calendar.getInstance()), Toast.LENGTH_LONG).show();
	    				} else if (((GlobalVariables)getApplication()).Alarm3Type.compareToIgnoreCase("Math") == 0) {
	    					if (((GlobalVariables)getApplication()).Alarm3Cal.getTimeInMillis() < System.currentTimeMillis()) { //if the alarm hour is less than the current hour
	    						((GlobalVariables)getApplication()).Alarm3Cal.add(Calendar.DATE, 1);                                 	//then add 24 hours (1 DATE or Day)					
	    					}
	    					Intent intent = new Intent(Main.this, MathScreen.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 2, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, ((GlobalVariables)getApplication()).getAlarm3Cal().getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
		    				Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(((GlobalVariables)getApplication()).getAlarm3Cal(),Calendar.getInstance()), Toast.LENGTH_LONG).show();
	    				} else if (((GlobalVariables)getApplication()).Alarm3Type.compareToIgnoreCase("Word") == 0) {
	    					if (((GlobalVariables)getApplication()).Alarm3Cal.getTimeInMillis() < System.currentTimeMillis()) { //if the alarm hour is less than the current hour
	    						((GlobalVariables)getApplication()).Alarm3Cal.add(Calendar.DATE, 1);                                 	//then add 24 hours (1 DATE or Day)					
	    					}
	    					Intent intent = new Intent(Main.this, WordProblem.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 2, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP, ((GlobalVariables)getApplication()).getAlarm3Cal().getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
		    				Toast.makeText(getApplicationContext(), "The alarm is set to go off in: \n " + getTimeDifference(((GlobalVariables)getApplication()).getAlarm3Cal(),Calendar.getInstance()), Toast.LENGTH_LONG).show();
	    				}
	    			} else {
	    				if (((GlobalVariables)getApplication()).Alarm3Type.compareToIgnoreCase("Normal") == 0) {
	    					Intent intent = new Intent(Main.this, NormalAlarmReceiver.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 2, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.cancel(pendingIntent);
		    				((GlobalVariables)getApplication()).Alarm1set(false);
		    				Toast.makeText(getApplicationContext(),"Alarm deactivated.", Toast.LENGTH_SHORT).show();
	    				} else if (((GlobalVariables)getApplication()).Alarm3Type.compareToIgnoreCase("Math") == 0) {
	    					Intent intent = new Intent(Main.this, MathScreen.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 2, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.cancel(pendingIntent);
		    				((GlobalVariables)getApplication()).Alarm1set(false);
		    				Toast.makeText(getApplicationContext(),"Alarm deactivated.", Toast.LENGTH_SHORT).show();
	    				} else if (((GlobalVariables)getApplication()).Alarm3Type.compareToIgnoreCase("Word") == 0) {
	    					Intent intent = new Intent(Main.this, WordProblem.class);
	    					PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 2, intent, PendingIntent.FLAG_ONE_SHOT);
		    				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);
		    				alarmmanager.cancel(pendingIntent);
		    				((GlobalVariables)getApplication()).Alarm1set(false);
		    				Toast.makeText(getApplicationContext(),"Alarm deactivated.", Toast.LENGTH_SHORT).show();
	    				}			
	    			}
	    		}
	    	});
	    	
			Close.setOnClickListener(new Button.OnClickListener() {
				@Override
				public void onClick(View v) {
					finish();
				}
			});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	        test.setOnClickListener(new Button.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent222 = new Intent(Main.this, WordProblem.class);
			        startActivity(intent222);
				}
			});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		}
	}
   
    
    @Override
    public void onResume() {
    	super.onResume();
    	if(!resumed) {
    		resumed = true;
    	}
    	alarmTime1.setText(getAlarmTimeText(((GlobalVariables)getApplication()).getAlarm1Cal()));
		alarmTime2.setText(getAlarmTimeText(((GlobalVariables)getApplication()).getAlarm2Cal()));
		alarmTime3.setText(getAlarmTimeText(((GlobalVariables)getApplication()).getAlarm3Cal()));
		checkBox1.setChecked(((GlobalVariables)getApplication()).Alarm1isSet);
		checkBox2.setChecked(((GlobalVariables)getApplication()).Alarm2isSet);
		checkBox3.setChecked(((GlobalVariables)getApplication()).Alarm3isSet);
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
    /*
    @Override 
    public void onSaveInstanceState(Bundle savedInstanceState) {
    	super.onSaveInstanceState(savedInstanceState);
    	savedInstanceState.putInt("Alarm1Hour",((GlobalVariables)getApplication()).getAlarm1Cal().get(Calendar.HOUR));
    	savedInstanceState.putInt("Alarm1Minute",((GlobalVariables)getApplication()).getAlarm1Cal().get(Calendar.MINUTE));
    	savedInstanceState.putInt("Alarm2Hour",((GlobalVariables)getApplication()).getAlarm2Cal().get(Calendar.HOUR));
    	savedInstanceState.putInt("Alarm2Minute",((GlobalVariables)getApplication()).getAlarm2Cal().get(Calendar.MINUTE));
    	savedInstanceState.putInt("Alarm3Hour",((GlobalVariables)getApplication()).getAlarm3Cal().get(Calendar.HOUR));
    	savedInstanceState.putInt("Alarm3Minute",((GlobalVariables)getApplication()).getAlarm3Cal().get(Calendar.MINUTE));
    }
    
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	Calendar cal1 = Calendar.getInstance();
    	Calendar cal2 = Calendar.getInstance();
    	Calendar cal3 = Calendar.getInstance();
    	cal1.setTimeInMillis(System.currentTimeMillis());
    	cal2.setTimeInMillis(System.currentTimeMillis());
    	cal3.setTimeInMillis(System.currentTimeMillis());
    	cal1.set(Calendar.HOUR_OF_DAY, savedInstanceState.getInt("Alarm1Hour"));
		cal1.set(Calendar.MINUTE, savedInstanceState.getInt("Alarm1Minute"));
		cal2.set(Calendar.HOUR_OF_DAY, savedInstanceState.getInt("Alarm2Hour"));
		cal2.set(Calendar.MINUTE, savedInstanceState.getInt("Alarm2Minute"));
		cal3.set(Calendar.HOUR_OF_DAY, savedInstanceState.getInt("Alarm3Hour"));
		cal3.set(Calendar.MINUTE, savedInstanceState.getInt("Alarm3Minute"));
		
		alarmTime1.setText(getAlarmTimeText(cal1));
		alarmTime2.setText(getAlarmTimeText(cal2));
		alarmTime3.setText(getAlarmTimeText(cal3));
    }
    */
    
}