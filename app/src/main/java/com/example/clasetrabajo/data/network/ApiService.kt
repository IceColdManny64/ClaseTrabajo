    package com.example.clasetrabajo.data.network

    import com.example.clasetrabajo.data.model.UserModel
    import retrofit2.http.POST
    import com.google.gson.JsonObject
    import retrofit2.Response
    import retrofit2.http.Body

    interface ApiService {
        @POST("user")
        suspend fun login(@Body username: UserModel):Response<JsonObject>
    }