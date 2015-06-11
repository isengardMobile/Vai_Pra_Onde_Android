package isengardmobile.com.br.vaipraonde;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.facebook.Profile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class ProfileActivity extends ActionBarActivity {

    private ImageView profileImage;
    private Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImage = (ImageView) findViewById(R.id.profileImage);

        Bundle params = getIntent().getExtras();
        profile = (Profile) params.get("profile");

        try {
            URL imageURL = new URL("https://graph.facebook.com/" + profile.getId() + "/picture?type=large");
            Bitmap bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());

            profileImage.setImageBitmap(bitmap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
