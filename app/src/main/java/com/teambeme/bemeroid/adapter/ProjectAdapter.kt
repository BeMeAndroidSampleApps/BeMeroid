package com.teambeme.bemeroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.teambeme.bemeroid.databinding.ItemProjectInfoBinding
import com.teambeme.bemeroid.model.ProjectData
import com.teambeme.bemeroid.model.ResponsePeople

class ProjectAdapter : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {
    private var projectList = listOf<ResponsePeople.Data>()
    class ProjectViewHolder(
        private val binding: ItemProjectInfoBinding,
        private val context: Context
        ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(peopleData: ResponsePeople.Data) {
            with(binding) {
                Glide.with(context).load(peopleData.avatar).into(binding.imgProjectInfo)
                txtProjectTitle.setText("${peopleData.firstName} ${peopleData.lastName}")
                txtProjectContent.text = peopleData.email
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemProjectInfoBinding.inflate(layoutInflater, parent, false)
        return ProjectViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(projectList[position])
    }

    override fun getItemCount() = projectList.size

    fun replaceList(list: List<ResponsePeople.Data>) {
        projectList = list.toList()
        notifyDataSetChanged()
    }
}