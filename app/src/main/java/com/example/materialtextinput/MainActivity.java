package com.example.materialtextinput;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout nameLayout, emailLayout, passwordLayout, contactLayout;
    EditText name, email, password, contact;
    MaterialButton clearAllButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing Text Input Layouts
        nameLayout = findViewById(R.id.name_layout);
        emailLayout = findViewById(R.id.email_layout);
        passwordLayout = findViewById(R.id.password_layout);
        contactLayout = findViewById(R.id.contact_layout);
        //Initializing EditTexts
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        password = findViewById(R.id.password);
        //Initializing Button
        clearAllButton = findViewById(R.id.clear_text_button);

        //Clearing Text With Button
        clearAllButton.setOnClickListener(view -> {
            //Clear Values
            name.getText().clear();
            email.getText().clear();
            contact.getText().clear();
            password.getText().clear();
            //Clear Focus
            contact.clearFocus();
            email.clearFocus();
            password.clearFocus();
        });

        //Setting Error If User Enters Something Incorrect
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Checking
                if (!charSequence.toString().isEmpty() && !charSequence.toString().matches("[a-zA-Z ]+")) {
                    //Shows error when value entered is not empty & contain numbers
                    nameLayout.setError("Allow only character");
                } else {
                    //Hide Error
                    nameLayout.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
}