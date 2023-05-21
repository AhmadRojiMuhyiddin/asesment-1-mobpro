package org.d3if3120.assesment2.ui.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import org.d3if3120.assesment2.R
import org.d3if3120.assesment2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.celciusToFarenhitBtn.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_celciusToFarenhitFragment2) }
        binding.celciusToKelvinBtn.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_celciusToKelvinFragment2) }
        binding.celciusToReamurBtn.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_celciusToReamurFragment) }
        binding.switchDarkMode.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_YES)
            }else{
                AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.histori -> {
                findNavController().navigate(R.id.action_homeFragment_to_historiFragment)
                return true
            }
            R.id.tentang_aplikasi -> {
                findNavController().navigate(R.id.action_homeFragment_to_aboutMeFragment)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}