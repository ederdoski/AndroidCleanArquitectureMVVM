package com.adrena.basearchitect.features.flows.users.view

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

import com.adrena.basearchitect.core.base.BaseFragment

import com.adrena.basearchitect.core.extensions.Event
import com.adrena.basearchitect.core.extensions.observe
import com.adrena.basearchitect.core.extensions.toGone
import com.adrena.basearchitect.core.extensions.toVisible
import androidx.navigation.fragment.navArgs
import com.adrena.basearchitect.core.base.IOnItemClickViewHolder

import com.adrena.basearchitect.databinding.UsersViewFragmentBinding
import com.adrena.basearchitect.features.flows.users.view.cell.UsersAdapter

import com.adrena.basearchitect.features.flows.users.viewmodel.UsersViewModel
import kotlinx.android.synthetic.main.login_view_fragment.*

class UsersViewFragment : BaseFragment<UsersViewFragmentBinding>() {

    private val usersViewModel: UsersViewModel by viewModel()
    //private val viewInputArgument: UsersViewFragmentArgs by navArgs()

    override fun screenName() = "Users"
    
    override fun setupObserversViewModel() {
        observe(usersViewModel.delegate.showProgress, this::showProgress)
        observe(usersViewModel.delegate.hideProgress, this::hideProgress)
        observe(usersViewModel.delegate.showNetworkError, this::showNetworkError)
        observe(usersViewModel.delegate.hideNetworkError, this::hideNetworkError)
        observe(usersViewModel.delegate.showUnknownError, this::showUnknownError)
        observe(usersViewModel.delegate.hideUnknownError, this::hideUnknownError)
        observe(usersViewModel.delegate.onSetUsers, this::onSetUsers)
    }

    override fun init() {
        onClickListener()
        initRecyclerView()
    }

    private fun onClickListener() {
        bindingView.btnGetUsers.setOnClickListener {
            usersViewModel.callGetSomeMethod()
        }
    }

    private fun initRecyclerView() {
        val tmpAdapter = UsersAdapter(onItemClickListener = userListClickListener)
        recyclerViewUsers.adapter = tmpAdapter
    }

    private val userListClickListener = object: IOnItemClickViewHolder {
        override fun onItemClick(caller: View?, position: Int) {
            val data = (recyclerViewUsers.adapter as UsersAdapter).listData[position]
            Log.e("CLICK_LISTENER", data.toString())
        }
    }

    //----- Event Methods

    private fun onSetUsers(event: Event<Unit>) {
        val aDataUser: ArrayList<String> =
            arrayListOf("Eder", "Alber", "Dominguez")
        val tmpAdapter = recyclerViewUsers.adapter as UsersAdapter
        tmpAdapter.listData = aDataUser
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
                // bindingView.progress.viewProgress.toGone()
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
                // bindingView.genericError.root.toVisible()
            }
        }
    }

    private fun hideUnknownError(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                // bindingView.genericError.root.toGone()
            }
        }
    }
}