package com.example.home_work_lection_5_1

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox

class SenderFragment : Fragment() {
    val addToBackStack: CheckBox by lazy { requireView().findViewById(R.id.addToBackStackCheck) }
    private val receiverFragment = ReceiverFragment()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("LifeCycle", "FragmentA: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LifeCycle", "FragmentA: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        Log.i("LifeCycle", "FragmentA: onCreateView")

        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("LifeCycle", "FragmentA: onViewCreated")

        initSendBtn()
        initReplaceBtn()
        initAddBtn()
    }

    override fun onStart() {
        super.onStart()
        Log.i("LifeCycle", "FragmentA: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LifeCycle", "FragmentA: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("LifeCycle", "FragmentA: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LifeCycle", "FragmentA: onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("LifeCycle", "FragmentA: onSaveInstanceState")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LifeCycle", "FragmentA: onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("LifeCycle", "FragmentA: onDetach")
    }

    private fun initSendBtn() {
        val data = Bundle()
        data.putString(MESSAGE_KEY, "Hi, i am from Fragment One")
        receiverFragment.arguments = data

        view?.findViewById<Button>(R.id.receiverBtn)?.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(id, receiverFragment)
                .addToBackStack("replaceSendFrg").commit()
        }
    }

    private fun initReplaceBtn() {
        view?.findViewById<Button>(R.id.replaceFrg)?.setOnClickListener {
            val replaceTrans = parentFragmentManager.beginTransaction().replace(id, receiverFragment)
            if (addToBackStack.isChecked) {
                replaceTrans.addToBackStack("replaceFrg")
            }
            replaceTrans.commit()
        }
    }

    private fun initAddBtn() {
        view?.findViewById<Button>(R.id.addFrg)?.setOnClickListener {
            val addTrans = parentFragmentManager.beginTransaction().add(id, receiverFragment)
            if (addToBackStack.isChecked) {
                addTrans.addToBackStack("addFrg")
            }
            addTrans.commit()
        }
    }

    companion object {
        val MESSAGE_KEY = "message"
    }
}