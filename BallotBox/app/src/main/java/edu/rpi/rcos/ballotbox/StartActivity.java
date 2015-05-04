package edu.rpi.rcos.ballotbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataManager dataManager = new TestDataManager();
        if(dataManager.isLoggedIn()) {
            Intent intent = new Intent(this,MainMenuActivity.class);
            intent.putExtra("data_manager",dataManager);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this,LoginActivity.class);
            intent.putExtra("data_manager", dataManager);
            startActivity(intent);
        }
    }
}
