package alejandro.br.menu.Models


data class MenuItem(var name: String, var price: Double, var photo: String, var  details: String){
    constructor(name : String, price: Double) :  this(name, price, "No photo", "No deatils"){
    }
    constructor() : this("",0.0,"",""){

    }



}
