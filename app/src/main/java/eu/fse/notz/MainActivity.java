package eu.fse.notz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteActivity extends AppCompatActivity {

    EditText titleEt, descriptionEt;

    Button editConfirmBtn, deleteButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        titleEt = (EditText) findViewById(R.id.edit_title);
        descriptionEt = (EditText) findViewById(R.id.edit_description);
        editConfirmBtn = (Button) findViewById(R.id.edit_confirm);
        deleteButton = (Button) findViewById(R.id.edit_delete);

        //get values from launching intent
        final Intent intent = getIntent();
        final String title = intent.getStringExtra("title");
        final String description = intent.getStringExtra("description");

        // set values to Edittexts

        titleEt.setText(title);
        descriptionEt.setText(description);

        editConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editedTitle = titleEt.getText().toString();
                String editedDescription = descriptionEt.getText().toString();


                int position = intent.getIntExtra("position", -1);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("title", editedTitle);
                returnIntent.putExtra("description", editedDescription);
                returnIntent.putExtra("position", position);
                setResult(Activity.RESULT_OK, returnIntent);


                finish();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int position = intent.getIntExtra("position", -1);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("title", title);
                returnIntent.putExtra("description", description);
                returnIntent.putExtra("position", position);
                setResult(MainActivity.RESUL_REMOVE_NOTE, returnIntent);


                finish();


            }
        });

    }


    }
}




