package com.borbi.boogiemeter.recording

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.borbi.boogiemeter.R
import com.borbi.boogiemeter.databinding.FragmentMainRecordBinding
import com.borbi.boogiemeter.databinding.FragmentRecordingBinding

class RecordingFragment : Fragment() {

    private val viewModel: RecordingViewModel by lazy {

        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProviders.of(this, RecordingViewModel.Factory(activity.application))
                .get(RecordingViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentRecordingBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_recording, container, false)

        binding.recordingViewModel = viewModel

        viewModel.navigateToMainRecord.observe(this, Observer {
            if (it == true) { // Observed state is true.
                this.findNavController().navigate(RecordingFragmentDirections.actionRecordingToSummaryFragment())
                viewModel.doneMoveToMainRecord()
            }
        })

        return binding.root
    }
}
