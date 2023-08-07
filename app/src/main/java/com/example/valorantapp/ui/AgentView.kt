package com.example.valorantapp.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.valorantapp.R
import com.example.valorantapp.adapter.AgentAdapter
import com.example.valorantapp.domain.model.Agent

class AgentView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val listName: TextView
    private val agentListRecyclerView: RecyclerView

    init {
        inflate(context, R.layout.agent_view, this)

        listName = findViewById(R.id.list_name)
        agentListRecyclerView = findViewById(R.id.agent_list_recycler_view)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.AgentView)
        listName.text = attributes.getString(R.styleable.AgentView_text)

        attributes.recycle()
    }

    fun setAgentList(agents: List<Agent>) {
        agentListRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = AgentAdapter(agents)
        agentListRecyclerView.adapter = adapter
    }
}