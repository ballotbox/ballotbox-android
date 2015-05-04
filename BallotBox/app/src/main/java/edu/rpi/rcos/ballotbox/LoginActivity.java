package edu.rpi.rcos.ballotbox;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gulena.ballotbox.R;


public class LoginActivity extends Activity {
    DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataManager = getIntent().getParcelableExtra("data_manager");
        setContentView(R.layout.activity_login);
        Button submit = (Button)findViewById(R.id.login_submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitLogin();
            }
        });
    }

    public boolean submitLogin() {
        EditText username_text = (EditText)findViewById(R.id.username_input);
        String username = username_text.getText().toString();
        EditText password_text = (EditText)findViewById(R.id.password_input);
        String password = password_text.getText().toString();

        if(dataManager.login(username, password)) {
            Intent intent = new Intent(this,MainMenuActivity.class);
            intent.putExtra("data_manager",dataManager);
            startActivity(intent);
            finish();
            return true;
        } else {
            Toast.makeText(this,"Incorrect username and password",Toast.LENGTH_LONG);
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast msg = Toast.makeText(this,"Settings selected",Toast.LENGTH_LONG);
            msg.show();
            return true;
        } else if(id == R.id.menu_public_votes) {
            Intent intent = new Intent(this,PublicVotesActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
