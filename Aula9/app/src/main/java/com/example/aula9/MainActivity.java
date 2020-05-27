package com.example.aula9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView a,b,c,d,e,f,g,h,i;
    SensorManager snm;
    Sensor sensor;
    LinearLayout box;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.a1);
        b = findViewById(R.id.a2);
        c = findViewById(R.id.a3);
        d = findViewById(R.id.a4);
        e = findViewById(R.id.a5);
        f = findViewById(R.id.a6);
        g = findViewById(R.id.a7);
        h = findViewById(R.id.a8);
        i = findViewById(R.id.a9);
        box=findViewById(R.id.box);

        snm = (SensorManager) getSystemService(SENSOR_SERVICE);
        snm.registerListener(this,snm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        snm.registerListener(this,snm.getDefaultSensor(Sensor.TYPE_PROXIMITY),SensorManager.SENSOR_DELAY_NORMAL);
        snm.registerListener(this,snm.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_NORMAL);
        snm.registerListener(this,snm.getDefaultSensor(Sensor.TYPE_PRESSURE),SensorManager.SENSOR_DELAY_NORMAL);
        snm.registerListener(this,snm.getDefaultSensor(Sensor.TYPE_ORIENTATION),SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            a.setText("accel x = " + sensorEvent.values[0]);
            b.setText("accel y = " + sensorEvent.values[1]);
            c.setText("accel z = " + sensorEvent.values[2]);
        } else if (sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            d.setText("proximity = " + sensorEvent.values[0]);

        } else if (sensorEvent.sensor.getType() == Sensor.TYPE_LIGHT) {
            e.setText("light = " + sensorEvent.values[0]);

        } else if (sensorEvent.sensor.getType() == Sensor.TYPE_PRESSURE) {
            f.setText("pressure = " + sensorEvent.values[0]);

        } else if (sensorEvent.sensor.getType() == Sensor.TYPE_ORIENTATION) {
            g.setText("orient x = " + sensorEvent.values[0]);
            h.setText("orient y = " + sensorEvent.values[1]);
            i.setText("orient z = " + sensorEvent.values[2]);

            float x = sensorEvent.values[0];
            float z = sensorEvent.values[2];

            if ((z > 1.2 && z < 1.8) || (z < -1.2 && z > -1.8)) {
                box.setBackgroundColor(Color.GREEN);
            }
            if ((z > -0.8 && z < 0.2) || (z < -2.84 && z > -3.44)) {
                box.setBackgroundColor(Color.BLUE);
            }
            if (x > 1.27 && x < 1.87) {
                finish();
            }
            if (x < -1.27 && x > -1.87) {
                box.setBackgroundColor(Color.RED);

            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onStop(){
        super.onStop();
        snm.unregisterListener(this);
    }

    public void gpsClick(View view) {
        startActivity(new Intent(this,Aula9GpsActivity.class));
    }
}

