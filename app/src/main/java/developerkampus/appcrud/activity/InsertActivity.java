package developerkampus.appcrud.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import developerkampus.appcrud.R;
import developerkampus.appcrud.config.InsertUser;

public class InsertActivity extends AppCompatActivity {
    EditText EdtNama,EdtUsername,EdtPassword,EdtAlamat,EdtNoTelp;
    Button BtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        EdtNama = (EditText)findViewById(R.id.et_namalengkap);
        EdtUsername = (EditText)findViewById(R.id.et_username);
        EdtPassword = (EditText)findViewById(R.id.et_password);
        EdtAlamat = (EditText)findViewById(R.id.et_alamat);
        EdtNoTelp = (EditText)findViewById(R.id.et_notelp);
        BtnSave = (Button)findViewById(R.id.btn_save);

        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new InsertUser(InsertActivity.this).execute(
                        EdtNama.getText().toString(),EdtUsername.getText().toString(),
                        EdtPassword.getText().toString(),EdtAlamat.getText().toString(),EdtNoTelp.getText().toString()
                );
            }
        });


    }
}
