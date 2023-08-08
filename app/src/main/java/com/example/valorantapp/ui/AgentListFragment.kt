package com.example.valorantapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.valorantapp.R
import com.example.valorantapp.adapter.AgentListAdapter
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

        viewModel.agentsState.observe(viewLifecycleOwner) { resource ->
            val agentResponse = resource.data
            if (agentResponse != null) {
                val agents = agentResponse.data

                if (agents != null) {
                    setupAgentRecyclerView()

                }
            }
        }

        viewModel.getAllAgents()
    }

    private fun setupAgentRecyclerView() {
        val agentSections = listOf(
            viewModel.getDuelistAgents(),
            viewModel.getControllerAgents(),
            viewModel.getInitiatorAgents(),
            viewModel.getSentinelAgents()
        )

        val sectionTitles = listOf("Duelists", "Controllers", "Initiators", "Sentinels")

        val adapter = AgentListAdapter(agentSections, sectionTitles)
        binding.agentRecyclerView.adapter = adapter

    }


    /*
    private fun setupAgentView() {
        binding.run {
            duelistAgentView.setAgentList(viewModel.getDuelistAgents())
            controllerAgentView.setAgentList(viewModel.getControllerAgents())
            initiatorAgentView.setAgentList(viewModel.getInitiatorAgents())
            sentinelAgentView.setAgentList(viewModel.getSentinelAgents())
        }
    }

     */

}