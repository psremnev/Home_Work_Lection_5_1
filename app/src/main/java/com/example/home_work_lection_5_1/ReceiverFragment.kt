package com.example.home_work_lection_5_1

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ReceiverFragment: Fragment() {
    private val model: ReceiverFragmentModel by lazy { ViewModelProvider(requireActivity())[ReceiverFragmentModel::class.java] }
    val messageView: TextView by lazy { requireView().findViewById(R.id.message) }
    val readBtn: Button by lazy { requireView().findViewById(R.id.readBtn) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("LifeCycle", "FragmentB: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LifeCycle", "FragmentB: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        Log.i("LifeCycle", "FragmentB: onCreateView")

        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("LifeCycle", "FragmentB: onViewCreated")
        
        initMessageView()
        initReadBtn()
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifeCycle", "FragmentB: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifeCycle", "FragmentB: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifeCycle", "FragmentB: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeCycle", "FragmentB: onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("LifeCycle", "FragmentB: onSaveInstanceState")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycle", "FragmentB: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("LifeCycle", "FragmentB: onDetach")
    }

    private fun initMessageView() {
        if (model.readBtnVisibility == View.VISIBLE) {
            model.message.value = arguments?.getString(SenderFragment.MESSAGE_KEY)
        }
        messageView.text = model.message.value
    }

    private fun initReadBtn() {
        readBtn.visibility = model.readBtnVisibility

        if (readBtn.visibility == View.VISIBLE) {
            readBtn.setOnClickListener {
                messageView.text = allReadMessage
                model.message.value = allReadMessage
                it.visibility = View.GONE
                model.readBtnVisibility = View.GONE
            }
        }
    }

    companion object {
        val allReadMessage = "All messages is read"
    }
}