package com.example.blogpost;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.appsearch.StorageInfo;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton blogPost_img;
    EditText blogPost_title, blogPost_text;
    Button blogPost_btn;
    Uri mImageUri;

    static final int  GALLERY_REQUEST = 1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blogPost_img=(ImageButton) findViewById(R.id.blogPost_img);
        blogPost_title=(EditText)findViewById(R.id.blogPost_title);
        blogPost_text=(EditText)findViewById(R.id.blogPost_text);
        blogPost_btn=(Button)findViewById(R.id.blogPost_btn);


        blogPost_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);
            }
        });

        blogPost_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startPosting();
            }
        });
    }

    private void startPosting() {

        String title_val = blogPost_title.getText().toString().trim();
        String text_val = blogPost_text.getText().toString().trim();

        if(!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(text_val) && mImageUri != null){



        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_REQUEST && resultCode == RESULT_OK){
            mImageUri = data.getData();
            blogPost_img.setImageURI(mImageUri);
        }
    }
}