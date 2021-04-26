package tads.ufrn.pdm.segundaprova.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Comida2(
    @SerializedName("id")
    var id:Int,
    @SerializedName("nomeComida")
    var nomeComida:String,
    @SerializedName("descricao")
    var descricao:String,
    @SerializedName("criador")
    var criador:String,
    @SerializedName("restaurante")
    var restaurante:String,
    @SerializedName("regiao")
    var regiao:String,
    @SerializedName("avaliacao")
    var avaliacao:Float
)