package com.mipke.starter.jobs

import com.mipke.starter.jobs.model.Job
import com.mipke.starter.jobs.model.NewJobRequestPayload
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("jobs")
class JobsReadOnlyController(
    private val jobService: JobService
) {

    @GetMapping
    fun getAllDataJobs(): ResponseEntity<List<Job>> =
        ResponseEntity.ok(jobService.getAllJobs())
}

@RestController
@RequestMapping("jobs")
class JobsMutableController(
    private val jobService: JobService
) {

    @PostMapping
    fun createNewJob(@RequestBody payload: NewJobRequestPayload): ResponseEntity<Job> =
        ResponseEntity.ok(jobService.createNewJob(payload))
}
