package com.borbi.boogiemeter.mainRecord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.borbi.boogiemeter.R
import com.borbi.boogiemeter.databinding.FragmentMainRecordBinding

class MainRecordFragment : Fragment() {

    private lateinit var viewModel: MainRecordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentMainRecordBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_main_record, container, false)

        viewModel = ViewModelProviders.of(this).get(MainRecordViewModel::class.java)

        binding.mainRecordViewModel = viewModel

        viewModel.navigateToRecording.observe(this, Observer {
            if (it == true) { // Observed state is true.
                this.findNavController().navigate(MainRecordFragmentDirections.actionMainRecordToRecording())
                viewModel.doneMoveToRecording()
            }
        })

        return binding.root

    }
}
