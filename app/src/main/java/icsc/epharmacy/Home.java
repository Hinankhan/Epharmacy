package icsc.epharmacy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {


    private EditText  username;
    private EditText password;
    private Button signIn;
    private TextView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        username = (EditText) findViewById(R.id.editTextUsername);
        password = (EditText) findViewById(R.id.editTextPassword);
        signIn = (Button) findViewById(R.id.buttonSignIn);
        signUp = (TextView) findViewById(R.id.textViewSignUp);
    }

    public void onClickSignIn(View v){

        if(isUsernameEmpty(username.getText().toString()))
            username.setError("Username is Required field");
        else if(isPasswordEmpty(password.getText().toString()))
            password.setError("Password is Required field");
        else if(!isUsernameValid(username.getText().toString()))
            username.setError("Username must contain atleast 3 chars ");
        else if(!isPasswordValid(password.getText().toString()))
            password.setError("Password must be atleast 8 chars long");
        else
            Toast.makeText(this,"welcome",Toast.LENGTH_LONG).show();

    }

    boolean isUsernameEmpty(String name){
        if (name.length()==0)
            return true;
        else
            return false;
    }
    boolean isUsernameValid(String name){
        if (name.length()>=3 && name.length()<=20)
            return true;
        else
            return false;
    }
    boolean isPasswordValid(String pass){
        if (pass.length()>=8 && pass.length()<=20)
            return true;
        else
            return false;
    }
    boolean isPasswordEmpty(String pass){
        if (pass.length()==0)
            return true;
        else
            return false;
    }


    public void createAnAccount(View v){
        Intent i = new Intent(this,Register.class);
        startActivity(i);
    }
  /*  boolean isValidUsername(String name){
        if (name.length()==0)
            return false;
    }*/


}
