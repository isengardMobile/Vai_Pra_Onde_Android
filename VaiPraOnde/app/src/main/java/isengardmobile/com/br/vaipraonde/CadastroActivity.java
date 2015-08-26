package isengardmobile.com.br.vaipraonde;

import android.app.Activity;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import isengardmobile.com.br.vaipraonde.api.StatesRepositoryApi;
import isengardmobile.com.br.vaipraonde.impl.StasteRepositoryApiImpl;
import isengardmobile.com.br.vaipraonde.impl.UserRepositoryImpl;
import isengardmobile.com.br.vaipraonde.isengardmobile.com.vaipraonde.views.CircleImageView;
import isengardmobile.com.br.vaipraonde.model.States;
import isengardmobile.com.br.vaipraonde.model.User;

public class CadastroActivity extends Activity {

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
    private CircleImageView cadPhoto;
    private Spinner states;
    private Button cadButton;

    private StatesRepositoryApi statesRepository;
    private UserRepositoryImpl userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        name = (EditText) findViewById(R.id.cad_name);
        lastName = (EditText) findViewById(R.id.cad_last_name);
        pass = (EditText) findViewById(R.id.cad_password);
        email = (EditText) findViewById(R.id.cad_email);
        lastName = (EditText) findViewById(R.id.cad_last_name);
        cadPhoto = (CircleImageView) findViewById(R.id.cad_photo);

        states = (Spinner) findViewById(R.id.cad_states);

        statesRepository = new StasteRepositoryApiImpl();

        ArrayAdapter<States> adapter = new ArrayAdapter<States>(this, android.R.layout.simple_spinner_item, statesRepository.findAll());
        states.setAdapter(adapter);

        cadButton = (Button) findViewById(R.id.btn_cadastrar);

    }

//    private Boolean validaCadastro(User user){
//        if(user.getName() == null || user.getBirthday() == null || user.getCell() == null || user.getEmail() == null){
//            return Boolean.TRUE;
//        }
//        return Boolean.FALSE;
//    }

    public void cadastrar(View view){
        User user = new User();



        try {
            userRepository.create(user);
        } catch (ParseException e) {
            e.printStackTrace();
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
