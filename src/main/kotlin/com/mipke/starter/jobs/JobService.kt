package com.mipke.starter.jobs

import com.mipke.starter.common.service.BaseService
import com.mipke.starter.jobs.converter.JobConverter
import com.mipke.starter.jobs.model.Job
import com.mipke.starter.jobs.model.JobEntity
import com.mipke.starter.jobs.model.NewJobRequestPayload
import org.springframework.stereotype.Service
import java.util.*

@Service
class JobService(
        jobConverter: JobConverter
): BaseService<JobEntity, Job>(jobConverter) {

    override val name: String = "Job"

    private val jobsDataStore = mutableListOf<JobEntity>()

    fun getAllJobs(): List<Job> =
            jobsDataStore.map { je -> modelConverter.toData(je) }

    fun createNewJob(payload: NewJobRequestPayload): Job {
        payload.validatePayload()
        val asEntity = payload.toJobEntity()
        jobsDataStore.add(asEntity)
        return modelConverter.toData(asEntity)
    }

    private fun NewJobRequestPayload.validatePayload() {
        //isTrue(this.name.isNotEmpty(), "Job name must not be left empty")
    }

    companion object {
        private fun NewJobRequestPayload.toJobEntity() =
                JobEntity(UUID.randomUUID().toString(), this.name)
    }
}
