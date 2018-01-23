package icsc.epharmacy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class RetailerDetails extends AppCompatActivity {
ImageView profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_details);
        profileImage =    (ImageView)findViewById(R.id.imageViewProfile);
    }
    public void onClickImage(View v){
        Intent i = new Intent(Intent.ACTION_GET_CONTENT); /// opens content from phone
        i.setType("image/*");// shows only images
        startActivityForResult(i,1); //brings back to the previous activity
    }

// gets called  automatically when control returns from galary activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data != null) {

            Uri  u = data.getData();//gives uri of selected image
           try {
               Bitmap bit = MediaStore.Images.Media.getBitmap(getContentResolver(), u);///extracts image from image folder
               profileImage.setImageBitmap(bit);
           }catch(IOException e){
               e.printStackTrace();
           }


        }
    }
}
