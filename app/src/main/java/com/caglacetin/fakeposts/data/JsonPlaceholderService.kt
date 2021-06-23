package com.caglacetin.fakeposts.data

import com.caglacetin.fakeposts.data.response.Post
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface JsonPlaceholderService {

  @GET("posts/")
  fun fetchPosts(): Observable<Post>

}