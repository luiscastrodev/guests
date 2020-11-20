package br.com.guests.ui.main.view

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
import br.com.guests.R
import br.com.guests.ui.main.repository.constants.GuestConstants
import br.com.guests.ui.main.view.adapter.GuestAdapter
import br.com.guests.ui.main.view.listener.GuestListener
import br.com.guests.ui.main.viewmodel.GuestViewModel

class AllGuestFragment : Fragment(), GuestListener {

    private lateinit var mViewModel: GuestViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mViewModel =
            ViewModelProvider(this).get(GuestViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all_guests, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)

        recycler.layoutManager = LinearLayoutManager(context)

        recycler.adapter = mAdapter
        mAdapter.attachListener(this)

        observer()

        return root
    }

    override fun onResume() {
        super.onResume()

        mViewModel.load(GuestConstants.FILTER.EMPTY)
    }

    private fun observer() {
        mViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuest(it)
        })
    }

    override fun onclick(id: Int) {
        val intent = Intent(context, GuestFormActivity::class.java)
        val bundle = Bundle()
        bundle.putInt(GuestConstants.GUESTID, id)
        intent.putExtras(bundle)
        startActivity(intent)

    }

    override fun onDelete(id: Int) {
        mViewModel.delete(id)
        mViewModel.load(GuestConstants.FILTER.EMPTY)
    }

}