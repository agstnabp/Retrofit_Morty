package com.example.rickmorty_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RickAdapter(val dataRick: List<ResultsItem>):RecyclerView.Adapter<RickAdapter.MyViewHolder>() {
    //class ini utk mengakses dan mengatur nilai tampilan pada setiap item dalam RecyclerView
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        //menyimpan referensi ke ImageView dengan id
        val imgRick = view.findViewById<ImageView>(R.id.item_image_Rick)
        val nameRick = view.findViewById<TextView>(R.id.item_name_rick)
        val statusRick = view.findViewById<TextView>(R.id.item_status_rick)
        val speciesRick = view.findViewById<TextView>(R.id.item_species_rick)
    }

    //untuk membuat ViewHolder baru untuk setiap item yang akan ditampilkan dalam RecyclerView,
    // dan memastikan bahwa setiap ViewHolder terkait dengan layout dan data yang sesuai.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_char_rick, parent, false)
        return MyViewHolder(view)
    }


    override fun getItemCount(): Int {
        //apakah dataRick tidak null. Jika dataRick tidak null,
        // maka jumlah item yang akan ditampilkan dalam RecyclerView akan sesuai dengan ukuran list dataRick.
        if(dataRick != null){
            return dataRick.size
        }
        return 0
        //Jika dataRick null atau jika ukuran list dataRick adalah 0, maka fungsi ini mengembalikan nilai 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // mengatur teks pada TextView (nameRick/ statusRick/ speciesRick) dalam MyViewHolder
        // dengan value nama dari item yang sesuai, pada posisi tertentu.
        holder.nameRick.text = dataRick?.get(position)?.name
        holder.statusRick.text = dataRick?.get(position)?.status
        holder.speciesRick.text = dataRick?.get(position)?.species

        //untuk load image dari url api
        Glide.with(holder.imgRick)
            .load(dataRick?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgRick)

        // jika item diklik akan menampilkan pesan berupa toast yangmana nilainya diambil dari variabel name.
        holder.itemView.setOnClickListener{
            val name = dataRick?.get(position)?.name
            Toast.makeText(holder.itemView.context, "${name}",Toast.LENGTH_SHORT).show()
        }
    }
}
