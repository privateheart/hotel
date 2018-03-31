package io.renren.modules.stock.controller;

import java.util.List;
import java.util.Map;

import io.renren.modules.stock.vo.HGoodsStockVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.stock.entity.HGoodsStock;
import io.renren.modules.stock.service.HGoodsStockService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;


/**
 * 库存表
 *
 * @author ${author}
 * @email ${email}
 * @date 2018-03-24 09:28:49
 */
@RestController
@RequestMapping("hgoodsstock")
public class HGoodsStockController {
    @Autowired
    private HGoodsStockService hGoodsStockService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("hgoodsstock:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<HGoodsStockVo> hGoodsStockVos = hGoodsStockService.queryHGoodsStockVoList(query);
        int total = hGoodsStockService.queryHGoodsStockVoListTotal(query);
        PageUtils pageUtil = new PageUtils(hGoodsStockVos, total, query.getLimit(), query.getPage());

        return R.ok().put("page", pageUtil);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{goodsStockId}")
    @RequiresPermissions("hgoodsstock:info")
    public R info(@PathVariable("goodsStockId") Integer goodsStockId) {
        HGoodsStock hGoodsStock = hGoodsStockService.queryObject(goodsStockId);

        return R.ok().put("hGoodsStock", hGoodsStock);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("hgoodsstock:save")
    public R save(@RequestBody HGoodsStock hGoodsStock) {
        hGoodsStockService.save(hGoodsStock);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("hgoodsstock:update")
    public R update(@RequestBody HGoodsStock hGoodsStock) {
        hGoodsStockService.update(hGoodsStock);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("hgoodsstock:delete")
    public R delete(@RequestBody Integer[] goodsStockIds) {
        hGoodsStockService.deleteBatch(goodsStockIds);

        return R.ok();
    }

}
