package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.databinding.ViewItemBinding

/**
 * @author DaisyBell on 05.06.2024
 */
class ItemsAdapter : RecyclerView.Adapter<ItemsViewHolder>() {

    private var list = ArrayList<CharSequence>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder =
        ItemsViewHolder(ViewItemBinding.inflate(LayoutInflater.from(parent.context)))

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun update(newList: List<CharSequence>) {
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}

class ItemsViewHolder(private val binding: ViewItemBinding) : ViewHolder(binding.root) {
    fun bind(text: CharSequence) {
        binding.elementTextView.text = text
    }
}