package com.example.valorantapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.valorantapp.R
import com.example.valorantapp.adapter.AgentAdapter
import com.example.valorantapp.databinding.FragmentAgentListBinding
import com.example.valorantapp.domain.model.Agent
import com.example.valorantapp.ui.viewmodel.ValorantViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentListFragment : Fragment(R.layout.fragment_agent_list) {

    private lateinit var viewModel: ValorantViewModel
    private lateinit var binding: FragmentAgentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAgentListBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity()).get(ValorantViewModel::class.java)

        setupRecyclerViews()

        viewModel.agentsState.observe(viewLifecycleOwner) { resource ->
            val agentResponse = resource.data
            if (agentResponse != null) {
                val agents = agentResponse.data
                println("AGENT LIST: $agents")

                if (agents != null) {
                    setupAgentAdapters(agents)
                }
            }
        }

        viewModel.getAllAgents()
    }

    private fun setupRecyclerViews() {
        binding.duelistAgentListRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.controllerAgentListRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.initiatorAgentListRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.sentinelAgentListRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setupAgentAdapters(agents: List<Agent>) {
        val duelists = viewModel.getDuelistAgents()
        val controllers = viewModel.getControllerAgents()
        val initiator = viewModel.getInitiatorAgents()
        val sentinels = viewModel.getSentinelAgents()

        val adapterDuelists = duelists?.let { AgentAdapter(it) }
        val adapterControllers = controllers?.let { AgentAdapter(it) }
        val adapterInitiator = initiator?.let { AgentAdapter(it) }
        val adapterSentinels = sentinels?.let { AgentAdapter(it) }

        binding.duelistAgentListRecyclerView.adapter = adapterDuelists
        binding.controllerAgentListRecyclerView.adapter = adapterControllers
        binding.initiatorAgentListRecyclerView.adapter = adapterInitiator
        binding.sentinelAgentListRecyclerView.adapter = adapterSentinels
    }
}