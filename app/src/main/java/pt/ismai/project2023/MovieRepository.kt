package pt.ismai.project2023

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//repositorio - permite a aplicação conectar com diferentes fontes de dados, esses dados depois serão enviados para o ficheiro main.

//Singleton - tem apenas uma instancia e prove um ponto global de acesso
object MovieRepository {
    private val api: Api

    init { //init block - chamada quando a instancia é inicializada
        val retrofit = Retrofit.Builder() //instancia o retrofit
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)  //instancia a API usando o retrofit
    }

    fun getPopularMovies(
            page: Int = 1,
            onSuccess: (movies: List<Movie>) -> Unit,
            onError: ()-> Unit
    ){
        api.getPopularMovies(page = page)
            .enqueue(object : Callback<GetMovieResponse> {
                override fun onResponse(
                    call: Call<GetMovieResponse>,
                    response: Response<GetMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies) //invoke é como executamos "higher-order-function"
                            //Log.d("Repository", "Movies: ${responseBody.movies}")
                        } else {
                            onError.invoke()
                            //Log.d("Repository", "Failed to get response")
                        }
                    } else {
                        onError.invoke()
                    }
                }

                override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getTopRatedMovies(
        page: Int = 1,
        onSuccess: (movies: List<Movie>) -> Unit,
        onError: () -> Unit
    ) {
        api.getTopRatedMovies(page = page)
            .enqueue(object : Callback<GetMovieResponse> {  //.enqueue - assincrono
                override fun onResponse(
                    call: Call<GetMovieResponse>,
                    response: Response<GetMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.movies)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

}

