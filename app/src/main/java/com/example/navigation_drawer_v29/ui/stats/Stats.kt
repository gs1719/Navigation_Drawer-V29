package com.example.navigation_drawer_v29.ui.stats

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.navigation_drawer_v29.R
import com.example.navigation_drawer_v29.databinding.FragmentHomeBinding
import com.example.navigation_drawer_v29.databinding.FragmentStatsBinding

class Stats : Fragment() {

    private var _binding: FragmentStatsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: StatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val statsViewModel =
            ViewModelProvider(this).get(StatsViewModel::class.java)
        _binding = FragmentStatsBinding.inflate(inflater,container,false)
        val root: View = binding.root
        val textView: TextView = binding.textStats
        statsViewModel.text.observe(viewLifecycleOwner){
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}