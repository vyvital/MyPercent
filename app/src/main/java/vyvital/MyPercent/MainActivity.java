package vyvital.MyPercent;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    TextView totalTextView;
    EditText percentageTxt;
    EditText numberTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        totalTextView = (TextView) findViewById(R.id.totalTextView);
        percentageTxt = (EditText) findViewById(R.id.percentageTxt);
        numberTxt = (EditText) findViewById(R.id.numberTxt);
        Button calcBtn = (Button) findViewById(R.id.button);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (percentageTxt.getText().length() == 0 || numberTxt.getText().length() == 0) {
                    AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
                    build.setCancelable(true);
                    build.setTitle(Html.fromHtml("<font color='#ff4081'><b>Input Error!</b></font>"));
                    build.setMessage(Html.fromHtml("<font color='#ff4081'>Dear user, please make sure you have added input in both fields.</font>"));
                    build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    build.show();
                } else {
                    float percentage = Float.parseFloat(percentageTxt.getText().toString());
                    float dec = percentage / 100;
                    float num = Float.parseFloat(numberTxt.getText().toString());
                    float total = dec * num;
                    totalTextView.setText(Float.toString(total));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Html.fromHtml("<font color='#ff4081'>A Simple yet cool percentage calculator app.</font>"));
        builder.setPositiveButton(Html.fromHtml("<font color='#ff4081'>Ok</font>"), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int arg1) {

            }
        });

        if (id == R.id.action_settings) {
            builder.create();
            builder.show();
        }
        return super.onOptionsItemSelected(item);
    }
}