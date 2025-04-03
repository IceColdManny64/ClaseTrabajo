    package com.example.clasetrabajo.data.network

    import com.example.clasetrabajo.data.model.AccountModel
    import com.example.clasetrabajo.data.model.UserModel
    import retrofit2.http.POST
    import com.google.gson.JsonObject
    import retrofit2.Response
    import retrofit2.http.Body
    import retrofit2.http.GET
    import retrofit2.http.Path

    //endpoints
    interface ApiService {

        //json object
        @POST("user")
        suspend fun login(@Body username: UserModel):Response<JsonObject>

        //account list
        @GET("service")
        suspend fun getAccounts():Response<List<AccountModel>>

        //only one element (id)
        @GET("service/{id}")
        suspend fun getAccount(@Path("id") id: Int): Response<AccountModel>
    }