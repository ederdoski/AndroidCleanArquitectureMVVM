package com.adrena.basearchitect.test.view

import android.util.Log
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel

import com.adrena.basearchitect.core.base.BaseFragment
import com.adrena.basearchitect.core.base.IOnItemClickViewHolder

import com.adrena.basearchitect.core.extensions.Event
import com.adrena.basearchitect.core.extensions.observe

import com.adrena.basearchitect.databinding.LogoutViewFragmentBinding
import com.adrena.basearchitect.features.flows.login.view.cell.UserAdapter
import com.adrena.basearchitect.features.flows.login.view.cell.UserViewInput
import com.adrena.basearchitect.test.view.cell.LogoutAdapter

import com.adrena.basearchitect.test.viewmodel.LogoutViewModel
import kotlinx.android.synthetic.main.login_view_fragment.*
import kotlinx.android.synthetic.main.logout_view_fragment.*

class LogoutViewFragment : BaseFragment<LogoutViewFragmentBinding>() {

    private val logoutViewModel: LogoutViewModel by viewModel()
    //private val viewInputArgument: LogoutViewFragmentArgs by navArgs()

    override fun screenName() = "Logout"
    
    override fun setupObserversViewModel() {
        observe(logoutViewModel.delegate.showProgress, this::showProgress)
        observe(logoutViewModel.delegate.hideProgress, this::hideProgress)
        observe(logoutViewModel.delegate.showNetworkError, this::showNetworkError)
        observe(logoutViewModel.delegate.hideNetworkError, this::hideNetworkError)
        observe(logoutViewModel.delegate.showUnknownError, this::showUnknownError)
        observe(logoutViewModel.delegate.hideUnknownError, this::hideUnknownError)
    }

    override fun init() {
        //---- Initialize your ui here
        initializeRecyclerView()
        setRecycler()
    }

    private fun initializeRecyclerView() {
        val tmpAdapter = LogoutAdapter(onItemClickListener = onClickListener)
        recyclerViewLogout.adapter = tmpAdapter
    }

    private val onClickListener = object : IOnItemClickViewHolder {
        override fun onItemClick(caller: View?, position: Int) {
           val data = (recyclerViewLogout.adapter as LogoutAdapter).listData[position]
            Log.e("CLICK", data.toString())
        }
    }

    private fun setRecycler() {
        val aData: ArrayList<String> = arrayListOf("User 1", "User 2", "User 3")
        val tmpAdapter = recyclerViewLogout.adapter as LogoutAdapter
        tmpAdapter.listData = aData
    }

    //----- UI Methods
    private fun showProgress(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                //bindingView.progress.viewProgress.toVisible()
            }
        }
    }

    private fun hideProgress(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                //bindingView.progress.viewProgress.toGone()
            }
        }
    }

    private fun showNetworkError(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                //bindingView.notNetwork.root.toVisible()
            }
        }
    }

    private fun hideNetworkError(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                //bindingView.notNetwork.root.toGone()
            }
        }
    }

    private fun showUnknownError(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                //bindingView.genericError.root.toVisible()
            }
        }
    }

    private fun hideUnknownError(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                //bindingView.genericError.root.toGone()
            }
        }
    }
}