package isengardmobile.com.br.vaipraonde;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.parse.Parse;

/**
 * Created by danilo on 23/07/15.
 */
public class VaiPraOndeApplicaton extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "I8SB9GFf3Ifjh7ftkJmxwH1RQicwQRdJygamgfE7", "aIPIxZnL14ccioidvxqmmV5AOiT75HiI5kG2k3rU");
    }
}
