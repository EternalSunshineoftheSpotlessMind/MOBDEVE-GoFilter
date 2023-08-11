package com.example.gofilter.data

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class PostViewModel: ViewModel() {
    val response: MutableState<PostState> = mutableStateOf(PostState.Empty)

    init {
        fetchDataFromFirebase()
    }

    private fun fetchDataFromFirebase() {
        val tempList = mutableListOf<Post>()
        response.value = PostState.Loading
        FirebaseDatabase.getInstance().getReference("")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (DataSnap in snapshot.children) {
                        val postItem = DataSnap.getValue(Post::class.java)
                        if (postItem != null)
                            tempList.add(postItem)
                    }
                    response.value = PostState.Success(tempList)
                }

                override fun onCancelled(error: DatabaseError) {
                    response.value = PostState.Failure(error.message)
                }

            })
    }
}