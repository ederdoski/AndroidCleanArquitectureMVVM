package com.adrena.basearchitect.features.flows.users.view.cell

import android.view.LayoutInflater
import android.view.ViewGroup
import com.adrena.basearchitect.core.base.BaseAdapter
import com.adrena.basearchitect.core.base.BaseViewHolder
import com.adrena.basearchitect.core.base.IOnItemClickViewHolder
import com.adrena.basearchitect.databinding.UsersViewCellBinding

class UsersAdapter(
    dataList: List<String> = mutableListOf(),
    private val onItemClickListener: IOnItemClickViewHolder
) : BaseAdapter<String>(dataList, onItemClickListener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        return UsersViewHolder(
            UsersViewCellBinding.inflate (
                LayoutInflater.from(parent.context), parent, false
            ), onItemClickListener
        )
    }
}