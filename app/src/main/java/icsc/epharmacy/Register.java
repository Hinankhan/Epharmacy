package icsc.epharmacy;

import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText confirmPassword;
    private EditText email;
    DatabaseManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=(EditText)findViewById(R.id.editTextName);
        password=(EditText)findViewById(R.id.editTextPassword);
        confirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);
        email=(EditText)findViewById(R.id.editTextEmail);
        db = new DatabaseManager(this);
    }
    public void onClickRegister(View v){

        if(isUsernameEmpty(username.getText().toString()))
            username.setError("Username is Required field");
        else if(isPasswordEmpty(password.getText().toString()))
            password.setError("Password is Required field");
        else if(isConfirmPasswordEmpty(confirmPassword.getText().toString()))
            confirmPassword.setError("Confirm password is required field");
        else if(isEmailEmpty(email.getText().toString()))
            email.setError("Email is required field");
        else if(!isUsernameValid(username.getText().toString()))
            username.setError("Username must contain atleast 3 chars ");
        else if(!isEmailValid(email.getText().toString()))
            email.setError("Email must contain atleast 3 chars ");
        else if(!isPasswordValid(password.getText().toString()))
            password.setError("Password must be atleast 8 chars long");
        else if(!password.getText().toString().equals(confirmPassword.getText().toString()))
            confirmPassword.setError("Confirm password must match with password field");
        else {
            //Toast.makeText(this,"welcome",Toast.LENGTH_LONG).show();
            boolean result = db.registerUser(email.getText().toString(), username.getText().toString(), password.getText().toString());
            if(result == true)
                Toast.makeText(this,"Registered successfully",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this,"Error occurred, Try again",Toast.LENGTH_LONG).show();

        }
    }

    boolean isUsernameValid(String name){
        if (name.length()>=3 && name.length()<=20)
            return true;
        else
            return false;
    }
    boolean isEmailValid(String e){
        if (e.length()>=3 && e.length()<=20)
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
    boolean isConfirmPasswordEmpty(String pass){
        if (pass.length()==0)
            return true;
        else
            return false;
    }
    boolean isEmailEmpty(String e){
        if (e.length()==0)
            return true;
        else
            return false;
    }
    boolean isUsernameEmpty(String name){
        if (name.length()==0)
            return true;
        else
            return false;
    }
}
