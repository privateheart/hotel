package io.renren.modules.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.renren.modules.api.annotation.AuthIgnore;
import io.renren.modules.sys.vo.HDicVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.HDic;
import io.renren.modules.sys.service.HDicService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-02-25 15:32:17
 */
@RestController
@RequestMapping("hdic")
public class HDicController {
	@Autowired
	private HDicService hDicService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("hdic:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<HDicVo> hDicVos = hDicService.queryHDicVoList(query);
		int total = hDicService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(hDicVos, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{dicId}")
	@RequiresPermissions("hdic:info")
	public R info(@PathVariable("dicId") Integer dicId){
		HDic hDic = hDicService.queryObject(dicId);
		
		return R.ok().put("hDic", hDic);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("hdic:save")
	public R save(@RequestBody HDic hDic){
		hDicService.save(hDic);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("hdic:update")
	public R update(@RequestBody HDic hDic){
		hDicService.update(hDic);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("hdic:delete")
	public R delete(@RequestBody Integer[] dicIds){
		hDicService.deleteBatch(dicIds);
		
		return R.ok();
	}

}
