package com.votenoid.messsanger.Database.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class user(
    @PrimaryKey
    var userId: String,
    var about_user: String,
    val username: String,
    var phoneNumber: String,
    var profileUrl: String

)
