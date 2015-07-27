package isengardmobile.com.br.vaipraonde;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

import isengardmobile.com.br.vaipraonde.model.User;

public class CadastroActivity extends ActionBarActivity {

    private User user;
    private EditText name;
    private EditText lastName;
    private EditText email;
    private EditText confirmEmail;
    private EditText pass;
    private RadioButton sex;
    private EditText city;
    private EditText cell;
    private EditText username;
    private AccessTokenTracker accessTokenTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        name = (EditText) findViewById(R.id.cad_name);
        email = (EditText) findViewById(R.id.cad_email);

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {

            }
        };

        AccessToken accessToken = AccessToken.getCurrentAccessToken();

        accessTokenTracker.startTracking();
        user = new User();

        if(accessTokenTracker.isTracking()){
            GraphRequest request = GraphRequest.newMeRequest(
                    accessToken,
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {

                            Log.e("zimei", object.toString());
                            try {
                                user.setName(object.getString("name"));
                                user.setSex(object.getString("gender"));
                                user.setEmail(object.getString("email"));

                                name.setText(user.getName());
                                email.setText(user.getEmail());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            // Application code
                        }
                    });

            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,link,email,gender");
            request.setParameters(parameters);
            request.executeAsync();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
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

    public void searchFoto(View view) {
    }
}
