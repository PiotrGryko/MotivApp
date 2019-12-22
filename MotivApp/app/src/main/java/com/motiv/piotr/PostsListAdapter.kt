 
package com.motiv.piotr
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.motiv.piotr.databinding.PostslistadapterBinding
import kotlin.collections.List
import kotlinx.android.synthetic.main.postslistadapter.view.*

public class PostsListAdapter : RecyclerView.Adapter<PostsListAdapter.AdapterViewHolder>() {

    private var onItemClickListener: OnItemClickListener? = null

    private var data: ArrayList<Post> = ArrayList()

    public interface OnItemClickListener {

        public fun onItemClick(position: Int, item: com.motiv.piotr.Post): Unit
    }

    public class AdapterViewHolder(val binding: PostslistadapterBinding) : RecyclerView.ViewHolder(binding.getRoot())

    override fun getItemCount(): Int {
        return data.size
    } fun getElement(position: Int): Post {
        return data.get(position)
    } fun setData(newData: List<com.motiv.piotr.Post>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    } override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): AdapterViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: PostslistadapterBinding = PostslistadapterBinding.inflate(inflater)
        return AdapterViewHolder(binding)
    } override fun onBindViewHolder(viewHolder: AdapterViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            if (onItemClickListener != null)
                onItemClickListener?.onItemClick(position, data.get(position))
        }
        val post: Post = data.get(position)
        viewHolder.binding.textview10.setText(post.getTitle())
    } fun setOnItemClickListener(onItemClickListener: com.motiv.piotr.PostsListAdapter.OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }
}
