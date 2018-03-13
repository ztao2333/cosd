package net.cosd.service.impl;

import net.cosd.service.SpittleRepository;
import net.cosd.vo.Spittle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component("SpittleRepository")
public class SpittleRespositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i=0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    @Override
    public Spittle findOne(long spittleId) {
        Spittle spittle = new Spittle("Spittle " + spittleId, new Date());
        return spittle;
    }

}
