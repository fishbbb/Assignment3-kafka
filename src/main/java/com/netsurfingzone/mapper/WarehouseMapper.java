package com.netsurfingzone.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.netsurfingzone.dto.Warehouse;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 仓库 Mapper 接口
 * </p>
 *
 * @author Jinxuan Chen
 * @since 2024-04-09
 */
@Mapper
public interface WarehouseMapper extends BaseMapper<Warehouse> {
    void deleteWarehouse(String id);
}
