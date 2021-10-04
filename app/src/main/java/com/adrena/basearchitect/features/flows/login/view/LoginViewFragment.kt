package com.adrena.basearchitect.features.flows.login.view

import android.util.Log
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.adrena.basearchitect.R
import com.adrena.basearchitect.core.base.BaseFragment
import com.adrena.basearchitect.core.base.IOnItemClickViewHolder
import com.adrena.basearchitect.core.extensions.Event
import com.adrena.basearchitect.core.extensions.observe
import com.adrena.basearchitect.core.extensions.toVisible
import com.adrena.basearchitect.databinding.LoginViewFragmentBinding
import com.adrena.basearchitect.features.flows.login.datasource.entity.LoginEntityResponse
import com.adrena.basearchitect.features.flows.login.view.cell.UserAdapter
import com.adrena.basearchitect.features.flows.login.view.cell.UserViewInput
import com.adrena.basearchitect.features.flows.login.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.login_view_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginViewFragment : BaseFragment<LoginViewFragmentBinding>() {

    private val loginViewModel: LoginViewModel by viewModel()

    override fun screenName() = "LoginViewFragment"

    override fun setupObserversViewModel() {
        observe(loginViewModel.delegate.showProgress, this::showProgress)
        observe(loginViewModel.delegate.onLoginUpdate, this::onLoginUpdate)
    }

    override fun init() {
        onClickListener()
        initRecyclerView()
        loginViewModel.callLogin()
    }

    private fun onClickListener() {
        bindingView.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_register)
        }
    }

    private fun initRecyclerView() {
        val tmpAdapter = UserAdapter(onItemClickListener = userListClickListener)
        recyclerViewUsers.adapter = tmpAdapter
    }

    private val userListClickListener = object: IOnItemClickViewHolder {
        override fun onItemClick(caller: View?, position: Int) {
            val data = (recyclerViewUsers.adapter as UserAdapter).listData[position]
            Log.e("CLICK_LISTENER", data.toString())
        }
    }

    private fun setUserList() {
        val aDataUser: ArrayList<UserViewInput> =
            arrayListOf(UserViewInput("Eder", "Dominguez"), UserViewInput("Alber", "Dominguez"))
        val tmpAdapter = recyclerViewUsers.adapter as UserAdapter
        tmpAdapter.listData = aDataUser
    }

    //----- Event Methods

    private fun onLoginUpdate(event: Event<LoginEntityResponse>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                val name = it.data.user.name + " " +  it.data.user.lastName
                txtName.text = name
                setUserList()
            }
        }
    }

    //----- UI Methods

    private fun showProgress(event: Event<Unit>) {
        event.getContentIfNotHandled().let {
            it?.apply {
                bindingView.notNetwork.toVisible()
            }
        }
    }
}