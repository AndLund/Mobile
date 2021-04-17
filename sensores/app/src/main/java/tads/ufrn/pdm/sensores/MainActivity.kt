package tads.ufrn.pdm.sensores

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import tads.ufrn.pdm.sensores.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

private lateinit var sensorManager:SensorManager
private lateinit var sensorProximidade:Sensor
private lateinit var sensorLuz:Sensor
private lateinit var sensorAcelerometro:Sensor
private lateinit var sensorGiroscopio:Sensor

private var acelerometroData:SensorData? = null
private var giroscopioData:SensorData? = null
private var proximidadeData:SensorData? = null
private var luzData:SensorData? = null

class MainActivity : AppCompatActivity(),SensorEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        initSensor()
    }

    private fun initSensor(){
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        if(sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) != null){
            sensorAcelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null){
            sensorLuz = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null){
            sensorProximidade = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null){
            sensorGiroscopio = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
        }

        binding.iniciarBT.setOnClickListener {
            registerListener()
            binding.iniciarBT.isEnabled = false
            binding.pararBT.isEnabled = true
        }
        binding.pararBT.setOnClickListener {
            unregisterListener()
            binding.iniciarBT.isEnabled = true
            binding.pararBT.isEnabled = false
        }
    }

    private fun registerListener(){
        if(sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION) != null){
            sensorManager.registerListener(this, sensorAcelerometro,SensorManager.SENSOR_DELAY_FASTEST)
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null){
            sensorManager.registerListener(this, sensorLuz,SensorManager.SENSOR_DELAY_FASTEST)
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) != null){
            sensorManager.registerListener(this, sensorProximidade,SensorManager.SENSOR_DELAY_FASTEST)
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null){
            sensorManager.registerListener(this, sensorGiroscopio,SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    private fun unregisterListener(){
        sensorManager.unregisterListener(this, sensorAcelerometro)
        sensorManager.unregisterListener(this, sensorGiroscopio)
        sensorManager.unregisterListener(this, sensorProximidade)
        sensorManager.unregisterListener(this, sensorLuz)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(event!!.sensor.type == Sensor.TYPE_LINEAR_ACCELERATION){
            getAcelerometro(event)
        } else if(event.sensor.type == Sensor.TYPE_LIGHT){
            getLuz(event)
        } else if(event.sensor.type == Sensor.TYPE_PROXIMITY){
            getProximidade(event)
        } else if(event.sensor.type == Sensor.TYPE_GYROSCOPE){
            getGiroscopio(event)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    private fun getAcelerometro(e:SensorEvent?){
        if(acelerometroData == null){
            acelerometroData = SensorData(e!!.values[0],e.values[1],e.values[2],e.timestamp)
        } else {
            acelerometroData!!.x = e!!.values[0]
            acelerometroData!!.y = e.values[1]
            acelerometroData!!.z = e.values[2]
        }

        binding.xacelerometroTV.text = "x: ${"%.2f".format(acelerometroData!!.x)} m/s^2"
        binding.yacelerometroTV.text = "y: ${"%.2f".format(acelerometroData!!.y)} m/s^2"
        binding.zacelerometroTV.text = "z: ${"%.2f".format(acelerometroData!!.z)} m/s^2"
    }

    private fun getGiroscopio(e:SensorEvent?){
        if(giroscopioData == null){
            giroscopioData = SensorData(e!!.values[0],e.values[1],e.values[2],e.timestamp)
        } else {
            giroscopioData!!.x = e!!.values[0]
            giroscopioData!!.y = e.values[1]
            giroscopioData!!.z = e.values[2]
        }

        binding.xgiroscopioTV.text = "x: ${"%.2f".format(giroscopioData!!.x)} /s"
        binding.ygiroscopioTV.text = "y: ${"%.2f".format(giroscopioData!!.y)} /s"
        binding.zgiroscopioTV.text = "z: ${"%.2f".format(giroscopioData!!.z)} /s"
    }

    private fun getLuz(e:SensorEvent?){
        if(luzData == null){
            luzData = SensorData(e!!.values[0],e.timestamp)
        } else {
            luzData!!.x = e!!.values[0]
        }

        binding.luzTV.text = "Int: ${"%.2f".format(luzData!!.x)} lux"
    }

    private fun getProximidade(e:SensorEvent?){
        if(proximidadeData == null){
            proximidadeData = SensorData(e!!.values[0],e.timestamp)
        } else {
            proximidadeData!!.x = e!!.values[0]
        }

        binding.proximidadeTV.text = "dist.: ${"%.2f".format(proximidadeData!!.x)} cm"
    }

}