package com.adrena.basearchitect.test.view

import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel

import com.adrena.basearchitect.core.base.BaseFragment

import com.adrena.basearchitect.core.extensions.Event
import com.adrena.basearchitect.core.extensions.observe
import com.adrena.basearchitect.core.extensions.toGone
import com.adrena.basearchitect.core.extensions.toVisible
import androidx.navigation.fragment.navArgs

import com.adrena.basearchitect.databinding.LogoutViewFragmentBinding

import com.adrena.basearchitect.test.viewmodel.LogoutViewModel

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