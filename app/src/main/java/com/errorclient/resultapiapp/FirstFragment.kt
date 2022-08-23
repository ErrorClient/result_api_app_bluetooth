package com.errorclient.resultapiapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import com.errorclient.resultapiapp.databinding.FragmentFirstBinding

const val KEY_LISTENER = "key_listener"
const val KEY_STRING = "key_string"

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Устанавливаем слушателя для KEY_LISTENER в момент создания фрагмента
         * записываем в firstText.text значение из bundle для key = KEY_STRING
         */
        setFragmentResultListener(KEY_LISTENER) { _, bundle ->
            binding.firstText.text = bundle.getString(KEY_STRING) ?: "no"
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.buttonToSecondFragment.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace<SecondFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}