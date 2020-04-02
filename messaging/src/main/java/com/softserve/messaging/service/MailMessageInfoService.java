package com.softserve.messaging.service;

import com.softserve.messaging.dto.MailMessageInfoDto;
import com.softserve.messaging.model.MailMessageInfo;
import com.softserve.messaging.model.UserReceipt;
import com.softserve.messaging.model.UserValidation;
import com.softserve.messaging.repository.MailMessageInfoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MailMessageInfoService {

    private final MailMessageInfoRepo mailMessageInfoRepo;
    private final ConversionService conversionService;

    public Page<MailMessageInfoDto> getMessages(MailMessageInfoDto mailMessageInfoDto, Pageable pageable) {

        Specification<MailMessageInfo> mailMessageInfoSpecification = (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (mailMessageInfoDto.getEmail() != null && !mailMessageInfoDto.getEmail().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("email"), mailMessageInfoDto.getEmail()));
            }
            if (mailMessageInfoDto.getEmailType() != null) {
                predicates.add(criteriaBuilder.equal(root.get("emailType"), mailMessageInfoDto.getEmailType()));
            }

            return predicates.isEmpty() ? null : criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };

        return mailMessageInfoRepo.findAll(mailMessageInfoSpecification, pageable)
                .map(mailMessageInfo -> conversionService.convert(mailMessageInfo, MailMessageInfoDto.class));
    }

    public MailMessageInfo saveUserReceipt(UserReceipt userReceipt) {
        return mailMessageInfoRepo.save(conversionService.convert(userReceipt, MailMessageInfo.class));
    }

    public MailMessageInfo saveUserValidation(UserValidation userValidation) {
        return mailMessageInfoRepo.save(conversionService.convert(userValidation, MailMessageInfo.class));
    }
}
