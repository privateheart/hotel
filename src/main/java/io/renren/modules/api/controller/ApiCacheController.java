package io.renren.modules.api.controller;


import io.renren.common.utils.R;
import io.renren.common.validator.Assert;
import io.renren.modules.api.annotation.AuthIgnore;
import io.renren.modules.api.service.TokenService;
import io.renren.modules.api.service.UserService;
import io.renren.modules.sys.service.HDicService;
import io.renren.modules.sys.vo.HDicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * API登录授权
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-23 15:31
 */
@RestController
@RequestMapping("/api")
public class ApiCacheController {
    @Autowired
    private HDicService hDicService;


    /**
     * 查询所都字典缓存到前端
     */
    @RequestMapping("/listAllDic")
    @AuthIgnore
    public R listAllDic(){
        //查询列表数据
        List<HDicVo> hDicVos = hDicService.queryAllDicVos();
        return R.ok().put("hDicVos",hDicVos);
    }

}
