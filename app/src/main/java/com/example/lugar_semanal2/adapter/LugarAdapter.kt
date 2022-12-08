package com.example.lugar_semanal2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lugar_semanal2.databinding.ActivityMainBinding.inflate
import com.example.lugar_semanal2.databinding.FragmentAddLugarBinding
import com.example.lugar_semanal2.databinding.LugarFilaBinding
import com.example.lugar_semanal2.model.Lugar

class LugarAdapter: RecyclerView.Adapter<LugarAdapter.LugarViewHolder>() {

    //la lista de lugares dibujar
    private var listaLugares = emptyList<Lugar>()
//contenedor de vistas"cajitas" en memoria
    inner class LugarViewHolder(private val itemBinding: LugarFilaBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
          fun dibuja(lugar: Lugar){
              itemBinding.tvNombre.text = lugar.nombre
              itemBinding.tvTelefono.text = lugar.telefono
              itemBinding.tvCorreo.text = lugar.correo
          }

        }
//crea un cajita una vista del tipo lugarFila...

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val itemBinding = LugarFilaBinding.inflate(LayoutInflater.from(parent.context),
        parent
        ,false)
        return LugarViewHolder(itemBinding)
    }
// con una cajita creada... se pasa a dibujar los datos del lugar
    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugarActual = listaLugares[position]
    holder.dibuja(lugarActual)
    }

    override fun getItemCount(): Int {
        return  listaLugares.size
    }
fun setLugares(lugares : List<Lugar>) {
    listaLugares = lugares
      notifyDataSetChanged()
    //se notifica queel conjunto de datos cambio y se sedibuja toda la
}
}