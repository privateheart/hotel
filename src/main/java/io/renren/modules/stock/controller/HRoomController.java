package io.renren.modules.stock.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.modules.stock.vo.HRoomVo;
import io.renren.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.stock.entity.HRoom;
import io.renren.modules.stock.service.HRoomService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;




/**
 * 厅房表
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-07 19:49:15
 */
@RestController
@RequestMapping("hroom")
public class HRoomController extends AbstractController{
	@Autowired
	private HRoomService hRoomService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("hroom:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<HRoomVo> hRoomList = hRoomService.queryHRoomVoList(query);
		int total = hRoomService.queryHRoomVoTotal(query);
		PageUtils pageUtil = new PageUtils(hRoomList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{roomId}")
	@RequiresPermissions("hroom:info")
	public R info(@PathVariable("roomId") Integer roomId){
		HRoom hRoom = hRoomService.queryObject(roomId);
		
		return R.ok().put("hRoom", hRoom);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("hroom:save")
	public R save(@RequestBody HRoom hRoom){
		hRoom.setCreateTime(new Date());
		hRoom.setCreator(getUser().getUserId().intValue());
        hRoom.setIsValid(1);
        hRoomService.save(hRoom);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("hroom:update")
	public R update(@RequestBody HRoom hRoom){
		hRoom.setModifier(getUser().getUserId().intValue());
		hRoom.setModifyTime(new Date());
		hRoomService.update(hRoom);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("hroom:delete")
	public R delete(@RequestBody Integer[] roomIds){
		hRoomService.deleteBatch(roomIds);
		return R.ok();
	}
	
}
