package olyarisu.github.com.cocktailapp.presentation.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import olyarisu.github.com.cocktailapp.domain.entities.Cocktail
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_cocktail.view.*
import olyarisu.github.com.cocktailapp.R


class CocktailsAdapter(
    private var listCocktails: ArrayList<Cocktail>,
    private val context: Context,
    private val onItemClick: ((Cocktail) -> Unit)? = null
) : RecyclerView.Adapter<CocktailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        return CocktailViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_cocktail,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: CocktailViewHolder, position: Int) {
        viewHolder.apply {
            titleCocktail.text = listCocktails[position].name
            Glide.with(context)
                .load(listCocktails[position].photoURL)
                .into(imageCocktail)
            itemView.setOnClickListener { onItemClick?.invoke(listCocktails[position]) }
        }
    }

    override fun getItemCount(): Int = listCocktails.size

    fun replace(newListCocktails: List<Cocktail>) {
        listCocktails.clear()
        listCocktails.addAll(newListCocktails)
        notifyDataSetChanged()
    }
}

class CocktailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageCocktail: ImageView = itemView.image_cocktail
    val titleCocktail: TextView = itemView.title_cocktail
}