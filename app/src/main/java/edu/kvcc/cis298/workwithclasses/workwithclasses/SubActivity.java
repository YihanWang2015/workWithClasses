package edu.kvcc.cis298.workwithclasses.workwithclasses;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {


    public static final String THE_SUB_KEY = "the_sub_key";
    public static final String BEEN_THERE = "been_there";

    private TextView mMessage;

    private boolean mBeenThereDoneThat;





    //P99 Intent here is the return type
    public static Intent newIntent(Context packageContext, String theMessage){
       //overload is allowed eg passing two string
        Intent i = new Intent(packageContext, SubActivity.class);

        i.putExtra(THE_SUB_KEY, theMessage);
        return i;

    }

//=======================================================

    public static boolean userWentToSubActivity(Intent result){
        return result.getBooleanExtra(BEEN_THERE, false);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //passing the THE_SUB_KEY
        mMessage = (TextView)findViewById(R.id.message);

        //P100
        String theMessageString = getIntent().getStringExtra(THE_SUB_KEY);

        mMessage.setText(theMessageString);

//==================================================================================


        //return the data  P103
        mBeenThereDoneThat = true;

        Intent data = new Intent();

        data.putExtra(BEEN_THERE, mBeenThereDoneThat);

        //this.setResult(RESULT_OK, data);
        setResult(RESULT_OK, data);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sub, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
