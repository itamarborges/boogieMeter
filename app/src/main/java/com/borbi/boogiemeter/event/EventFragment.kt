package com.borbi.boogiemeter.recording

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
import com.borbi.boogiemeter.databinding.FragmentEventBinding
import com.borbi.boogiemeter.event.EventViewModel
import com.borbi.boogiemeter.mainRecord.MainRecordFragmentDirections

class EventFragment : Fragment() {

    private val viewModel: EventViewModel by lazy {

        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProviders.of(this, EventViewModel.Factory(activity.application))
                .get(EventViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentEventBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_event, container, false)

        binding.eventViewModel = viewModel

        viewModel.navigateToRecording.observe(this, Observer {
            if (it == true) { // Observed state is true.
                this.findNavController().navigate(EventFragmentDirections.actionEventFragmentToRecording())
                viewModel.doneMoveToRecording()
            }
        })

        return binding.root
    }
}
