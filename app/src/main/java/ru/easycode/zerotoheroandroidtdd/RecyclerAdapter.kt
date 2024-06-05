package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.RecyclerItemBinding

/**
 * @author DaisyBell on 29.05.2024
 */
class RecyclerAdapter : RecyclerView.Adapter<RecyclerViewHolder>() {

    private val itemsList = ArrayList<CharSequence>()

    fun add(source: CharSequence) {
        itemsList.add(source)
        notifyItemInserted(itemsList.size - 1)
    }

    fun save(bundle: Bundle) {
        bundle.putCharSequenceArrayList(KEY, itemsList)
    }

    fun restore(bundle: Bundle) {
        itemsList.addAll(bundle.getCharSequenceArrayList(KEY) ?: ArrayList())
        notifyItemRangeInserted(0, itemsList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = itemsList.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    companion object {
        const val KEY = "RecyclerAdapterKey"
    }
}

class RecyclerViewHolder(private val binding: RecyclerItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(source: CharSequence) {
        binding.elementTextView.text = source
    }
}
