package kg.megacom.auction_demo.service.impl;

import kg.megacom.auction_demo.database.LotRepository;
import kg.megacom.auction_demo.mapper.ClassMapper;
import kg.megacom.auction_demo.model.dto.LotDto;
import kg.megacom.auction_demo.model.entity.Lot;
import kg.megacom.auction_demo.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LotServiceImpl implements LotService {

    @Autowired
    private LotRepository lotRepository;

    @Override
    public LotDto saveLot(LotDto lotDto) {

        Lot lot = ClassMapper.INSTANCE.lotDtoToLot(lotDto);
        lot = lotRepository.save(lot);
        lotDto = ClassMapper.INSTANCE.lotToLotDto(lot);
        return lotDto;
    }

    @Override
    public LotDto updateLot(LotDto lotDto) {

        Lot lot = ClassMapper.INSTANCE.lotDtoToLot(lotDto);
        lot = lotRepository.save(lot);
        lotDto = ClassMapper.INSTANCE.lotToLotDto(lot);
        return lotDto;
    }

    @Override
    public List<LotDto> findAllLots() {

        return lotRepository.findAll()
                .stream()
                .map(ClassMapper.INSTANCE::lotToLotDto)
                .collect(Collectors.toList());
    }

    @Override
    public LotDto findById(Long id) {
        Lot lot = lotRepository.findById(id).orElse(null);
        return ClassMapper.INSTANCE.lotToLotDto(lot);
    }
}


