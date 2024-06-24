package com.netsurfingzone.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.netsurfingzone.dto.Warehouse;

/**
 * <p>
 * 仓库 Mapper 接口
 * </p>
 *
 * @author Jinxuan Chen
 * @since 2024-04-09
 */

public interface WarehouseMapper extends BaseMapper<Warehouse> {
    void deleteWarehouse(String id);
}
