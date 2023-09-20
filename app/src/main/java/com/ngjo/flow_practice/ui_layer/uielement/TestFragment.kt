package com.ngjo.flow_practice.ui_layer.uielement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ngjo.flow_practice.databinding.FragmentTestBinding
import com.ngjo.flow_practice.ui_layer.stateholder.TestViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class TestFragment @Inject constructor() : Fragment() {
    private lateinit var binding: FragmentTestBinding

    private val viewModel: TestViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestBinding.inflate(inflater, container, false)

        initButtons()

        return binding.root
    }

    private fun initButtons() {
        binding.testButton1.setOnClickListener {
            viewModel.onClickTestButton()
        }

        lifecycleScope.launch {
            viewModel.uiState.collect { text ->
                binding.testText1.text = text
            }
        }
    }

    companion object {
        fun newInstance() = TestFragment().apply {

        }
    }
}