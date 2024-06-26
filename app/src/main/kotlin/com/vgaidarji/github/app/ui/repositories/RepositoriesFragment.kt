package com.vgaidarji.github.app.ui.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vgaidarji.github.app.databinding.FragmentRepositoriesBinding

class RepositoriesFragment : Fragment() {

    private var _binding: FragmentRepositoriesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val repositoriesViewModel =
            ViewModelProvider(this).get(RepositoriesViewModel::class.java)

        _binding = FragmentRepositoriesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textRepositories
        repositoriesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
