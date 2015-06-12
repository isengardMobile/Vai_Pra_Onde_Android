package isengardmobile.com.br.vaipraonde;


import android.app.AlertDialog;
import android.content.Intent;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.Profile;


public class ProfileActivity extends ActionBarActivity {


    private Profile profile;
    private ImageView profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImage = (ImageView) findViewById(R.id.profileImage);
        profile = Profile.getCurrentProfile();

        Toast.makeText(this, profile.getProfilePictureUri(100, 100).toString(), Toast.LENGTH_SHORT).show();
        profileImage.setImageURI(profile.getProfilePictureUri(100, 100));





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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

//    private class BuscaFotoPerfil extends AsyncTask<Integer, Void, String>{
//
//        @Override
//        protected String doInBackground(Integer... params) {
//
//            return null;
//        }
//    }
}
