package isengardmobile.com.br.vaipraonde;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by danilo on 27/07/15.
 */
public class MainActivity extends Activity {
    private CallbackManager callbackManager;
    private  AccessTokenTracker accessTokenTracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                Intent intent;
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);


            }

        }, 5000);





    }
}
