package com.caglacetin.fakeposts.data

import com.caglacetin.fakeposts.data.response.PostResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface JsonPlaceholderService {

  @GET("posts/")
  fun fetchPosts(): Observable<List<PostResponse>>

}