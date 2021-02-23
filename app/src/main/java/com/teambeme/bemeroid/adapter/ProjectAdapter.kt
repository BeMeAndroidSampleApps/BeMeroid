package com.teambeme.bemeroid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.teambeme.bemeroid.databinding.ItemProjectInfoBinding
import com.teambeme.bemeroid.model.ProjectData

class ProjectAdapter : RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder>() {
    private var projectList = listOf<ProjectData>()
    class ProjectViewHolder(private val binding: ItemProjectInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(projectData: ProjectData) {
            with(binding) {
                imgProjectInfo.setImageResource(projectData.imgProject)
                txtProjectTitle.text = projectData.txtProjectTitle
                txtProjectContent.text = projectData.txtProjectContents
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemProjectInfoBinding.inflate(layoutInflater, parent, false)
        return ProjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProjectViewHolder, position: Int) {
        holder.bind(projectList[position])
    }

    override fun getItemCount() = projectList.size

    fun replaceList(list: List<ProjectData>) {
        projectList = list.toList()
        notifyDataSetChanged()
    }
}