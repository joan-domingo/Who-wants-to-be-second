package cat.xojan.random2

import android.os.Parcel
import android.os.Parcelable


class Country(val title: String, val videoId: String): Parcelable {

    constructor(source: Parcel): this(source.readString(), source.readString())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeString(this.title)
        dest?.writeString(this.videoId)
    }

    companion object {
        @JvmField final val CREATOR: Parcelable.Creator<Country> = object:
                Parcelable.Creator<Country> {
            override fun createFromParcel(source: Parcel): Country{
                return Country(source)
            }

            override fun newArray(size: Int): Array<Country?> {
                return arrayOfNulls(size)
            }
        }
    }
}