package com.errorclient.resultapiapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.setFragmentResult
import com.errorclient.resultapiapp.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.editArgForFirstFragment.doAfterTextChanged { newText ->
            /**
             * Записываем значение из editText в key = KEY_STRING для KEY_LISTENER
             */
            setFragmentResult(KEY_LISTENER, bundleOf(KEY_STRING to newText.toString()))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}