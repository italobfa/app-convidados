package com.example.convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.databinding.FragmentAllBinding
import com.example.convidados.service.constants.GuestConstant
import com.example.convidados.service.constants.GuestConstant.Companion.GUESTID
import com.example.convidados.view.adapter.GuestAdapter
import com.example.convidados.view.listener.GuestListener
import com.example.convidados.viewmodel.AllGuestsViewModel

class AllGuestsFragment : Fragment() {

    private var _binding: FragmentAllBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: AllGuestsViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(AllGuestsViewModel::class.java)

        _binding = FragmentAllBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //obtendo a recycler view
        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)
        //definindo um layout para a recycler view
        recycler.layoutManager = LinearLayoutManager(context)
        //definindo um adapter, e a cola entre elementos e dados
        recycler.adapter = mAdapter

        mListener = object : GuestListener {
            override fun onClick(id: Int) {

                val intent = Intent(context, GuestFormActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(GUESTID, id)

                intent.putExtras(bundle)
                startActivity(intent)
            }

        }

        mAdapter.attachListener(mListener)

        observer()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //a fragment precisa ser recarregada para mostrar o novo convidado cadastrado.
    override fun onResume() {
        super.onResume()
        homeViewModel.load()
    }

    private fun observer() {
        homeViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}