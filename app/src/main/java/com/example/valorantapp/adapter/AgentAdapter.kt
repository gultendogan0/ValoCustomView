package com.example.valorantapp.adapter

import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.RequestListener
import com.example.valorantapp.R
import com.example.valorantapp.databinding.CustomAgentItemBinding
import com.example.valorantapp.domain.model.Agent

class AgentAdapter(private val agents: List<Agent>) : RecyclerView.Adapter<AgentAdapter.AgentHolder>(){

    class AgentHolder(val binding: CustomAgentItemBinding) :RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentHolder {
        val binding = CustomAgentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AgentHolder(binding)
    }

    override fun getItemCount(): Int {
        return agents.size
    }

    override fun onBindViewHolder(holder: AgentHolder, position: Int) {
        val itemWidth = (holder.binding.root.context.resources.displayMetrics.widthPixels * 0.60).toInt()
        val layoutParams = holder.binding.root.layoutParams
        layoutParams.width = itemWidth
        holder.binding.root.layoutParams = layoutParams

        holder.binding.agentName.text = agents[position].displayName
        holder.binding.agentRole.text = agents[position].role?.displayName

        Glide.with(holder.binding.root).load(agents[position].role?.displayIcon).into(holder.binding.agentIcon)

        Glide.with(holder.binding.root).load(agents[position].fullPortrait).into(holder.binding.agentPortrait)

        Glide.with(holder.binding.root).load(agents[position].background).into(holder.binding.agentBackground)

        Glide.with(holder.binding.root)
            .load(agents[position].fullPortrait)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    resource?.let {
                        Palette.from(it.toBitmap())
                            .generate { palette ->
                                val rgbMuted = palette?.mutedSwatch?.rgb ?: 0
                                val rgbDark = palette?.darkMutedSwatch?.rgb ?: 0
                                holder.binding.agentBackground.setColorFilter(rgbDark)
                                val gd = GradientDrawable(
                                    GradientDrawable.Orientation.BOTTOM_TOP,
                                    intArrayOf(
                                        ContextCompat.getColor(holder.binding.agentBackground.context, R.color.bunker),
                                        rgbMuted
                                    )
                                )
                                gd.cornerRadius = 35f
                                holder.binding.agentBackground.setBackgroundDrawable(gd)
                            }
                    }
                    return false
                }

            })
            .into(holder.binding.agentPortrait)
    }
}