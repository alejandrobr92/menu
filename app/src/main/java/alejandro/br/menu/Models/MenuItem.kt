package alejandro.br.menu.Models


data class MenuItem(var name: String, var price: Double, var photo: String, var  details: String, var category : String){
    constructor(name : String, price: Double, category: String) :  this(name, price, category, "No photo", "No deatils"){
    }
    constructor() : this("",0.0, "","",""){

    }



}
