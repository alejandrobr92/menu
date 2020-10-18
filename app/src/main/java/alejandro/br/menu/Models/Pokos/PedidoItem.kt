package alejandro.br.menu.Models.Pokos

data class PedidoItem(var id:String, var name: String, var price: Double, var quantity: Long, var state: String){
    constructor() : this ("", "", 0.0, 0, "")
    constructor(name: String, price: Double, quantity: Long, state: String): this("", name, price, quantity, state)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PedidoItem

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "PedidoItem(id='$id', name='$name', price=$price, quantity=$quantity, state='$state')"
    }

}