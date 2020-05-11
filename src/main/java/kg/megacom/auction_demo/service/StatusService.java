package kg.megacom.auction_demo.service;

import kg.megacom.auction_demo.model.dto.StatusDto;

import java.util.List;

public interface StatusService {

    StatusDto saveStatus(StatusDto statusDto);

    List<StatusDto> findAllStatuses();
}
