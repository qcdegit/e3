package cn.e3.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.manager.service.TbItemService;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.DatagridPagebean;

@Service
@Transactional
public class TbItemServiceImpl implements TbItemService {

    @Autowired
    private TbItemMapper tbItemMapper;
    
    //根据id查询商品
    public TbItem findItemById(Long id) {
        return tbItemMapper.selectByPrimaryKey(id);
    }

    //分页查询商品信息
    public DatagridPagebean<TbItem> findTbItemByPage(Integer page, Integer rows) {
        //创建example对象
        TbItemExample example = new TbItemExample();
        //设置分页参数
        PageHelper.startPage(page, rows);
        //执行查询
        List<TbItem> list = tbItemMapper.selectByExample(example);
        //创建PageInfo对象,里面封装了分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        //创建DatagridPagebean封装查询结果
        DatagridPagebean<TbItem> pagebean = new DatagridPagebean<TbItem>();
        pagebean.setRows(list);
        pagebean.setTotal(pageInfo.getTotal());
        return pagebean;
    }

}
