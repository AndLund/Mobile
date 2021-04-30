package tads.ufrn.pdm.segundaprova.api

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import tads.ufrn.pdm.segundaprova.model.Comida2

interface Endpoint {
    @GET("comidas")
    fun getPosts() : Call<List<Comida2>>
}