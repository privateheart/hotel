package io.renren.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.stock.dao.HGoodsUnitDao;
import io.renren.modules.stock.entity.HGoodsUnit;
import io.renren.modules.stock.service.HGoodsUnitService;


@Service("hGoodsUnitService")
public class HGoodsUnitServiceImpl implements HGoodsUnitService {
    @Autowired
    private HGoodsUnitDao hGoodsUnitDao;

    @Override
    public HGoodsUnit queryObject(Integer goodsUnitId) {
        return hGoodsUnitDao.queryObject(goodsUnitId);
    }

    @Override
    public List<HGoodsUnit> queryList(Map<String, Object> map) {
        return hGoodsUnitDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return hGoodsUnitDao.queryTotal(map);
    }

    @Override
    public void save(HGoodsUnit hGoodsUnit) {
        hGoodsUnitDao.save(hGoodsUnit);
    }

    @Override
    public void update(HGoodsUnit hGoodsUnit) {
        hGoodsUnitDao.update(hGoodsUnit);
    }

    @Override
    public void delete(Integer goodsUnitId) {
        hGoodsUnitDao.delete(goodsUnitId);
    }

    @Override
    public void deleteBatch(Integer[] goodsUnitIds) {
        hGoodsUnitDao.deleteBatch(goodsUnitIds);
    }

    @Override
    public List<HGoodsUnit> queryUnitsByGoodsId(Integer goodsId) {
        return hGoodsUnitDao.queryUnitsByGoodsId(goodsId);
    }
}
