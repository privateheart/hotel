package io.renren.modules.sys.controller;

import java.util.List;
import java.util.Map;

import io.renren.modules.api.annotation.AuthIgnore;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.sys.entity.HDicType;
import io.renren.modules.sys.service.HDicTypeService;
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
@RequestMapping("hdictype")
public class HDicTypeController {
	@Autowired
	private HDicTypeService hDicTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("hdictype:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<HDicType> hDicTypeList = hDicTypeService.queryList(query);
		int total = hDicTypeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(hDicTypeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{dicTypeId}")
	@RequiresPermissions("hdictype:info")
	public R info(@PathVariable("dicTypeId") Integer dicTypeId){
		HDicType hDicType = hDicTypeService.queryObject(dicTypeId);
		
		return R.ok().put("hDicType", hDicType);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("hdictype:save")
	public R save(@RequestBody HDicType hDicType){
		hDicTypeService.save(hDicType);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("hdictype:update")
	public R update(@RequestBody HDicType hDicType){
		hDicTypeService.update(hDicType);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("hdictype:delete")
	public R delete(@RequestBody Integer[] dicTypeIds){
		hDicTypeService.deleteBatch(dicTypeIds);
		
		return R.ok();
	}

	/**
	 * 查询所有的 dicType 返回给 select2
	 */
	@RequestMapping("/queryAll")
	@AuthIgnore
	public R queryAll(){
		List<HDicType> hDicTypes = hDicTypeService.queryAll();
		return R.ok().put("hDicTypes",hDicTypes);
	}
}
