package com.sibi.loginapp.model


import android.os.Parcelable
import android.provider.CallLog
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    @SerializedName("category_name")
    val category_name: String,
    @SerializedName("category_id")
    val category_id:String,
    @SerializedName("description")
    val description: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("price_per_quantity")
    val pricePerQuantity: Int,
    @SerializedName("seller_name")
    val sellerName: String
) : Parcelable,ListData {
    override fun title(): String {
        return this.name
    }

    companion object {
        val CALLBACK = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return true
            }

        }
    }
}