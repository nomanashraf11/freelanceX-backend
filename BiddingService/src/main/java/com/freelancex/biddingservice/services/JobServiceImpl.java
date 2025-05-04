package com.freelancex.biddingservice.services;

import com.freelancex.biddingservice.dtos.event.job.CreateJobEvent;
import com.freelancex.biddingservice.dtos.event.job.UpdateJobEvent;
import com.freelancex.biddingservice.models.Job;
import com.freelancex.biddingservice.repositories.JobRepository;
import com.freelancex.biddingservice.services.interfaces.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;
    private final static Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @Override
    public void createJob(CreateJobEvent event) {
        Job job = new Job();

        job.setJobId(event.jobId());
        job.setBudget(event.budget());
        job.setTitle(event.title());
        job.setStatus(event.status());

        jobRepository.save(job);
        logger.info("Job created: {}", job.getJobId());
    }

    @Override
    public void updateJob(UpdateJobEvent event) {
        Optional<Job> job = jobRepository.findById(event.jobId());

        if (job.isPresent()) {
            Job jobToUpdate = job.get();
            jobToUpdate.setTitle(event.title());
            jobToUpdate.setStatus(event.status());
            jobToUpdate.setBudget(event.budget());

            jobRepository.save(jobToUpdate);
            logger.info("Job updated: {}", jobToUpdate.getJobId());
        }
    }
}
