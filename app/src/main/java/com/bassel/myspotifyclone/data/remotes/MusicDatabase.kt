package com.bassel.myspotifyclone.data.remotes

import com.bassel.myspotifyclone.data.entities.Song
import com.bassel.myspotifyclone.util.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlin.Exception


class MusicDatabase {
    private val firestore =FirebaseFirestore.getInstance()

    private val  songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs() : List<Song>{
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e : Exception){
            emptyList()

        }
    }
}