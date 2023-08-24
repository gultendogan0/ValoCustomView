package com.example.valorantapp.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantapp.R
import com.example.valorantapp.adapter.AgentAdapter
import com.example.valorantapp.databinding.AgentViewBinding
import com.example.valorantapp.domain.model.Agent

class AgentView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private val binding: AgentViewBinding

    init {
        binding = AgentViewBinding.inflate(LayoutInflater.from(context), this, true)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.AgentView)
        binding.listName.text = attributes.getString(R.styleable.AgentView_text)

        attributes.recycle()
    }

    fun setAgentList(agents: List<Agent>?) {
        if (agents != null) {
            binding.agentListRecyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val adapter = AgentAdapter(agents)
            binding.agentListRecyclerView.adapter = adapter
        }
    }

    fun setListName(title: String) {
        binding.listName.text = title
    }
}