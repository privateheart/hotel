package io.renren.modules.stock.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.stock.entity.HGoodsUnit;
import io.renren.modules.stock.service.HGoodsUnitService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;


/**
 * 物品--单位表  一个物品可以有多个单位
 *
 * @author ${author}
 * @email ${email}
 * @date 2018-03-19 07:02:14
 */
@RestController
@RequestMapping("hgoodsunit")
public class HGoodsUnitController extends AbstractController {
    @Autowired
    private HGoodsUnitService hGoodsUnitService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("hgoodsunit:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<HGoodsUnit> hGoodsUnitList = hGoodsUnitService.queryList(query);
        int total = hGoodsUnitService.queryTotal(query);
        PageUtils pageUtil = new PageUtils(hGoodsUnitList, total, query.getLimit(), query.getPage());
        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{goodsUnitId}")
    @RequiresPermissions("hgoodsunit:info")
    public R info(@PathVariable("goodsUnitId") Integer goodsUnitId) {
        HGoodsUnit hGoodsUnit = hGoodsUnitService.queryObject(goodsUnitId);
        return R.ok().put("hGoodsUnit", hGoodsUnit);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("hgoodsunit:save")
    public R save(@RequestBody HGoodsUnit hGoodsUnit) {
        hGoodsUnit.setCreateTime(new Date());
        hGoodsUnit.setCreator(getUser().getUserId().intValue());
        hGoodsUnit.setIsValid(1);
        hGoodsUnitService.save(hGoodsUnit);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("hgoodsunit:update")
    public R update(@RequestBody HGoodsUnit hGoodsUnit) {
        hGoodsUnit.setModifier(getUser().getUserId().intValue());
        hGoodsUnit.setModifyTime(new Date());
        hGoodsUnitService.update(hGoodsUnit);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("hgoodsunit:delete")
    public R delete(@RequestBody Integer[] goodsUnitIds) {
        hGoodsUnitService.deleteBatch(goodsUnitIds);
        return R.ok();
    }

    @RequestMapping("/queryGoodsUnits")
    public R queryGoodsUnits(@RequestParam(value = "goodsId", required = false) Integer goodsId) {
        List<HGoodsUnit> hGoodsUnits = hGoodsUnitService.queryUnitsByGoodsId(goodsId);
        return R.ok().put("units", hGoodsUnits);
    }
}
