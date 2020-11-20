package br.com.guests.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.guests.R
import br.com.guests.ui.main.viewmodel.PresentModel

class PresentFragment : Fragment() {

    private lateinit var presentModel: PresentModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presentModel =
            ViewModelProvider(this).get(PresentModel::class.java)
        val root = inflater.inflate(R.layout.fragment_present, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        presentModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}