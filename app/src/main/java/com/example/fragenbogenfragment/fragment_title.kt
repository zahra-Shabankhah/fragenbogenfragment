package com.example.fragenbogenfragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.fragenbogenfragment.databinding.FragmentTitleBinding

class fragment_title : Fragment() {
    private var _binding: FragmentTitleBinding? = null
    // This property is only valid between onCreateView and
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTitleBinding.inflate(inflater, container, false)
        val view = binding.root

        setHasOptionsMenu(true)

        binding.btn.setOnClickListener{view:View->
            Navigation.findNavController(view).navigate(R.id.action_fragment_title_to_fragment_game)

        }
        return view

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) ||
                super.onOptionsItemSelected(item)

      /*  or
        when(item.itemId){
            R.id.aboutFragment -> do sth

        }*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}