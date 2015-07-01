package moravian.edu;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class SoundService extends Service {
	MediaPlayer player;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {	
		if (((GlobalVariables) getApplication()).AlarmSound == 1) {
			player = MediaPlayer.create(this, R.raw.sound1);
		} else if (((GlobalVariables) getApplication()).AlarmSound == 2) {
			player = MediaPlayer.create(this, R.raw.sound2);
		} else if (((GlobalVariables) getApplication()).AlarmSound == 3) {
			player = MediaPlayer.create(this, R.raw.sound3);
		} else if (((GlobalVariables) getApplication()).AlarmSound == 4) {
			player = MediaPlayer.create(this, R.raw.sound4);
		} else if (((GlobalVariables) getApplication()).AlarmSound == 5) {
			player = MediaPlayer.create(this, R.raw.sound);
		}
		player.setLooping(true); // Set looping
	}

	@Override
	public void onDestroy() {
		player.stop();
	}
	
	@Override
	public void onStart(Intent intent, int startid) {
		player.start();
	}
}
