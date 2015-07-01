package moravian.edu;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



// A Math Ringing Alarm
public class MathScreen extends Activity {
    
	Button snooze;
	EditText mathInputBox;
	String userInput;
	MathProblem mathProblem;
	String equation;
	TextView tv_mathProb;
	int answer;
	boolean resumed;
	boolean once;
	NotificationManager manager;

	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mathscreen);
        Intent intent = new Intent(MathScreen.this, SoundService.class);
    	startService(intent);
  
        if(!resumed) {
	        initButtonsAndStuff();
	        
	        // print equation on the screen
	        tv_mathProb.setText(equation);
	
	        if (once == false) {
	        	displayNotification("Alarm!");
	        	once = true;
	        }
	        
	        Toast.makeText(getApplicationContext(), "Answer: " + answer, Toast.LENGTH_LONG).show();
	        
	
	        
	        //if user inputs the matching answer after hitting the confirm button, then exit
	        
	        snooze.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) {
					try 
					{	
						userInput = mathInputBox.getText().toString();
					
					if (Integer.parseInt(userInput) == answer) {
						manager.cancel(1234);
						Intent intent = new Intent(MathScreen.this, SoundService.class);
		       			stopService(intent);
		       			intent = new Intent(MathScreen.this, SnoozeDismiss.class);
		    			startActivity(intent);
					}
					// Toast.makeText(getApplicationContext(), "STOP ALARM!~", Toast.LENGTH_LONG).show();
					} catch (NumberFormatException e) {
						// in case it is empty
						Toast.makeText(getApplicationContext(), "enter number please ", Toast.LENGTH_LONG).show();
					}
				}
		    });
        }
        
    }
    @Override
    public void onResume() {
    	super.onResume();
    	if (!resumed) {
    		resumed = true;
    		return;
    	}
    }
    public void initButtonsAndStuff() {
    	snooze = (Button) findViewById(R.id.btn_snooze_math);
    	mathInputBox = (EditText) findViewById(R.id.math_input);
    	tv_mathProb = (TextView) findViewById(R.id.tv_math_prob);
    	
    	mathProblem = new MathProblem();
    	equation = mathProblem.getEquation();
    	answer = mathProblem.getAnswer();
    	once = false;
    	
    }
    
    public void displayNotification(String msg) {
    	manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    	Notification notification = new Notification(R.drawable.ic_my, msg, System.currentTimeMillis());

    	Intent intent = new Intent(this, MathScreen.class);
    	
    	// intent.setFlags(Notification.FLAG_ONGOING_EVENT);
    	
    	Toast.makeText(getApplicationContext(), "toast ", Toast.LENGTH_LONG).show();
    	
    	notification.flags = Notification.FLAG_ONGOING_EVENT;
    	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
    	
	    // The PendingIntent will launch activity if the user selects this notification
	    PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
	
	    notification.setLatestEventInfo(this, "Math Alarm", "Solve Math Problem to shut it off..", contentIntent);
	    manager.notify(1234, notification);
    }
}