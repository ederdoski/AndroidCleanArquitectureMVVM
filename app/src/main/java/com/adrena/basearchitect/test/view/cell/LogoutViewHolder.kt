package com.adrena.basearchitect.test.view.cell

import com.adrena.basearchitect.core.base.BaseViewHolder
import com.adrena.basearchitect.core.base.IOnItemClickViewHolder
import com.adrena.basearchitect.databinding.LogoutViewCellBinding

class LogoutViewHolder(
    private val binding: LogoutViewCellBinding,
    onItemClickListener: IOnItemClickViewHolder
) : BaseViewHolder<String>(binding, onItemClickListener) {

    override fun bindingDataInHolder(data: String) {
        super.bindingDataInHolder(data)
        binding.txtName.text = data
    }
}