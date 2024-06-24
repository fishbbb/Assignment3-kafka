//package com.netsurfingzone.service.Impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.netsurfingzone.dto.Goods;
//import com.netsurfingzone.service.IGoodsService;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class GoodsServiceImpl implements IGoodsService {
//    @Override
//    public void deleteGoods(String id) {
//        removeById(id);
//    }
//
//    @Override
//    public Goods getGoodsById(String id) {
//        return getById(id);
//    }
//
//    @Override
//    public List<Goods> getAllGoods() {
//        return list();
//    }
//
//    @Override
//    public List<Goods> findByLikeName(String name) {
//        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<>();
//        wrapper.like(Goods::getName,name);
//        return listObjs(wrapper);
//    }
//
//    @Override
//    public void addGoods(Goods good) {
//        if(getGoodsByName(good.getName()) != null)
//            throw new ServiceException(HttpStatus.FORBIDDEN.value(), "商品已存在");
//        good.setCount(0);
//        good.setCreateAt(DateTimeUtil.getNowTimeString());
//        save(good);
//    }
//
//    @Override
//    public Goods getGoodsByName(String name) {
//        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(Goods::getName,name);
//        return getOne(wrapper);
//    }
//
//    @Override
//    public void updateGoods(Goods good) {
//        if(getGoodsById(good.getId()) == null)
//            throw new ServiceException(HttpStatus.NOT_FOUND.value(), "该货物不存在");
//        updateById(good);
//    }
//}
