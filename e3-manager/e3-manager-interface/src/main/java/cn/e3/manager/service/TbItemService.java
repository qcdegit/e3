package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.utils.DatagridPagebean;

public interface TbItemService {
    //根据id查询商品
    public TbItem findItemById(Long id);
    
    //分页查询商品
    public DatagridPagebean<TbItem> findTbItemByPage(Integer page, Integer rows);
}
