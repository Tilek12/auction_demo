package kg.megacom.auction_demo.service.impl;

import kg.megacom.auction_demo.database.StatusRepository;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.StatusDto;
import kg.megacom.auction_demo.model.entity.Bid;
import kg.megacom.auction_demo.model.entity.Status;
import kg.megacom.auction_demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public StatusDto saveStatus(StatusDto statusDto) {
        Status status = ClassMapper.INSTANCE.statusDtoToStatus(statusDto);
        status = statusRepository.save(status);
        statusDto = ClassMapper.INSTANCE.statusToStatusDto(status);
        return statusDto;
    }

    @Override
    public List<Status> findAllStatuses() {
        return statusRepository.findAll();
    }
}
