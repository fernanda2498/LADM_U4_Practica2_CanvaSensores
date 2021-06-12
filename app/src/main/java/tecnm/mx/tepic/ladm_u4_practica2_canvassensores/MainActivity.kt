package tecnm.mx.tepic.ladm_u4_practica2_canvassensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() ,SensorEventListener{

    lateinit var lienzo:Lienzo
    lateinit var sensorManager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo = Lienzo(this)
        setContentView(lienzo)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        //SENSOR ACELEROMETRO
        sensorManager.registerListener(

                this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL

        )

        //SENSOR DE PROXIMIDAD
        sensorManager.registerListener(

                this,
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManager.SENSOR_DELAY_GAME

        )
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent) {
        if (event.sensor.type == Sensor.TYPE_ACCELEROMETER){

            var coordX = event.values[0]
            var coordY = event.values[1]

            lienzo.cx = lienzo.cx + (-coordX)
            lienzo.cy = lienzo.cy + coordY

        }

        if (event.sensor.type == Sensor.TYPE_PROXIMITY){

            lienzo.fondo = event.values[0] != 0F

        }

        lienzo.invalidate()
    }
}