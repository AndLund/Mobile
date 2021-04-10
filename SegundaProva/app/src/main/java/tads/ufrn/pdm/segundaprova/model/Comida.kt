package tads.ufrn.pdm.segundaprova.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tabela_comida")
data class Comida(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo var nomeComida:String,
    @ColumnInfo var descricao:String,
    @ColumnInfo var criador:String,
    @ColumnInfo var restaurante:String,
    @ColumnInfo var regiao:String,
    @ColumnInfo var avaliacao:Float
){

}