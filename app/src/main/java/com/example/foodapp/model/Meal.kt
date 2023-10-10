package com.example.foodapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity("MealRoom")
data class Meal(
     @SerializedName("dateModified")
      @Expose
   @ColumnInfo("dateModified")  val dateModified: Any?,
     @SerializedName("idMeal")
     @Expose
     @PrimaryKey
   @ColumnInfo("idMeal")  @NotNull val idMeal: String,
     @SerializedName("strArea")
     @Expose
    @ColumnInfo("strArea") val strArea: String?,
     @SerializedName("strCategory")
     @Expose
     @ColumnInfo("strCategory") val strCategory: String?,
     @SerializedName("strCreativeCommonsConfirmed")
     @Expose
     @ColumnInfo("strCreativeCommonsConfirmed")  val strCreativeCommonsConfirmed: Any?,
     @SerializedName("strDrinkAlternate")
     @Expose
     @ColumnInfo("strDrinkAlternate") val strDrinkAlternate: Any?,
     @SerializedName("strImageSource")
     @Expose
     @ColumnInfo("strImageSource")  val strImageSource: Any?,
     @SerializedName("strIngredient1")
     @Expose
     @ColumnInfo("strIngredient1")val strIngredient1: String?,
     @SerializedName("strIngredient10")
     @Expose
     @ColumnInfo("strIngredient10") val strIngredient10: String?,
     @SerializedName("strIngredient11")
     @Expose
     @ColumnInfo("strIngredient11") val strIngredient11: String?,
     @SerializedName("strIngredient12")
     @Expose
     @ColumnInfo("strIngredient12") val strIngredient12: String?,
     @SerializedName("strIngredient13")
     @Expose
     @ColumnInfo("strIngredient13") val strIngredient13: String?,
     @SerializedName("strIngredient14")
     @Expose
     @ColumnInfo("strIngredient14") val strIngredient14: String?,
     @SerializedName("strIngredient15")
     @Expose
     @ColumnInfo("strIngredient15") val strIngredient15: String?,
     @SerializedName("strIngredient16")
     @Expose
     @ColumnInfo("strIngredient16")  val strIngredient16: String?,
     @SerializedName("strIngredient17")
     @Expose
     @ColumnInfo("strIngredient17")  val strIngredient17: String?,
     @SerializedName("strIngredient18")
     @Expose
     @ColumnInfo("strIngredient18")  val strIngredient18: String?,
     @SerializedName("strIngredient19")
     @Expose
     @ColumnInfo("strIngredient19")  val strIngredient19: String?,
     @SerializedName("strIngredient2")
     @Expose
     @ColumnInfo("strIngredient2")  val strIngredient2: String?,
     @SerializedName("strIngredient20")
     @Expose
     @ColumnInfo("strIngredient20") val strIngredient20: String?,
     @SerializedName("strIngredient3")
     @Expose
     @ColumnInfo("strIngredient3") val strIngredient3: String?,
     @SerializedName("strIngredient4")
     @Expose
     @ColumnInfo("strIngredient4") val strIngredient4: String?,
     @SerializedName("strIngredient5")
     @Expose
     @ColumnInfo("strIngredient5") val strIngredient5: String?,
     @SerializedName("strIngredient6")
     @Expose
     @ColumnInfo("strIngredient6") val strIngredient6: String?,
     @SerializedName("strIngredient7")
     @Expose
     @ColumnInfo("strIngredient7") val strIngredient7: String?,
     @SerializedName("strIngredient8")
     @Expose
     @ColumnInfo("strIngredient8")  val strIngredient8: String?,
     @SerializedName("strIngredient9")
     @Expose
     @ColumnInfo("strIngredient9") val strIngredient9: String?,
     @SerializedName("strInstructions")
     @Expose
     @ColumnInfo("strInstructions") val strInstructions: String?,
     @SerializedName("strMeal")
     @Expose
     @ColumnInfo("strMeal") val strMeal: String?,
     @SerializedName("strMealThumb")
     @Expose
     @ColumnInfo("strMealThumb")  val strMealThumb: String?,
     @SerializedName("strMeasure1")
     @Expose
     @ColumnInfo("strMeasure1")  val strMeasure1: String?,
     @SerializedName("strMeasure10")
     @Expose
     @ColumnInfo("strMeasure10") val strMeasure10: String?,
     @SerializedName("strMeasure11")
     @Expose
     @ColumnInfo("strMeasure11") val strMeasure11: String?,
     @SerializedName("strMeasure12")
     @Expose
     @ColumnInfo("strMeasure12") val strMeasure12: String?,
     @SerializedName("strMeasure13")
     @Expose
     @ColumnInfo("strMeasure13") val strMeasure13: String?,
     @SerializedName("strMeasure14")
     @Expose
     @ColumnInfo("strMeasure14") val strMeasure14: String?,
     @SerializedName("strMeasure15")
     @Expose
     @ColumnInfo("strMeasure15") val strMeasure15: String?,
     @SerializedName("strMeasure16")
     @Expose
     @ColumnInfo("strMeasure16")  val strMeasure16: String?,
     @SerializedName("strMeasure17")
     @Expose
     @ColumnInfo("strMeasure17")  val strMeasure17: String?,
     @SerializedName("strMeasure18")
     @Expose
     @ColumnInfo("strMeasure18") val strMeasure18: String?,
     @SerializedName("strMeasure19")
     @Expose
     @ColumnInfo("strMeasure19") val strMeasure19: String?,
     @SerializedName("strMeasure2")
     @Expose
     @ColumnInfo("strMeasure2")  val strMeasure2: String?,
     @SerializedName("strMeasure20")
     @Expose
     @ColumnInfo("strMeasure20")  val strMeasure20: String?,
     @SerializedName("strMeasure3")
     @Expose
     @ColumnInfo("strMeasure3") val strMeasure3: String?,
     @SerializedName("strMeasure4")
     @Expose
     @ColumnInfo("strMeasure4")  val strMeasure4: String?,
     @SerializedName("strMeasure5")
     @Expose
     @ColumnInfo("strMeasure5") val strMeasure5: String?,
     @SerializedName("strMeasure6")
     @Expose
     @ColumnInfo("strMeasure6") val strMeasure6: String?,
     @SerializedName("strMeasure7")
     @Expose
     @ColumnInfo("strMeasure7") val strMeasure7: String?,
     @SerializedName("strMeasure8")
     @Expose
     @ColumnInfo("strMeasure8")  val strMeasure8: String?,
     @SerializedName("strMeasure9")
     @Expose
     @ColumnInfo("strMeasure9") val strMeasure9: String?,
     @SerializedName("strSource")
     @Expose
     @ColumnInfo("strSource")  val strSource: String?,
     @SerializedName("strTags")
     @Expose
     @ColumnInfo("strTags") val strTags: String?,
     @SerializedName("strYoutube")
     @Expose
     @ColumnInfo("strYoutube") val strYoutube: String?
)