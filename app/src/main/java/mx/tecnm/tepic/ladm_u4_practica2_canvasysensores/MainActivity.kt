package mx.tecnm.tepic.ladm_u4_practica2_canvasysensores

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var sensorManager: SensorManager
    lateinit var lienzo: Lienzo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lienzo = Lienzo(this)
        lienzo.fondo = Color.BLUE
        setContentView(lienzo)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)

        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int){

    }

    override fun onSensorChanged(event: SensorEvent){
        when(event.sensor.type){
            Sensor.TYPE_ACCELEROMETER ->{
                if(event.values[2] < 1){
                    lienzo.posX = lienzo.posX-6
                }else{
                    lienzo.posX = lienzo.posX+6
                }
            }
            Sensor.TYPE_PROXIMITY ->{
                if(event.values[0] <= 1f){
                    lienzo.carro = BitmapFactory.decodeResource(this.resources, R.drawable.moto)
                }else{
                    lienzo.carro = BitmapFactory.decodeResource(this.resources, R.drawable.carro)
                }
            }
        }
        lienzo.postInvalidate()
    }
}