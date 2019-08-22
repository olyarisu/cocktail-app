package olyarisu.github.com.cocktailapp.domain.entities

data class Cocktail(
        val id: Int,
        val name: String,
        val instruction: String?,
        val ingredients: List<Ingredient>?,
        val category: String? = null,
        val alcoholic: String? = null,
        val glass: String? = null,
        val photoURL: String? = null
)