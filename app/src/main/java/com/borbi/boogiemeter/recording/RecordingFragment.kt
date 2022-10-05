package com.borbi.boogiemeter.recording

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
import com.borbi.boogiemeter.database.BoogieMeterDatabase
import com.borbi.boogiemeter.databinding.FragmentRecordingBinding
import com.borbi.boogiemeter.mainRecord.MainRecordViewModel

class RecordingFragment : Fragment() {

    private lateinit var viewModel: RecordingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentRecordingBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_recording, container, false)

        val application = requireNotNull(this.activity).application
//        val dataSource = BoogieMeterDatabase.getInstance(application).boogieTimelineDao

        viewModel = ViewModelProvider(this).get(RecordingViewModel::class.java)

        binding.recordingViewModel = viewModel

        viewModel.navigateToMainRecord.observe(viewLifecycleOwner, Observer {
            if (it == true) { // Observed state is true.
                this.findNavController().navigate(RecordingFragmentDirections.actionRecordingToSummaryFragment())
                viewModel.doneMoveToMainRecord()
            }
        })

        return binding.root
    }
}
