package alejandro.br.menu.Models.Pokos

data class PedidoItem(var id:String, var name: String, var price: Double, var quantity: Int, var state: String){
    constructor() : this ("", "", 0.0, 0, "")

}