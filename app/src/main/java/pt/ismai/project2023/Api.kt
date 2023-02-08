package pt.ismai.project2023

//retrofit para trabalhar com as propriedades/funções de rede
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("movie/popular") //endpoint da onde vamos buscar os dados
    fun getPopularMovies(
        @Query("api_key") apiKey: String = "ec10e1412bdcc8e39d22968372ac8f5c",
        @Query("page") page: Int
    ): Call<GetMovieResponse>  //envia a o pedido e retorna uma resposta

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "ec10e1412bdcc8e39d22968372ac8f5c",
        @Query("page") page: Int
    ): Call<GetMovieResponse>

}