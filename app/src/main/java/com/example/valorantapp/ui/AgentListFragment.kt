package com.example.valorantapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.valorantapp.R
import com.example.valorantapp.ui.viewmodel.ValorantViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AgentListFragment : Fragment(R.layout.fragment_agent_list){

    private lateinit var viewModel: ValorantViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ValorantViewModel::class.java)

    }
}