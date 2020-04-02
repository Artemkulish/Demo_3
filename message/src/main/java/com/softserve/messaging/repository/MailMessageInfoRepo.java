package com.softserve.messaging.repository;

import com.softserve.messaging.model.MailMessageInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MailMessageInfoRepo extends PagingAndSortingRepository<MailMessageInfo, Long>,
        JpaSpecificationExecutor<MailMessageInfo> {
}
