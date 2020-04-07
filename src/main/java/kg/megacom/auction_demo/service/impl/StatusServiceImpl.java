package kg.megacom.auction_demo.service.impl;

import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.StatusDto;
import kg.megacom.auction_demo.model.entity.Bid;
import kg.megacom.auction_demo.model.entity.Status;
import kg.megacom.auction_demo.service.StatusService;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    @Override
    public StatusDto saveStatus(StatusDto statusDto) {
        Status status = ClassMapper.INSTANCE.statusDtoToStatus(statusDto);
        statusDto = ClassMapper.INSTANCE.statusToStatusDto(status);
        return statusDto;
    }
}
