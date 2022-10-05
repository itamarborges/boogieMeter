package com.borbi.boogiemeter.mainRecord

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.borbi.boogiemeter.R
import com.borbi.boogiemeter.databinding.FragmentMainRecordBinding

class MainRecordFragment : Fragment() {

    private lateinit var viewModel: MainRecordViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentMainRecordBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_main_record, container, false)

        viewModel = ViewModelProvider(this).get(MainRecordViewModel::class.java)

        binding.mainRecordViewModel = viewModel

        viewModel.navigateToEvent.observe(viewLifecycleOwner, Observer {
            if (it == true) { // Observed state is true.
//              this.findNavController().navigate(MainRecordFragmentDirections.actionMainRecordToEventFragment())
                viewModel.doneMoveToEvent()
            }
        })

        viewModel.navigateToRecording.observe(viewLifecycleOwner, Observer {
            if (it == true) { // Observed state is true.
//                this.findNavController().navigate(MainRecordFragmentDirections.actionMainRecordToRecording())
                viewModel.doneMoveToRecording()
            }
        })

        return binding.root

    }
}
