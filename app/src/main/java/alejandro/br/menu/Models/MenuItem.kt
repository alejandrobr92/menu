package alejandro.br.menu.Models


data class MenuItem(var name: String, var price: Double, var photo: String, var  details: String, var category : String){

    constructor(name : String, price: Double, category: String) :  this(name, price, category, "No photo", "No deatils"){
    }
    constructor() : this("",0.0, "","","") {
    }
    constructor(name: String, price: Double) : this (name, price,"","",""){
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MenuItem

        if (name != other.name) return false
        if (price != other.price) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + category.hashCode()
        return result
    }


}
