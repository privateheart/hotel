package io.renren.modules.stock.service.impl;

import io.renren.common.exception.RRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        checkAtomicExits(hGoodsUnit);
        hGoodsUnitDao.save(hGoodsUnit);
    }

    @Override
    public void update(HGoodsUnit hGoodsUnit) {
        HGoodsUnit orginalGoodsUnit = hGoodsUnitDao.queryObject(hGoodsUnit.getGoodsUnitId());
        if (orginalGoodsUnit.getIsAtomic() == 0 && hGoodsUnit.getIsAtomic() == 1) {// 从非原子单位 变为原子单位
            checkAtomicExits(hGoodsUnit);
        } else if (orginalGoodsUnit.getIsAtomic() == 1 && hGoodsUnit.getIsAtomic() == 0) {// 从原子单位变为 非原子单位
            throw new RRException("原子单位不能直接修改为非原子单位，请直接删除原子单位，再新增一个！");
        }
        checkAtomicExits(hGoodsUnit);
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

    private void checkAtomicExits(HGoodsUnit hGoodsUnit) {
        if (hGoodsUnit.getIsAtomic() == 1) {//是原子单位
//            检查数据库是否已存在该物品的原子单位
            Integer atomUnitCount = hGoodsUnitDao.checkAtomUnitCount(hGoodsUnit.getGoodsId());
            if (atomUnitCount > 0) {
                throw new RRException("该物品已经存在了原子单位，如果要更换原子单位，请先删除当前物品的原子单位", -1);
            }
        }
    }
}
