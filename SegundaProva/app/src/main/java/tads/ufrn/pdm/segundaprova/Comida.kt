package tads.ufrn.pdm.segundaprova

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tabela_comida")
data class Comida(
    @PrimaryKey(autoGenerate = true) val id:Int,
    @ColumnInfo val nomeComida:String?,
    @ColumnInfo val descricao:String?,
    @ColumnInfo val criador:String?,
    @ColumnInfo val regiao:String?,
    @ColumnInfo val avaliacao:Float?){

}