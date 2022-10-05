package com.borbi.boogiemeter.gig

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
import com.borbi.boogiemeter.databinding.FragmentGigBinding

class GigFragment : Fragment() {

    private lateinit var viewModel: GigViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGigBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_gig, container, false)

        binding.setLifecycleOwner(this)

        viewModel = ViewModelProvider(this).get(GigViewModel::class.java)

        binding.gigViewModel = viewModel

        val application = requireNotNull(this.activity).application

        viewModel.navigateToRecording.observe(viewLifecycleOwner, Observer {
            if (it == true) { // Observed state is true.
                this.findNavController().navigate(GigFragmentDirections.actionGigFragmentToRecording())
                viewModel.doneMoveToRecording()
            }
        })

        val dataSource = BoogieMeterDatabase.getInstance(application).gigDao

        val viewModelFactory = GigViewModel.Factory(dataSource, application)

        val gigViewModel =
                ViewModelProvider(
                        this, viewModelFactory).get(GigViewModel::class.java)

        return binding.root
    }
}
