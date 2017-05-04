package androidlab.epam.com.task2module;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSend;
    EditText mail,theme,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button) findViewById(R.id.btnSend);
        mail = (EditText) findViewById(R.id.editEmail);
        theme = (EditText) findViewById(R.id.editTheme);
        message= (EditText) findViewById(R.id.editText);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { mail.getText().toString() });
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,theme.getText().toString() );
                emailIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    Toast.makeText(MainActivity.this, "Email sent", Toast.LENGTH_SHORT).show();

                }
                catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
