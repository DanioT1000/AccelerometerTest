package com.example.accelerometertest;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

	Sensor accelerometer;
	SensorManager sm;
	TextView accereleration;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        accelerometer=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        accereleration = (TextView)findViewById(R.id.acceleration);
    }


	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		accereleration.setText("X: "+event.values[0]+
				"\nY: "+event.values[1]+
				"\nZ: "+event.values[2]);
	}


	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
}
