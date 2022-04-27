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

        val model: ReceiverFragmentModel = ViewModelProvider(requireActivity())[ReceiverFragmentModel::class.java]
        if (savedInstanceState != null) {
            initModel(model)
        }
        initMessageView()
        initReadBtn(model)
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

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("LifeCycle", "FragmentB: onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycle", "FragmentB: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("LifeCycle", "FragmentB: onDetach")
    }

    private fun initModel(model:ReceiverFragmentModel) {
        model.message.value = arguments?.getString(MESSAGE_KEY)
    }

    private fun initMessageView() {
        requireView().findViewById<TextView>(R.id.message).text = arguments?.getString(MESSAGE_KEY)
    }

    private fun initReadBtn(model: ReceiverFragmentModel) {
        val readBtn: Button = requireView().findViewById(R.id.readBtn)
        readBtn.visibility = model.readBtnVisibility

        readBtn.setOnClickListener {
            requireView().findViewById<TextView>(R.id.message).text = allReadMessage
            model.message.value = allReadMessage
            it.visibility = View.GONE
            model.readBtnVisibility = View.GONE
        }
    }

    companion object {
        fun newInstance(): ReceiverFragment {
            val receiverFragment = ReceiverFragment()
            val data = Bundle()
            data.putString(MESSAGE_KEY, "Hi, i am from Fragment One")
            receiverFragment.arguments = data
            return receiverFragment
        }
        private const val MESSAGE_KEY = "message"
        private const val allReadMessage = "All messages is read"
    }
}