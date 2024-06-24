//package com.netsurfingzone.service.Impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.netsurfingzone.dto.Goods;
//import com.netsurfingzone.dto.Inventory;
//import com.netsurfingzone.dto.InventoryRecord;
//import com.netsurfingzone.mapper.InventoryRecordMapper;
//import com.netsurfingzone.service.IInventoryRecordService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * <p>
// *  服务实现类
// * </p>
// *
// * @author Jinxuan Chen
// * @since 2024-04-30
// */
//@Service
//public class InventoryRecordServiceImpl extends ServiceImpl<InventoryRecordMapper, InventoryRecord> implements IInventoryRecordService {
//
//    @Autowired
//    private InventoryServiceImpl inventoryService;
//
//    @Autowired
//    private GoodsServiceImpl goodsService;
//
//    @Autowired
//    private InventoryRecordServiceImpl recordService;
//    @Override
//    public List<InventoryRecord> findAllByWarehouseId(String id) {
//        LambdaQueryWrapper<InventoryRecord> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(InventoryRecord::getWid,id);
//        return listObjs(wrapper);
//    }
//
//    @Override
//    public List<InventoryRecord> findAllByGoodsId(String id) {
//        LambdaQueryWrapper<InventoryRecord> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(InventoryRecord::getCid,id);
//        return listObjs(wrapper);
//    }
//
//    @Override
//    public void in(InventoryRecord record) {
//        Goods goods = goodsService.getById(record.getCid());
//        if(goods == null)
//            throw new ServiceException(HttpStatus.NOT_FOUND.value(), "不存在的商品id");
//        goods.setCount(goods.getCount() + record.getCount());
//        goodsService.updateById(goods);
//
//        Inventory inventory = inventoryService.findByWidAndCid(record.getWid(),record.getCid());
//        if(inventory == null){
//            inventory = new Inventory();
//            inventory.setCid(record.getCid());
//            inventory.setWid(record.getWid());
//            inventory.setCount(0);
//            inventory.setDescription(record.getDescription());
//        }
//
//        inventory.setCount(inventory.getCount()+ record.getCount());
//        inventoryService.saveOrUpdate(inventory);
//
//        record.setCreateAt(DateTimeUtil.getNowTimeString());
//        record.setType(+1);
//        recordService.save(record);
//    }
//
//    @Override
//    public void out(InventoryRecord record) {
//        Inventory inventory = inventoryService.findByWidAndCid(record.getWid(),record.getCid());
//        if(inventory == null)
//            throw new ServiceException(HttpStatus.NOT_FOUND.value(), "仓库内不存在该商品");
//        if(inventory.getCount() < record.getCount())
//            throw new ServiceException(HttpStatus.FORBIDDEN.value(), "出库失败，库存数量不足");
//
//        Goods goods = goodsService.getById(record.getCid());
//        if(goods == null)
//            throw new ServiceException(HttpStatus.NOT_FOUND.value(), "不存在的商品id");
//        goods.setCount(goods.getCount() - record.getCount());
//        goodsService.updateById(goods);
//
//        inventory.setCount(inventory.getCount() - record.getCount());
//        inventoryService.saveOrUpdate(inventory);
//
//        record.setCreateAt(DateTimeUtil.getNowTimeString());
//        record.setType(-1);
//        recordService.save(record);
//    }
//
//}
