package icsc.epharmacy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RetailerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer);
    }
    public void onClickFAb(View v)
    {
        Intent i = new Intent(this,RetailerDetails.class);
        startActivity(i);

    }
}
