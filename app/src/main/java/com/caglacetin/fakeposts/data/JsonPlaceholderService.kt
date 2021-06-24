package com.caglacetin.fakeposts.data

import com.caglacetin.fakeposts.data.response.PostResponse
import com.caglacetin.fakeposts.data.response.UserResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderService {

  @GET("posts/")
  fun fetchPosts(): Observable<List<PostResponse>>

  @GET("posts/{postId}")
  fun getPostDetail(@Path("postId") postId: Int): Observable<PostResponse>

  @GET("users/{userId}")
  fun getAUser(@Path("userId") userId: Int): Observable<UserResponse>

}