package com.votenoid.messsanger

import android.os.Parcel
import android.os.Parcelable

class User (username:String,user_type:Int,isOnline:Boolean):Parcelable {

    constructor(parcel: Parcel) : this(
        TODO("username"),
        TODO("user_type"),
        TODO("isOnline")
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}