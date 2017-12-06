package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.TbItemService;
import cn.e3.pojo.TbItem;
import cn.e3.utils.DatagridPagebean;

@Controller
public class TbItemController {

    @Autowired
    private TbItemService tbItemService;

    // 根据id查询商品
    @RequestMapping("item/list/{itemId}")
    @ResponseBody
    public TbItem findItemById(@PathVariable Long itemId) {
        TbItem tbItem = tbItemService.findItemById(itemId);
        return tbItem;
    }

    // 分页查询商品
    @RequestMapping("item/list")
    @ResponseBody
    public DatagridPagebean<TbItem> findTbItemByPage(@RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "30") Integer rows) {
        DatagridPagebean<TbItem> pagebean = tbItemService.findTbItemByPage(page, rows);
        return pagebean;
    }
}
