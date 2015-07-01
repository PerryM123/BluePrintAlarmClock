package moravian.edu;

import java.util.Calendar;

import android.app.Application;

public class GlobalVariables extends Application {
	protected int CurrentAlarmBeingEdited;
	protected Calendar Alarm1Cal;
	protected Calendar Alarm2Cal;
	protected Calendar Alarm3Cal;
	protected String Alarm1Type;
	protected String Alarm2Type;
	protected String Alarm3Type;
	protected boolean Alarm1isSet;
	protected boolean Alarm2isSet;
	protected boolean Alarm3isSet;
	protected int AlarmSound;
	
	public GlobalVariables() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.DATE, 1);
		Alarm1Cal = calendar;
		Alarm2Cal = calendar;
		Alarm3Cal = calendar;
		Alarm1Type = "normal";
		Alarm2Type = "normal";
		Alarm3Type = "normal";
		AlarmSound = 1;
		
	}
	public void setCurrentAlarmBeingEdited(int i) {
		CurrentAlarmBeingEdited = i;
	}
	
	public int getCurrentAlarmBeingEdited() {
		return CurrentAlarmBeingEdited;
	}
	
	public void setAlarm1Cal(Calendar calendar) {
		Alarm1Cal = calendar;
	}
	
	public Calendar getAlarm1Cal() {
		return Alarm1Cal;
	}
	
	public void setAlarm2Cal(Calendar calendar) {
		Alarm2Cal = calendar;
	}
	
	public Calendar getAlarm2Cal() {
		return Alarm2Cal;
	}
	
	public void setAlarm3Cal(Calendar calendar) {
		Alarm3Cal = calendar;
	}
	
	public Calendar getAlarm3Cal() {
		return Alarm3Cal;
	}
	
	public void Alarm1set(boolean b) {
		Alarm1isSet = b;
	}
	
	public void Alarm2set(boolean b) {
		Alarm2isSet = b;
	}
	
	public void Alarm3set(boolean b) {
		Alarm3isSet = b;
	}
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Application#onCreate()
	 * We can initialize / reinitialize the variables to the current hour and minute
	 */
	/*
	@Override
	public void onCreate() {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		if (c.get(Calendar.HOUR_OF_DAY) > 12) {
			AMorPM = "PM";
		} else {
			AMorPM = "AM";
		}
		alarmHours = c.get(Calendar.HOUR);
		alarmMinutes = c.get(Calendar.MINUTE);
		
	}*/
}
