package cl.awakelab.sprintfinalm6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/*
App listado, detalle y correo de celulares Sprint Final
[x] Manifest: activar permisos de internet, android:usesCleartextTraffic="true" y android:enableOnBackInvokedCallback="true"
[x] Gradle: activar viewBinding | Plugin: kotlin-kapt | Dependencias: Coil, Room, RetroFit, navigation, viewModel | API mínima 25 y target 33 |
   pasar a version 17 en CompileOptions y KotlinOptions
[x] Se creó la estructura de paquetes: data(local y remote) y view(correspondiente a la presentación)
[] Se creó la branch funcionalidad/consumo_remoto
[] Remoto:
    [] DataClass
    [] API (interfaz)
    [] RetroFit
[] Local:
    [] DataBase
    [] Entity
    [] Dao
[] 2 pantallas: Listado y Detalle
[] Navigation
[] Listado: RecyclerView + ViewHolder + Adapter
[] Detalle: RecyclerView + ViewHolder + Adapter

 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}