package com.codelab.javafire;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import com.codelab.javafire.databinding.ActivitySignUpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity {

    // viewBinding
    private ActivitySignUpBinding mBinding;

    // actionBar
    private ActionBar actionBar;

    // progressDialog
    private ProgressDialog progressDialog;

    // Firebase Auth
    private FirebaseAuth mAuth;

    // credentials
    private String email;

    private String password;

    @SuppressLint("Deprecated")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        // configure progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Creating account");
        progressDialog.setCanceledOnTouchOutside(false);

        // init firebase auth
        mAuth = FirebaseAuth.getInstance();

        // handle click, begin sign up
        mBinding.signupBtn.setOnClickListener(view -> {

            // validate data
            validateData();
        });

        // navigate to login activity
        mBinding.account.setOnClickListener(view -> {
            startActivity(new Intent(this, LoginActivity.class));
        });
    }

    private void validateData() {

        //get data
        email = mBinding.emailEt.getText().toString().trim();
        password = mBinding.passwordEt.getText().toString().trim();

        // validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            // invalid email format
            mBinding.emailEt.setError("Invalid email format");
        } else if (TextUtils.isEmpty(password)) {

            // password isn't entered
            mBinding.passwordEt.setError("Please enter password");
        } else if (password.length() < 6) {

            // password is less than 6
            mBinding.passwordEt.setError("Password must be at least six characters long");
        } else {
            firebaseSignUp();
        }
    }

    private void firebaseSignUp() {

        // show progress
        progressDialog.show();

        // create account
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(task -> {

                    // sign up success
                    progressDialog.dismiss();

                    //get current user
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    assert firebaseUser != null;
                    String email = firebaseUser.getEmail();
                    Toast.makeText(this, "Account created with email" + email,
                            Toast.LENGTH_LONG).show();

                    // open profile
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> {

                    // sign up failed
                    progressDialog.dismiss();
                    Toast.makeText(this, "Sign up failed due to" + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                });
    }

    @Override
    public boolean onSupportNavigateUp() {

        // go to previous activity, when back button of actionBar is clicked
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}