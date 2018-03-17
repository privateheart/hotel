package io.renren.modules.stock.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.modules.stock.vo.HGoodsVo;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.stock.entity.HGoods;
import io.renren.modules.stock.service.HGoodsService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 物品表
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-04 09:01:11
 */
@RestController
@RequestMapping("hgoods")
public class HGoodsController extends AbstractController {
	@Autowired
	private HGoodsService hGoodsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("hgoods:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<HGoodsVo> hGoodsList = hGoodsService.queryHGoodsVoList(query);
		int total = hGoodsService.queryHGoodsVoTotal(query);
		
		PageUtils pageUtil = new PageUtils(hGoodsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{goodsId}")
	@RequiresPermissions("hgoods:info")
	public R info(@PathVariable("goodsId") Integer goodsId){
		HGoods hGoods = hGoodsService.queryObject(goodsId);
		
		return R.ok().put("hGoods", hGoods);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("hgoods:save")
	public R save(@RequestBody HGoods hGoods){
		hGoods.setCreateTime(new Date());
		hGoods.setCreator(getUserId().intValue());
		hGoods.setIsValid(4);//4 在字典表代表是否有效
		hGoodsService.save(hGoods);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("hgoods:update")
	public R update(@RequestBody HGoods hGoods){
		hGoods.setModifyTime(new Date());
		hGoods.setModifier(getUserId().intValue());
		hGoods.setIsValid(4);//4 在字典表代表是否有效
		hGoodsService.update(hGoods);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("hgoods:delete")
	public R delete(@RequestBody Integer[] goodsIds){
		hGoodsService.deleteBatch(goodsIds);

		return R.ok();
	}
	
}
