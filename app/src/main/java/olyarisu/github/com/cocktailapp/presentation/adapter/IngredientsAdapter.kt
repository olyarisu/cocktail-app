package olyarisu.github.com.cocktailapp.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_ingredient.view.*
import olyarisu.github.com.cocktailapp.R
import olyarisu.github.com.cocktailapp.domain.entities.Ingredient

class IngredientsAdapter(
    private var listIngredients: List<Ingredient>?,
    private val context: Context
) : RecyclerView.Adapter<IngredientViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        return IngredientViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_ingredient,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: IngredientViewHolder, position: Int) {
        viewHolder.apply {
            measureIngredient.text = listIngredients?.get(position)?.measure
            listIngredients?.get(position)?.name.let {
                titleIngredient.text = it
                Glide.with(context)
                    .load(
                        PHOTO_INGREDIENT_BASE_URL
                                + it
                                + PHOTO_INGREDIENT_END_URL
                    )
                    .into(photoIngredient)
            }
        }
    }

    override fun getItemCount(): Int = listIngredients?.size ?: 0
}

class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleIngredient: TextView = itemView.ingredient_name
    val measureIngredient: TextView = itemView.ingredient_measure
    val photoIngredient: ImageView = itemView.ingredient_photo
}

private const val PHOTO_INGREDIENT_BASE_URL = "https://www.thecocktaildb.com/images/ingredients/"
private const val PHOTO_INGREDIENT_END_URL = "-Small.png"