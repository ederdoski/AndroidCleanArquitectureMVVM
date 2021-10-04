package com.adrena.basearchitect.features.flows.login.view.cell

import android.view.LayoutInflater
import android.view.ViewGroup
import com.adrena.basearchitect.core.base.BaseAdapter
import com.adrena.basearchitect.core.base.BaseViewHolder
import com.adrena.basearchitect.core.base.IOnItemClickViewHolder
import com.adrena.basearchitect.databinding.LoginViewCellBinding

class UserAdapter(
    userList: List<UserViewInput> = mutableListOf(),
    private val onItemClickListener: IOnItemClickViewHolder
) : BaseAdapter<UserViewInput>(userList, onItemClickListener) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<UserViewInput> {
        return LoginViewHolder(
            LoginViewCellBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), onItemClickListener
        )
    }
}
