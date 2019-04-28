package edu.illinois.cs.cs125.spring2019.lab12;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * vMain class for our UI design lab.
 */
public class MainActivity extends AppCompatActivity {
    /**.
     * .
     */
    private float acelVal;
    /**.
     * .
     */
    private float acelLast;
    /**
     * .
     */
    private float shake;
    /**.
     * .
     */
    private SensorManager sm;
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
    private float num1, num2;
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
                if (num2 == 0) {
                    result.setText(String.valueOf("UNDEFINED"));
                } else {
                    resultNum = num1 / num2;
                    result.setText(String.valueOf(resultNum));
                }

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
    /**
     * .
     * @param event .
     * @return .
     */
    @Override
    public boolean dispatchKeyEvent(final KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    resultNum++;
                    result.setText(String.valueOf(resultNum));
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    resultNum--;
                    result.setText(String.valueOf(resultNum));
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    /**
     * .
     * @param savedInstanceState .
     */
    protected void onClick(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

    }

    /**
     * .
     */
    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(final SensorEvent sensorEvent) {

            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];

            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = acelVal - acelLast;
            shake = shake * 1.0f + delta;
            if (shake > 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1) {
                resultNum = resultNum * resultNum;
                result.setText(String.valueOf(resultNum));
            }



        }

        @Override
        public void onAccuracyChanged(final Sensor sensor, final int accuracy) {

        }
    };

}
