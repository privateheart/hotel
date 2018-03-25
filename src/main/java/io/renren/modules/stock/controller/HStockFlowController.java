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

import io.renren.modules.stock.entity.HStockFlow;
import io.renren.modules.stock.service.HStockFlowService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 库存流动记录表
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-24 15:32:42
 */
@RestController
@RequestMapping("hstockflow")
public class HStockFlowController extends AbstractController{
	@Autowired
	private HStockFlowService hStockFlowService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("hstockflow:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<HStockFlow> hStockFlowList = hStockFlowService.queryList(query);
		int total = hStockFlowService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(hStockFlowList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{stockFlowId}")
	@RequiresPermissions("hstockflow:info")
	public R info(@PathVariable("stockFlowId") Integer stockFlowId){
		HStockFlow hStockFlow = hStockFlowService.queryObject(stockFlowId);
		
		return R.ok().put("hStockFlow", hStockFlow);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("hstockflow:save")
	public R save(@RequestBody HStockFlow hStockFlow){
		hStockFlow.setCreateTime(new Date());
		hStockFlow.setCreator(getUserId().intValue());
		hStockFlowService.save(hStockFlow);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("hstockflow:update")
	public R update(@RequestBody HStockFlow hStockFlow){
		hStockFlow.setModifier(getUserId().intValue());
		hStockFlow.setModifyTime(new Date());
		hStockFlowService.update(hStockFlow);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("hstockflow:delete")
	public R delete(@RequestBody Integer[] stockFlowIds){
		hStockFlowService.deleteBatch(stockFlowIds);
		
		return R.ok();
	}
	
}
