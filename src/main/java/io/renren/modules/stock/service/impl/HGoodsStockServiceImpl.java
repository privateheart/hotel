package io.renren.modules.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.stock.dao.HGoodsStockDao;
import io.renren.modules.stock.entity.HGoodsStock;
import io.renren.modules.stock.service.HGoodsStockService;


@Service("hGoodsStockService")
public class HGoodsStockServiceImpl implements HGoodsStockService {
    @Autowired
    private HGoodsStockDao hGoodsStockDao;

    @Override
    public HGoodsStock queryObject(Integer goodsStockId) {
        return hGoodsStockDao.queryObject(goodsStockId);
    }

    @Override
    public List<HGoodsStock> queryList(Map<String, Object> map) {
        return hGoodsStockDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return hGoodsStockDao.queryTotal(map);
    }

    @Override
    public void save(HGoodsStock hGoodsStock) {
        hGoodsStockDao.save(hGoodsStock);
    }

    @Override
    public void update(HGoodsStock hGoodsStock) {
        hGoodsStockDao.update(hGoodsStock);
    }

    @Override
    public void delete(Integer goodsStockId) {
        hGoodsStockDao.delete(goodsStockId);
    }

    @Override
    public void deleteBatch(Integer[] goodsStockIds) {
        hGoodsStockDao.deleteBatch(goodsStockIds);
    }

}
