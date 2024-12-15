package com.example.roomdatabase.ui.navigation

interface AlamatNavigasi {
    val route : String
}
object DestinsiHome : AlamatNavigasi{
    override val route: String = "Home"
}

object DestinasiDetail : AlamatNavigasi{
    override val route ="detail"
    const val NIM = "nim"
    val routesWithArg = "$route/{$NIM}"
}

object DestinasiUpdate : AlamatNavigasi {
    override val route = "update"
    const val NIM = "nim"
    val routesWithArg = "$route/{$NIM}"
}