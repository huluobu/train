package com.carrot.train.spring.mapper;

import com.pactera.spring.model.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description:
 * @author: Lance
 * @create: 2020-09-18
 **/
@Mapper
public interface StaffMapper extends BaseMapper {

    /**
     * 查询所有的员工列表
     * @return
     */
    List<Staff> selectStaff();

    @Select("SELECT * FROM staff" +
            " WHERE staffCode=#{staffCode} AND staffType=#{staffType}")
    Staff getStaffWithStaffCode(@Param("staffCode") String staffCode,
                                @Param("staffType") String staffType);
}
