package com.example.gofilter.data

sealed class PostState {
    class Success(val data: MutableList<Post>) : PostState()
    class Failure(val message: String) : PostState()
    object Loading : PostState()
    object Empty : PostState()
}
