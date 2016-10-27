package com.example.isort2.isort2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void clickExit(View v){
        finish();
    }
    public void reset(View v){
        EditText edtxt=(EditText)findViewById(R.id.editText);
        TextView txtv2=(TextView)findViewById(R.id.textView2);
        TextView txtv3=(TextView)findViewById(R.id.textView3);
        edtxt.setText("");
        txtv2.setText("");
        txtv3.setText("");
        Button btnres=(Button)findViewById(R.id.button3);
    }
    public void btnClickMe(View v) {
        Button button;
        button=(Button)findViewById(R.id.button);
        EditText et = (EditText) findViewById(R.id.editText);
        TextView tv = (TextView) findViewById(R.id.textView3);
        insertionSort();
    }
    public void insertionSort() {
        EditText et = (EditText) findViewById(R.id.editText);
        String text = et.getText().toString();
        String txt1 = text.replaceAll(",", " ");
        String txt = txt1.replaceAll(" ", "");
        if (txt.length() > 8) {
            Toast.makeText(getApplicationContext(), "Enter maximum 8 digits", Toast.LENGTH_SHORT).show();
        } else {
            if (txt.length() < 2) {
                Toast.makeText(getApplicationContext(), "Enter minimum 2 digits", Toast.LENGTH_SHORT).show();
            } else {
                TextView tv = (TextView) findViewById(R.id.textView2);
                int[] array = new int[txt.length()];
                for (int i = 0; i < txt.length(); i++) {
                    array[i] = Character.getNumericValue(txt.charAt(i));
                }
                tv.setText("Insertion Sort (Intermediate Steps):" + "\n");
                for (int j = 1; j < array.length; j++) {
                    int key = array[j];
                    int i = j - 1;
                    while ((i > -1) && (array[i] > key)) {
                        array[i + 1] = array[i];
                        i--;
                    }
                    array[i + 1] = key;
                    tv.append(Arrays.toString(array).replaceAll(",", "") + "\n");
                    TextView tv2 = (TextView) findViewById(R.id.textView3);
                    tv2.setText("Input Array : " + txt1);
                }
            }
        }
    }
}
