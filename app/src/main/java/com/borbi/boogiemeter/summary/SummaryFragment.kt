package com.borbi.boogiemeter.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.borbi.boogiemeter.R
import com.borbi.boogiemeter.databinding.FragmentSummaryBinding

class SummaryFragment : Fragment() {

    private lateinit var viewModel: SummaryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentSummaryBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_summary, container, false)

        viewModel = ViewModelProviders.of(this).get(SummaryViewModel::class.java)

        binding.summaryViewModel = viewModel

        viewModel.navigateToMainRecord.observe(this, Observer {
            if (it == true) { // Observed state is true.
                this.findNavController().navigate(SummaryFragmentDirections.actionSummaryFragmentToMainRecord())
                viewModel.doneMoveToMainRecord()
            }
        })

        return binding.root

    }
}
