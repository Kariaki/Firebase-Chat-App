package com.votenoid.messsanger.Database.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Contact(
    @PrimaryKey
    var contactId:String,
    var phoneNumber:String,
    var contactName:String
)
