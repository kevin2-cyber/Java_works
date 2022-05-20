package com.codelab.javafire;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import com.codelab.javafire.databinding.ActivityLoginBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    // viewBinding
    private ActivityLoginBinding mBinding;

    // progressDialog
    private ProgressDialog progressDialog;

    private String email = "";

    private String password = "";

    // Firebase Auth
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        getSupportActionBar().hide();

        // configure progressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setMessage("Logging in");
        progressDialog.setCanceledOnTouchOutside(false);

        // init firebaseAuth
        mAuth = FirebaseAuth.getInstance();
        checkUser();

        // handle click, open SignUpActivity
        mBinding.noAccountTv.setOnClickListener(view -> {
            startActivity(new Intent(this, SignUpActivity.class));
        });

        // handle click, begin login
        mBinding.loginBtn.setOnClickListener(view -> {

            // before logging in, validate data
            validateData();
        });
    }

    private void validateData() {

        // get data
        email = mBinding.emailEt.getText().toString().trim();
        password = mBinding.passwordEt.getText().toString().trim();

        // validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            // invalid format
            mBinding.emailEt.setError("Invalid Email format");
        } else if (TextUtils.isEmpty(password)) {

            // no password entered
            mBinding.passwordEt.setError("Please enter password");
        } else {

            // data is validated, begin login
            firebaseLogin();
        }
    }

    private void firebaseLogin() {

        // show progress
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {

                    // login success
                    progressDialog.dismiss();

                    // get user info
                    FirebaseUser firebaseUser = mAuth.getCurrentUser();
                    assert firebaseUser != null;
                    String email = firebaseUser.getEmail();
                    Toast.makeText(this, "Logged in as" + email,

                            Toast.LENGTH_LONG).show();

                    // open profile
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                })
                .addOnFailureListener(e -> {

                    // login failed
                    progressDialog.dismiss();
                    Toast.makeText(this, "Login failed due to" + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                });
    }


    private void checkUser() {

        // if user is already logged in go to profile activity
        // get current user
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser != null) {

            // user is already logged in
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}