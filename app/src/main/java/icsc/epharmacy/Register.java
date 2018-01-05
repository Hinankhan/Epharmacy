package icsc.epharmacy;

import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=(EditText)findViewById(R.id.editTextName);
        password=(EditText)findViewById(R.id.editTextPassword);
        confirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
        email=(EditText)findViewById(R.id.editTextEmail);
    }
}
