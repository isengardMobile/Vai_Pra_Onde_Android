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

        FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_main);

        AccessToken accessToken = AccessToken.getCurrentAccessToken();

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken1) {

            }


        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                Intent intent;
                if (accessTokenTracker.isTracking()){

                    intent = new Intent(MainActivity.this, CadastroActivity.class);
                }
                else{
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                }

                startActivity(intent);


            }

        }, 5000);





    }
}
