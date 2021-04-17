package tads.ufrn.pdm.sensores

data class SensorData(var x:Float, var y:Float, var z:Float, var timestamp:Long) {
    constructor(x:Float, timestamp:Long):this(x,0.0f,0.0f,timestamp){}
}