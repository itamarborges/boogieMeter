package com.borbi.boogiemeter.mainRecord

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.borbi.boogiemeter.R
import com.borbi.boogiemeter.databinding.FragmentMainRecordBinding

class MainRecordFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
//        val view = DataBindingUtil.inflate(R.layout.fragment_main_record, container, false)

//        viewTransactionsButton.setOnClickListener { view ->
//            view.findNavController().navigate(R.id.viewTransactionsAction)
//        }

        val binding: FragmentMainRecordBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_main_record, container, false)
        return binding.root

    }
}
