package com.mipke.starter.jobs.converter

import com.mipke.starter.common.model.BackendModelConverter
import com.mipke.starter.jobs.model.Job
import com.mipke.starter.jobs.model.JobEntity
import org.springframework.stereotype.Component

@Component
class JobConverter: BackendModelConverter<JobEntity, Job>() {

    override fun toData(model: JobEntity): Job =
            Job(model.id, model.name)
}
