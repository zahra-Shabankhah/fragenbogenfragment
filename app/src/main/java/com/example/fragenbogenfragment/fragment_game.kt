package com.example.fragenbogenfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.fragenbogenfragment.databinding.FragmentGameBinding
import com.example.fragenbogenfragment.databinding.FragmentTitleBinding

class fragment_game : Fragment() {
    private var _binding: FragmentGameBinding? = null
    // This property is only valid between onCreateView and
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btn.setOnClickListener{view:View->
            if (binding.rg.getCheckedRadioButtonId() == -1)
            {
                Toast.makeText(context, "Please select Gender", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if(binding.winnBtn.isChecked())
                {
                      Navigation.findNavController(view).navigate(R.id.action_fragment_game_to_gamewonfragment)
                }
                else
                {
                    Navigation.findNavController(view).navigate(R.id.action_fragment_game_to_gameOverFragment)
                }
            }

        }


        return view

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}