package com.arsbulapps.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.arsbulapps.myapplication.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        for (i in 1..40) {
            val b = Button(context)
            b.text = i.toString()
            binding.listLayout.addView(b)
        }
        return binding.root
    }

}