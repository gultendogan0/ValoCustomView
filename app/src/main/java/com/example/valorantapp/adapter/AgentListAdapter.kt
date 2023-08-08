package com.example.valorantapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantapp.databinding.AgentViewBinding
import com.example.valorantapp.domain.model.Agent
import com.example.valorantapp.ui.AgentView

class AgentListAdapter(
    private val agentLists: List<List<Agent>>,
    private val sectionTitles: List<String>
) : RecyclerView.Adapter<AgentListAdapter.AgentListHolder>() {

    class AgentListHolder(val binding: AgentViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val agentView: AgentView = AgentView(binding.root.context, null)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentListHolder {
        val binding = AgentViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AgentListHolder(binding)
    }

    override fun getItemCount(): Int {
        return agentLists.size
    }

    override fun onBindViewHolder(holder: AgentListHolder, position: Int) {
        val agents = agentLists[position]
        holder.agentView.setAgentList(agents, holder.binding.agentListRecyclerView)
        holder.binding.listName.text = sectionTitles[position]
    }
}