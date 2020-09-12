package alejandro.br.menu.Models.Pokos


data class MenuItem(var id: String, var name: String, var price: Double, var photo: String, var  details: String, var category : String){

    constructor( name : String, price: Double, photo: String , details: String, category: String) :  this("", name, price, category, photo, details){
    }
    constructor(id: String, name : String, price: Double, category: String) :  this(id, name, price, category, "No photo", "No deatils"){
    }
    constructor(id:String , name: String, price: Double) : this (id,  name, price,"","",""){
    }
    constructor( name: String, price: Double) : this ("",  name, price,"","",""){
    }
    constructor() : this("", "",0.0, "","","") {
    }



    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + price.hashCode()
        result = 31 * result + category.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MenuItem

        if (name != other.name) return false

        return true
    }


}
