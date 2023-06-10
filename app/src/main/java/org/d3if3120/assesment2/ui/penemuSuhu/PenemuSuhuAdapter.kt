package org.d3if3120.assesment2.ui.penemuSuhu

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if3120.assesment2.R
import org.d3if3120.assesment2.databinding.ListItemBinding
import org.d3if3120.assesment2.model.PenemuSuhu
import org.d3if3120.assesment2.network.ServiceAPI

class PenemuSuhuAdapter : RecyclerView.Adapter<PenemuSuhuAdapter.ViewHolder>(){

    private val data = mutableListOf<PenemuSuhu>()

    fun updateData(newData: List<PenemuSuhu>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(suku : PenemuSuhu) = with(binding){
            judulTextView.text = suku.judul
            tglTextView.text = suku.tgl
            Glide.with(imageView.context)
                .load(ServiceAPI.getSuhuUrl(suku.imageId))
                .error(R.drawable.baseline_broken_image_24)
                .into(imageView)
            tempatTextView.text = suku.tempat
            deskripsiTextView.text = suku.deskripsi


            root.setOnClickListener{
                val message = root.context.getString(R.string.message, suku.judul)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}