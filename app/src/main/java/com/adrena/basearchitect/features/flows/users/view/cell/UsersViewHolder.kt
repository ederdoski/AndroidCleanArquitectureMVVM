package com.adrena.basearchitect.features.flows.users.view.cell

import com.adrena.basearchitect.core.base.BaseViewHolder
import com.adrena.basearchitect.core.base.IOnItemClickViewHolder
import com.adrena.basearchitect.databinding.UsersViewCellBinding

class UsersViewHolder(
    private val binding: UsersViewCellBinding,
    onItemClickListener: IOnItemClickViewHolder
) : BaseViewHolder<String>(binding, onItemClickListener) {

    override fun bindingDataInHolder(data: String) {
        super.bindingDataInHolder(data)
        binding.txtName.text = data
    }
}