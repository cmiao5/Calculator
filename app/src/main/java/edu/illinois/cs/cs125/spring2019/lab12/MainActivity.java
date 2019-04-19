package edu.illinois.cs.cs125.spring2019.lab12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Main class for our UI design lab.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * .
     */
    private TextView result;
    /**
     * .
     */
    private EditText number1, number2;
    /**
     * .
     */
    private Button add, subtract, divide, multiply;
    /**
     * .
     */
    private float resultNum;
    /**
     * .
     */
    private int num1, num2;
    /**
     * .
     * @param savedInstanceState = .
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        add = (Button) findViewById(R.id.add);
        subtract = (Button) findViewById(R.id.minus);
        multiply = (Button) findViewById(R.id.multiply);
        divide = (Button) findViewById(R.id.divide);

        /**
         * .
         */
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * .
             */
            public void onClick(final View v) {

                /**
                 * .
                 */
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                resultNum = num1 + num2;
                result.setText(String.valueOf(resultNum));

            }
        });

        /**
         * .
         */
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * .
             */
            public void onClick(final View v) {

                /**
                 * .
                 */
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                resultNum = num1 + num2;
                result.setText(String.valueOf(resultNum));

            }
        });
        /**
         * .
         */
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * .
             */
            public void onClick(final View v) {

                /**
                 * .
                 */
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                resultNum = num1 - num2;
                result.setText(String.valueOf(resultNum));

            }
        });
        /**
         * .
         */
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * .
             */
            public void onClick(final View v) {

                /**
                 * .
                 */
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                resultNum = num1 / num2;
                result.setText(String.valueOf(resultNum));

            }
        });
        /**
         * .
         */
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * .
             */
            public void onClick(final View v) {

                /**
                 * .
                 */
                num1 = Integer.parseInt(number1.getText().toString());
                num2 = Integer.parseInt(number2.getText().toString());
                resultNum = num1 * num2;
                result.setText(String.valueOf(resultNum));

            }
        });

    }

}
