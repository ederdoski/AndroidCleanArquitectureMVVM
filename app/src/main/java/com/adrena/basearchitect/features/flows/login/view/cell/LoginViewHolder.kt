package com.adrena.basearchitect.features.flows.login.view.cell

import com.adrena.basearchitect.core.base.BaseViewHolder
import com.adrena.basearchitect.core.base.IOnItemClickViewHolder
import com.adrena.basearchitect.databinding.LoginViewCellBinding

class LoginViewHolder(
    private val binding: LoginViewCellBinding,
    onItemClickListener: IOnItemClickViewHolder
) : BaseViewHolder<UserViewInput>(binding, onItemClickListener) {

    override fun bindingDataInHolder(data: UserViewInput) {
        super.bindingDataInHolder(data)
        setName(data)
    }

    private fun setName(data: UserViewInput) {
        val name = data.name +" "+ data.lastname
        binding.txtName.text = name
    }
}